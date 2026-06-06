package model;

import pattern.strategy.EstrategiaCalculo;

/**
 * Classe que representa uma movimentacao no estoque.
 * Implementa o padrao Strategy permitindo diferentes
 * algoritmos de calculo de gasto em tempo de execucao.
 *
 * @author Miguel Santos
 * @version 1.0
 */
public class Movimentacao {

    /**
     * Identificador da movimentacao.
     */
    private int id;

    /**
     * Tipo da movimentacao: entrada, saida,
     * transferencia, compra ou descarte.
     */
    private String tipo;

    /**
     * Data e hora da movimentacao.
     */
    private String dataHora;

    /**
     * Quantidade de itens movimentados.
     */
    private int quantidade;

    /**
     * Nome do responsavel pela movimentacao.
     */
    private String responsavel;

    /**
     * Valor unitario do produto movimentado.
     */
    private double valorUnitario;

    /**
     * Valor total calculado da movimentacao.
     */
    private double valorTotal;

    /**
     * Estrategia de calculo utilizada — padrao Strategy.
     */
    private EstrategiaCalculo estrategia;

    /**
     * Construtor da classe Movimentacao.
     *
     * @param id identificador
     * @param tipo tipo da movimentacao
     * @param dataHora data e hora
     * @param quantidade quantidade de itens
     * @param responsavel responsavel pela movimentacao
     * @param valorUnitario valor unitario do produto
     */
    public Movimentacao(int id, String tipo, String dataHora,
            int quantidade, String responsavel,
            double valorUnitario) {
        this.id = id;
        this.tipo = tipo;
        this.dataHora = dataHora;
        this.quantidade = quantidade;
        this.responsavel = responsavel;
        this.valorUnitario = valorUnitario;
    }

    /**
     * Registra a movimentacao no sistema.
     */
    public void registrar() {
        System.out.println("Movimentacao registrada: " +
            tipo + " | Qtd: " + quantidade +
            " | Responsavel: " + responsavel);
    }

    /**
     * Calcula o gasto da movimentacao utilizando
     * a estrategia de calculo configurada.
     *
     * @return valor total calculado
     * @throws IllegalStateException se nenhuma
     *         estrategia foi configurada
     */
    public double calcularGasto() {
        if (estrategia == null) {
            throw new IllegalStateException(
                "Nenhuma estrategia de calculo definida.");
        }
        valorTotal = estrategia.calcular(
            quantidade, valorUnitario);
        System.out.println("Gasto calculado: R$" + valorTotal);
        return valorTotal;
    }

    /**
     * Define a estrategia de calculo — padrao Strategy.
     * Permite trocar o algoritmo em tempo de execucao.
     *
     * @param estrategia nova estrategia de calculo
     */
    public void setEstrategia(EstrategiaCalculo estrategia) {
        this.estrategia = estrategia;
        System.out.println("Estrategia definida: " +
            estrategia.getClass().getSimpleName());
    }

    /**
     * Retorna o valor total da movimentacao.
     *
     * @return valorTotal
     */
    public double getValorTotal() { return valorTotal; }

    /**
     * Retorna o id da movimentacao.
     *
     * @return id
     */
    public int getId() { return id; }

    /**
     * Retorna o tipo da movimentacao.
     *
     * @return tipo
     */
    public String getTipo() { return tipo; }

    /**
     * Retorna a quantidade movimentada.
     *
     * @return quantidade
     */
    public int getQuantidade() { return quantidade; }

    /**
     * Define a quantidade movimentada.
     *
     * @param quantidade nova quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Retorna o valor unitario.
     *
     * @return valorUnitario
     */
    public double getValorUnitario() { return valorUnitario; }

    /**
     * Define o valor unitario.
     *
     * @param valorUnitario novo valor unitario
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * Retorna o responsavel pela movimentacao.
     *
     * @return responsavel
     */
    public String getResponsavel() { return responsavel; }

    /**
     * Retorna a data e hora da movimentacao.
     *
     * @return dataHora
     */
    public String getDataHora() { return dataHora; }
}