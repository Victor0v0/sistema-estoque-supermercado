package pattern.decorator;

import model.Produto;

/**
 * Decorator que adiciona funcionalidade de alerta
 * de estoque minimo a um produto existente.
 * Dispara um alerta quando a quantidade do produto
 * atingir o estoque minimo configurado.
 *
 * @author Victor
 * @version 1.0
 */
public class ProdutoComAlerta extends ProdutoDecorator {

    /**
     * Quantidade minima que dispara o alerta.
     */
    private int estoqueMinimo;

    /**
     * Construtor da classe ProdutoComAlerta.
     *
     * @param produto produto a ser decorado
     * @param estoqueMinimo quantidade minima para alerta
     */
    public ProdutoComAlerta(Produto produto, int estoqueMinimo) {
        super(produto);
        this.estoqueMinimo = estoqueMinimo;
    }

    /**
     * Verifica se a quantidade do produto atingiu
     * o estoque minimo e dispara o alerta.
     */
    public void dispararAlerta() {
        if (produto.getQuantidade() <= estoqueMinimo) {
            System.out.println("ALERTA: Produto " +
                produto.getNome() +
                " atingiu estoque minimo! " +
                "Quantidade atual: " +
                produto.getQuantidade());
        } else {
            System.out.println("Produto " +
                produto.getNome() +
                " com estoque normal. Quantidade: " +
                produto.getQuantidade());
        }
    }

    /**
     * Retorna detalhes do produto com informacao de alerta.
     *
     * @return detalhes com estoque minimo
     */
    @Override
    public String obterDetalhes() {
        return produto.obterDetalhes() +
            " | Estoque minimo: " + estoqueMinimo;
    }

    /**
     * Retorna o estoque minimo configurado.
     *
     * @return estoqueMinimo
     */
    public int getEstoqueMinimo() { return estoqueMinimo; }

    /**
     * Define o estoque minimo.
     *
     * @param estoqueMinimo novo estoque minimo
     */
    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }
}