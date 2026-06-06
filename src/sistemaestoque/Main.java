package sistemaestoque;

import model.*;
import pattern.decorator.*;
import pattern.factory.*;
import pattern.strategy.*;

/**
 * Classe principal do sistema de gerenciamento
 * de estoque e logistica do supermercado.
 * Demonstra a aplicacao dos 5 padroes GoF:
 * Singleton, Factory Method, Observer,
 * Decorator e Strategy.
 *
 * @author Grupo
 * @version 1.0
 */
public class Main {

    /**
     * Metodo principal do sistema.
     * Executa a demonstracao de todos os padroes.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE ESTOQUE ===\n");

        // ==========================================
        // PADRAO 1: SINGLETON
        // Garante instancia unica do Estoque
        // ==========================================
        System.out.println("--- SINGLETON ---");
        Estoque estoque1 = Estoque.getInstancia();
        Estoque estoque2 = Estoque.getInstancia();
        System.out.println("Mesma instancia: " +
            (estoque1 == estoque2));

        // ==========================================
        // PADRAO 2: OBSERVER
        // Gerente e Analista recebem notificacoes
        // ==========================================
        System.out.println("\n--- OBSERVER ---");
        Gerente gerente = new Gerente(1, "Carlos",
            "senha123", "Senior");
        Analista analista = new Analista(2, "Ana",
            "senha456", "Logistica");

        estoque1.adicionarObservador(gerente);
        estoque1.adicionarObservador(analista);

        // ==========================================
        // PADRAO 3: FACTORY METHOD
        // Criacao centralizada de produtos
        // ==========================================
        System.out.println("\n--- FACTORY METHOD ---");
        Produto leite = ProdutoFactory.criar(
            "perecivel", 1, 5.99, 8,
            "Leite Integral", "31/12/2025");

        Produto arroz = ProdutoFactory.criar(
            "naoperecivel", 2, 12.50, 50,
            "Arroz Branco", "365");

        System.out.println(leite.obterDetalhes());
        System.out.println(arroz.obterDetalhes());

        // Adiciona produtos ao estoque
        // (Observer notifica automaticamente)
        System.out.println("\n--- ADICIONANDO AO ESTOQUE ---");
        estoque1.adicionarItem(leite);
        estoque1.adicionarItem(arroz);

        // ==========================================
        // PADRAO 4: DECORATOR
        // Adiciona desconto e alerta ao produto
        // ==========================================
        System.out.println("\n--- DECORATOR ---");
        ProdutoComDesconto leiteComDesconto =
            new ProdutoComDesconto(leite, 0.15);
        leiteComDesconto.aplicarDesconto();

        ProdutoComAlerta leiteComAlerta =
            new ProdutoComAlerta(leite, 10);
        leiteComAlerta.dispararAlerta();

        System.out.println(leiteComDesconto.obterDetalhes());

        // ==========================================
        // PADRAO 5: STRATEGY
        // Troca algoritmo de calculo em tempo real
        // ==========================================
        System.out.println("\n--- STRATEGY ---");
        Movimentacao mov = new Movimentacao(
            1, "compra", "01/06/2026",
            20, "Auxiliar Joao", 5.99);

        // Estrategia 1: calculo por quantidade
        mov.setEstrategia(new CalculoPorQuantidade(1.0));
        mov.calcularGasto();

        // Estrategia 2: troca para calculo por lote
        mov.setEstrategia(new CalculoPorLote(5));
        mov.calcularGasto();

        mov.registrar();

        // ==========================================
        // OUTROS ATORES DO SISTEMA
        // ==========================================
        System.out.println("\n--- ATORES ---");
        AuxiliarLogistico aux = new AuxiliarLogistico(
            3, "João", "senha789", "Manha");
        aux.rastrearProduto(1);
        aux.notificarEnvio(1);
        gerente.aprovarPedido();
        analista.visualizarEstoque();

        System.out.println("\n=== FIM DO SISTEMA ===");
    }
}