package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsavel pelo rastreamento de produtos
 * no estoque do supermercado.
 * Registra e consulta o historico de movimentacoes
 * de cada produto.
 *
 * @author Miguel Santos
 * @version 1.0
 */
public class Rastreamento {

    /**
     * Identificador do rastreamento.
     */
    private int id;

    /**
     * Localizacao atual do produto rastreado.
     */
    private String localizacaoAtual;

    /**
     * Data e hora do ultimo registro.
     */
    private String dataHora;

    /**
     * Historico de movimentacoes do produto.
     */
    private List<String> historico;

    /**
     * Construtor da classe Rastreamento.
     *
     * @param id identificador do rastreamento
     * @param localizacaoAtual localizacao inicial
     * @param dataHora data e hora do registro
     */
    public Rastreamento(int id, String localizacaoAtual,
            String dataHora) {
        this.id = id;
        this.localizacaoAtual = localizacaoAtual;
        this.dataHora = dataHora;
        this.historico = new ArrayList<>();
    }

    /**
     * Rastreia a localizacao atual do produto.
     *
     * @return localizacao atual
     */
    public String rastrear() {
        System.out.println("Localizacao atual: " +
            localizacaoAtual);
        return localizacaoAtual;
    }

    /**
     * Registra uma nova movimentacao no historico.
     *
     * @param movimento descricao da movimentacao
     */
    public void registrarMovimento(String movimento) {
        historico.add(dataHora + " - " + movimento);
        System.out.println("Movimento registrado: " +
            movimento);
    }

    /**
     * Retorna o historico completo de movimentacoes.
     *
     * @return lista de movimentacoes
     */
    public List<String> obterHistorico() {
        return historico;
    }

    /**
     * Retorna o id do rastreamento.
     *
     * @return id
     */
    public int getId() { return id; }

    /**
     * Retorna a localizacao atual.
     *
     * @return localizacaoAtual
     */
    public String getLocalizacaoAtual() {
        return localizacaoAtual;
    }

    /**
     * Define a localizacao atual.
     *
     * @param localizacaoAtual nova localizacao
     */
    public void setLocalizacaoAtual(String localizacaoAtual) {
        this.localizacaoAtual = localizacaoAtual;
    }

    /**
     * Retorna a data e hora do registro.
     *
     * @return dataHora
     */
    public String getDataHora() { return dataHora; }
}