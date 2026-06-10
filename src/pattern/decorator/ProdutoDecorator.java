package pattern.decorator;

import model.Produto;

/**
 * Classe abstrata base do padrao Decorator.
 * Permite adicionar responsabilidades a um Produto
 * dinamicamente sem criar subclasses para cada combinacao.
 * 
 * Padrao aplicado: Decorator
 * Categoria: Estrutural
 * Problema resolvido: evita a explosao de subclasses ao
 * adicionar funcionalidades como desconto e alerta de forma
 * independente e combinavel.
 * 
 * Exemplo de uso:
 * Produto p = ProdutoFactory.criar("perecivel", ...);
 * Produto comDesconto = new ProdutoComDesconto(p, 0.10);
 * Produto comAlerta = new ProdutoComAlerta(comDesconto, 5);
 *
 * @author Victor
 * @version 1.0
 */
public abstract class ProdutoDecorator extends Produto {

    /**
     * Produto que sera decorado.
     */
    protected Produto produto;

    /**
     * Construtor da classe ProdutoDecorator.
     *
     * @param produto produto a ser decorado
     */
    public ProdutoDecorator(Produto produto) {
        super(produto.getLote(), produto.getPreco(),
              produto.getQuantidade(), produto.getNome());
        this.produto = produto;
    }

    /**
     * Retorna os detalhes do produto decorado.
     *
     * @return detalhes do produto
     */
    @Override
    public String obterDetalhes() {
        return produto.obterDetalhes();
    }

    /**
     * Valida a validade do produto decorado.
     *
     * @return true se valido
     */
    @Override
    public boolean validarValidade() {
        return produto.validarValidade();
    }
}