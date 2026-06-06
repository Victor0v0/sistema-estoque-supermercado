package model;

/**
 * Classe que representa o ator Auxiliar Logistico do sistema.
 * Responsavel por rastrear produtos, notificar envios
 * e visualizar quantidades em estoque.
 *
 * @author Miguel Expedito
 * @version 1.0
 */
public class AuxiliarLogistico extends Usuario {

    /**
     * Turno de trabalho do auxiliar logistico.
     */
    private String turno;

    /**
     * Construtor da classe AuxiliarLogistico.
     *
     * @param id identificador do auxiliar
     * @param nome nome do auxiliar
     * @param senha senha do auxiliar
     * @param turno turno de trabalho
     */
    public AuxiliarLogistico(int id, String nome,
            String senha, String turno) {
        super(id, nome, senha);
        this.turno = turno;
    }

    /**
     * Rastreia a localizacao de um produto no estoque.
     *
     * @param produtoId id do produto a rastrear
     */
    public void rastrearProduto(int produtoId) {
        System.out.println("Rastreando produto ID: " + produtoId);
    }

    /**
     * Notifica o envio de um produto.
     *
     * @param produtoId id do produto enviado
     */
    public void notificarEnvio(int produtoId) {
        System.out.println("Envio notificado para produto ID: "
            + produtoId);
    }

    /**
     * Visualiza a quantidade disponivel de um produto.
     *
     * @param produtoId id do produto
     */
    public void visualizarQuantidade(int produtoId) {
        System.out.println("Visualizando quantidade do produto ID: "
            + produtoId);
    }

    /**
     * Retorna o turno de trabalho.
     *
     * @return turno
     */
    public String getTurno() {
        return turno;
    }
}