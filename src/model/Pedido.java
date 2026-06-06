package model;

/**
 * Classe que representa um pedido de compra do sistema.
 * Associada a Movimentacao para registro de gastos
 * e controle de status.
 *
 * @author Alison
 * @version 1.0
 */
public class Pedido {

    /**
     * Identificador do pedido.
     */
    private int id;

    /**
     * Data de criacao do pedido.
     */
    private String dataPedido;

    /**
     * Status atual do pedido.
     * Valores: "aberto", "aprovado", "cancelado"
     */
    private String status;

    /**
     * Construtor da classe Pedido.
     *
     * @param id identificador do pedido
     * @param dataPedido data de criacao
     */
    public Pedido(int id, String dataPedido) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.status = "aberto";
    }

    /**
     * Cria e registra o pedido no sistema.
     */
    public void criarPedido() {
        System.out.println("Pedido " + id +
            " criado em " + dataPedido);
    }

    /**
     * Cancela o pedido alterando seu status.
     */
    public void cancelarPedido() {
        this.status = "cancelado";
        System.out.println("Pedido " + id + " cancelado.");
    }

    /**
     * Retorna o status atual do pedido.
     *
     * @return status do pedido
     */
    public String obterStatus() {
        return status;
    }

    /**
     * Aprova o pedido alterando seu status.
     */
    public void aprovarPedido() {
        this.status = "aprovado";
        System.out.println("Pedido " + id + " aprovado.");
    }

    /**
     * Retorna o id do pedido.
     *
     * @return id
     */
    public int getId() { return id; }

    /**
     * Retorna a data do pedido.
     *
     * @return dataPedido
     */
    public String getDataPedido() { return dataPedido; }

    /**
     * Define o status do pedido.
     *
     * @param status novo status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}