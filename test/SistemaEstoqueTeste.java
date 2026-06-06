import model.*;
import pattern.decorator.*;
import pattern.factory.*;
import pattern.observer.*;
import pattern.strategy.*;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Classe de testes unitarios do Sistema de Estoque.
 * Contempla 15 casos de teste cobrindo cenarios
 * validos, alternativos e de excecao.
 * Utiliza stubs para simulacao de dependencias.
 *
 * @author Grupo
 * @version 1.0
 */
public class SistemaEstoqueTeste {

    private Produto produtoPerecivel;
    private Produto produtoNaoPerecivel;
    private Estoque estoque;
    private Movimentacao movimentacao;

    @Before
    public void setUp() {
        produtoPerecivel = ProdutoFactory.criar(
            "perecivel", 1, 10.0, 20,
            "Leite", "31/12/2025");
        produtoNaoPerecivel = ProdutoFactory.criar(
            "naoperecivel", 2, 25.0, 50,
            "Arroz", "365");
        estoque = Estoque.getInstancia();
        movimentacao = new Movimentacao(
            1, "compra", "01/06/2026",
            10, "Joao", 10.0);
    }

    @Test
    public void CT01_loginGerenteValido() {
        Gerente gerente = new Gerente(
            1, "Carlos", "senha123", "Senior");
        assertTrue(gerente.login("Carlos", "senha123"));
    }

    @Test
    public void CT02_factoryMethodCriaProdutoPerecivel() {
        assertNotNull(produtoPerecivel);
        assertEquals("Leite", produtoPerecivel.getNome());
        assertEquals(10.0, produtoPerecivel.getPreco(), 0.001);
    }

    @Test
    public void CT03_singletonRetornaMesmaInstancia() {
        Estoque e1 = Estoque.getInstancia();
        Estoque e2 = Estoque.getInstancia();
        assertSame(e1, e2);
    }

    @Test
    public void CT04_strategyCalculoPorQuantidade() {
        movimentacao.setEstrategia(
            new CalculoPorQuantidade(1.0));
        double resultado = movimentacao.calcularGasto();
        assertEquals(100.0, resultado, 0.001);
    }

    @Test
    public void CT05_decoratorAplicaDesconto() {
        ProdutoComDesconto pd =
            new ProdutoComDesconto(produtoPerecivel, 0.10);
        double precoComDesconto = pd.aplicarDesconto();
        assertEquals(9.0, precoComDesconto, 0.001);
    }

    @Test
    public void CT06_loginComSenhaIncorreta() {
        Analista analista = new Analista(
            2, "Ana", "senha456", "Logistica");
        assertFalse(analista.login("Ana", "senhaErrada"));
    }

    @Test
    public void CT07_factoryMethodCriaProdutoNaoPerecivel() {
        assertNotNull(produtoNaoPerecivel);
        assertEquals("Arroz", produtoNaoPerecivel.getNome());
        assertTrue(produtoNaoPerecivel.validarValidade());
    }

    @Test
    public void CT08_strategyCalculoPorLote() {
        movimentacao.setEstrategia(new CalculoPorLote(5));
        double resultado = movimentacao.calcularGasto();
        assertEquals(20.0, resultado, 0.001);
    }

    @Test
    public void CT09_observerNotificaComEstoqueBaixo() {
        final boolean[] notificado = {false};
        Observador stubObservador = mensagem -> {
            notificado[0] = true;
        };
        estoque.adicionarObservador(stubObservador);
        Produto produtoBaixo = ProdutoFactory.criar(
            "perecivel", 3, 5.0, 5,
            "Iogurte", "15/12/2025");
        estoque.adicionarItem(produtoBaixo);
        assertTrue(notificado[0]);
    }

    @Test
    public void CT10_strategyTrocaEstrategia() {
        movimentacao.setEstrategia(
            new CalculoPorQuantidade(1.0));
        double resultado1 = movimentacao.calcularGasto();
        movimentacao.setEstrategia(new CalculoPorLote(5));
        double resultado2 = movimentacao.calcularGasto();
        assertNotEquals(resultado1, resultado2, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void CT11_factoryTipoInvalido() {
        ProdutoFactory.criar(
            "invalido", 1, 10.0,
            10, "Produto", "extra");
    }

    @Test
    public void CT12_estoqueCapacidadeMaxima() {
        final boolean[] notificado = {false};
        Observador stubObservador = mensagem -> {
            if (mensagem.contains("cheio")) {
                notificado[0] = true;
            }
        };
        Estoque estoqueTest = Estoque.getInstancia();
        estoqueTest.adicionarObservador(stubObservador);
        estoqueTest.setCapacidadeMax(0);
        Produto p = ProdutoFactory.criar(
            "perecivel", 9, 5.0, 5,
            "Teste", "01/01/2026");
        estoqueTest.adicionarItem(p);
        assertTrue(notificado[0]);
    }

    @Test(expected = IllegalStateException.class)
    public void CT13_strategySemEstrategiaDefinida() {
        Movimentacao mov = new Movimentacao(
            2, "saida", "01/06/2026",
            5, "Maria", 10.0);
        mov.calcularGasto();
    }

    @Test
    public void CT14_loginComNomeNulo() {
        Gerente gerente = new Gerente(
            1, "Carlos", "senha123", "Senior");
        assertFalse(gerente.login(null, "senha123"));
    }

    @Test
    public void CT15_decoratorAlertaNaoDisparaComEstoqueNormal() {
        Produto produtoNormal = ProdutoFactory.criar(
            "naoperecivel", 5, 15.0, 100,
            "Feijao", "730");
        ProdutoComAlerta pa =
            new ProdutoComAlerta(produtoNormal, 10);
        assertEquals("Feijao", pa.getNome());
        assertTrue(pa.getQuantidade() > pa.getEstoqueMinimo());
    }
}