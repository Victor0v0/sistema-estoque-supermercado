package pattern.factory;

import model.Produto;

/**
 * Classe que representa um produto nao perecivel.
 * Possui durabilidade em dias e nao possui data
 * de vencimento critica.
 * Criada pelo ProdutoFactory — padrao Factory Method.
 *
 * @author Vinicius
 * @version 1.0
 */
public class ProdutoNaoPerecivel extends Produto {

    /**
     * Durabilidade do produto em dias.
     */
    private int durabilidade;

    /**
     * Construtor da classe ProdutoNaoPerecivel.
     *
     * @param lote numero do lote
     * @param preco preco unitario
     * @param quantidade quantidade em estoque
     * @param nome nome do produto
     * @param durabilidade durabilidade em dias
     */
    public ProdutoNaoPerecivel(int lote, double preco,
            int quantidade, String nome, int durabilidade) {
        super(lote, preco, quantidade, nome);
        this.durabilidade = durabilidade;
    }

    /**
     * Retorna informacoes sobre o produto nao perecivel.
     *
     * @return informacoes do produto
     */
    public String getInfo() {
        return "Produto Nao Perecivel: " + getNome() +
            " | Durabilidade: " + durabilidade + " dias";
    }

    /**
     * Retorna os detalhes do produto.
     *
     * @return descricao com durabilidade
     */
    @Override
    public String obterDetalhes() {
        return getInfo();
    }

    /**
     * Produto nao perecivel sempre valido.
     *
     * @return true sempre
     */
    @Override
    public boolean validarValidade() {
        return true;
    }

    /**
     * Retorna a durabilidade em dias.
     *
     * @return durabilidade
     */
    public int getDurabilidade() { return durabilidade; }

    /**
     * Define a durabilidade em dias.
     *
     * @param durabilidade nova durabilidade
     */
    public void setDurabilidade(int durabilidade) {
        this.durabilidade = durabilidade;
    }
}