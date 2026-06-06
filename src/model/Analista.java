package model;

import pattern.observer.Observador;

/**
 * Classe que representa o ator Analista do sistema.
 * Responsavel por visualizar estoque, cadastrar produtos,
 * imprimir etiquetas e verificar validade.
 * Implementa Observador para receber notificacoes do estoque.
 *
 * @author Miguel Expedito
 * @version 1.0
 */
public class Analista extends Usuario implements Observador {

    /**
     * Setor de atuacao do analista.
     */
    private String setor;

    /**
     * Construtor da classe Analista.
     *
     * @param id identificador do analista
     * @param nome nome do analista
     * @param senha senha do analista
     * @param setor setor de atuacao
     */
    public Analista(int id, String nome, String senha, String setor) {
        super(id, nome, senha);
        this.setor = setor;
    }

    /**
     * Visualiza o estoque atual do sistema.
     */
    public void visualizarEstoque() {
        System.out.println("Analista " + getNome() +
            " visualizando estoque.");
    }

    /**
     * Cadastra um novo produto no sistema.
     */
    public void cadastrarProduto() {
        System.out.println("Analista " + getNome() +
            " cadastrou produto.");
    }

    /**
     * Imprime a etiqueta de um produto.
     */
    public void imprimirEtiqueta() {
        System.out.println("Analista " + getNome() +
            " imprimiu etiqueta.");
    }

    /**
     * Recebe notificacao do estoque via padrao Observer.
     *
     * @param mensagem mensagem enviada pelo estoque
     */
    @Override
    public void atualizar(String mensagem) {
        System.out.println("Analista " + getNome() +
            " notificado: " + mensagem);
    }

    /**
     * Retorna o setor do analista.
     *
     * @return setor
     */
    public String getSetor() {
        return setor;
    }
}