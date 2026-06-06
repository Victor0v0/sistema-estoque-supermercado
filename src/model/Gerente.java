package model;

import pattern.observer.Observador;

/**
 * Classe que representa o ator Gerente do sistema.
 * Possui as maiores permissoes, podendo aprovar pedidos,
 * gerar relatorios e configurar alertas.
 * Implementa Observador para receber notificacoes do estoque.
 *
 * @author Miguel Expedito
 * @version 1.0
 */
public class Gerente extends Usuario implements Observador {

    /**
     * Nivel de acesso do gerente.
     */
    private String nivel;

    /**
     * Construtor da classe Gerente.
     *
     * @param id identificador do gerente
     * @param nome nome do gerente
     * @param senha senha do gerente
     * @param nivel nivel de acesso
     */
    public Gerente(int id, String nome, String senha, String nivel) {
        super(id, nome, senha);
        this.nivel = nivel;
    }

    /**
     * Aprova um pedido de compra no sistema.
     */
    public void aprovarPedido() {
        System.out.println("Gerente " + getNome() + " aprovou o pedido.");
    }

    /**
     * Gera um relatorio do estoque.
     */
    public void gerarRelatorio() {
        System.out.println("Gerente " + getNome() + " gerou o relatorio.");
    }

    /**
     * Configura um alerta de estoque minimo.
     */
    public void configurarAlerta() {
        System.out.println("Gerente " + getNome() + " configurou o alerta.");
    }

    /**
     * Recebe notificacao do estoque via padrao Observer.
     *
     * @param mensagem mensagem enviada pelo estoque
     */
    @Override
    public void atualizar(String mensagem) {
        System.out.println("Gerente " + getNome() +
            " notificado: " + mensagem);
    }

    /**
     * Retorna o nivel de acesso.
     *
     * @return nivel
     */
    public String getNivel() {
        return nivel;
    }
}