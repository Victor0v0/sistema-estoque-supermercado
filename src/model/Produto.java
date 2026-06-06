package model;

/**
 * Classe abstrata que representa um produto do supermercado.
 * Serve como base para ProdutoPerecivel e ProdutoNaoPerecivel.
 * Utilizada pelo padrao Factory Method e Decorator.
 *
 * @author Vinicius
 * @version 1.0
 */
public abstract class Produto {

    /**
     * Numero do lote do produto.
     */
    private int lote;

    /**
     * Preco unitario do produto.
     */
    private double preco;

    /**
     * Quantidade disponivel em estoque.
     */
    private int quantidade;

    /**
     * Nome do produto.
     */
    private String nome;

    /**
     * Construtor da classe Produto.
     *
     * @param lote numero do lote
     * @param preco preco unitario
     * @param quantidade quantidade em estoque
     * @param nome nome do produto
     */
    public Produto(int lote, double preco,
            int quantidade, String nome) {
        this.lote = lote;
        this.preco = preco;
        this.quantidade = quantidade;
        this.nome = nome;
    }

    /**
     * Retorna os detalhes do produto.
     *
     * @return descricao do produto
     */
    public abstract String obterDetalhes();

    /**
     * Valida a validade do produto.
     *
     * @return true se valido, false caso contrario
     */
    public abstract boolean validarValidade();

    /**
     * Imprime a etiqueta do produto.
     */
    public void imprimirEtiqueta() {
        System.out.println("Etiqueta: " + nome +
            " | Lote: " + lote +
            " | Preco: R$" + preco);
    }

    /**
     * Retorna o lote do produto.
     * @return lote
     */
    public int getLote() { return lote; }

    /**
     * Retorna o preco do produto.
     * @return preco
     */
    public double getPreco() { return preco; }

    /**
     * Define o preco do produto.
     * @param preco novo preco
     */
    public void setPreco(double preco) { this.preco = preco; }

    /**
     * Retorna a quantidade em estoque.
     * @return quantidade
     */
    public int getQuantidade() { return quantidade; }

    /**
     * Define a quantidade em estoque.
     * @param quantidade nova quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Retorna o nome do produto.
     * @return nome
     */
    public String getNome() { return nome; }

    /**
     * Define o nome do produto.
     * @param nome novo nome
     */
    public void setNome(String nome) { this.nome = nome; }
}