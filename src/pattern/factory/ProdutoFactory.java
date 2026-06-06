package pattern.factory;

import model.Produto;

/**
 * Classe responsavel pela criacao de produtos.
 * Implementa o padrao Factory Method centralizando
 * a logica de instanciacao dos tipos de produto.
 * Evita o uso direto de "new" pelo codigo cliente.
 *
 * @author Vinicius
 * @version 1.0
 */
public class ProdutoFactory {

    /**
     * Cria um produto de acordo com o tipo informado.
     * Tipos validos: "perecivel" ou "naoperecivel".
     *
     * @param tipo tipo do produto a ser criado
     * @param lote numero do lote
     * @param preco preco unitario
     * @param quantidade quantidade em estoque
     * @param nome nome do produto
     * @param extra validade (perecivel) ou
     *             durabilidade em dias (naoperecivel)
     * @return instancia de Produto criada
     * @throws IllegalArgumentException se tipo invalido
     */
    public static Produto criar(String tipo, int lote,
            double preco, int quantidade,
            String nome, String extra) {
        switch (tipo.toLowerCase()) {
            case "perecivel":
                return new ProdutoPerecivel(lote, preco,
                    quantidade, nome, extra);
            case "naoperecivel":
                return new ProdutoNaoPerecivel(lote, preco,
                    quantidade, nome,
                    Integer.parseInt(extra));
            default:
                throw new IllegalArgumentException(
                    "Tipo de produto invalido: " + tipo);
        }
    }
}