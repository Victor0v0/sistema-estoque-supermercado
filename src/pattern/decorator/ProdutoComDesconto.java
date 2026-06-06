package pattern.decorator;

import model.Produto;

/**
 * Decorator que adiciona funcionalidade de desconto
 * a um produto existente.
 * Implementa o padrao Decorator adicionando comportamento
 * sem alterar a classe original.
 *
 * @author Victor
 * @version 1.0
 */
public class ProdutoComDesconto extends ProdutoDecorator {

    /**
     * Percentual de desconto aplicado ao produto.
     * Exemplo: 0.10 representa 10% de desconto.
     */
    private double desconto;

    /**
     * Construtor da classe ProdutoComDesconto.
     *
     * @param produto produto a ser decorado
     * @param desconto percentual de desconto (0.0 a 1.0)
     */
    public ProdutoComDesconto(Produto produto, double desconto) {
        super(produto);
        this.desconto = desconto;
    }

    /**
     * Aplica o desconto sobre o preco do produto.
     *
     * @return preco com desconto aplicado
     */
    public double aplicarDesconto() {
        double precoComDesconto = produto.getPreco() *
            (1 - desconto);
        System.out.println("Produto: " + produto.getNome() +
            " | Preco original: R$" + produto.getPreco() +
            " | Desconto: " + (desconto * 100) + "%" +
            " | Preco final: R$" + precoComDesconto);
        return precoComDesconto;
    }

    /**
     * Retorna detalhes do produto com informacao de desconto.
     *
     * @return detalhes com desconto
     */
    @Override
    public String obterDetalhes() {
        return produto.obterDetalhes() +
            " | Desconto: " + (desconto * 100) + "%";
    }

    /**
     * Retorna o percentual de desconto.
     *
     * @return desconto
     */
    public double getDesconto() { return desconto; }

    /**
     * Define o percentual de desconto.
     *
     * @param desconto novo desconto
     */
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}