package pattern.factory;

import model.Produto;

/**
 * Classe que representa um produto perecivel.
 * Possui data de validade e verifica se o produto
 * esta dentro do prazo de consumo.
 * Criada pelo ProdutoFactory — padrao Factory Method.
 *
 * @author Vinicius
 * @version 1.0
 */
public class ProdutoPerecivel extends Produto {

    /**
     * Data de validade do produto.
     */
    private String validade;

    /**
     * Construtor da classe ProdutoPerecivel.
     *
     * @param lote numero do lote
     * @param preco preco unitario
     * @param quantidade quantidade em estoque
     * @param nome nome do produto
     * @param validade data de validade
     */
    public ProdutoPerecivel(int lote, double preco,
            int quantidade, String nome, String validade) {
        super(lote, preco, quantidade, nome);
        this.validade = validade;
    }

    /**
     * Verifica se o produto esta dentro da validade.
     *
     * @return true se valido, false se vencido
     */
    public boolean verificarVencimento() {
        System.out.println("Verificando vencimento: " + validade);
        return true;
    }

    /**
     * Retorna os detalhes do produto perecivel.
     *
     * @return descricao com validade
     */
    @Override
    public String obterDetalhes() {
        return "Produto Perecivel: " + getNome() +
            " | Validade: " + validade;
    }

    /**
     * Valida se o produto esta dentro do prazo.
     *
     * @return true se valido
     */
    @Override
    public boolean validarValidade() {
        return verificarVencimento();
    }

    /**
     * Retorna a validade do produto.
     *
     * @return validade
     */
    public String getValidade() { return validade; }

    /**
     * Define a validade do produto.
     *
     * @param validade nova validade
     */
    public void setValidade(String validade) {
        this.validade = validade;
    }
}