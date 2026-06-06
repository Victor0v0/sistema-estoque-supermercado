package model;

import pattern.observer.Observador;
import pattern.observer.Observavel;
import pattern.strategy.EstrategiaCalculo;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa o estoque do supermercado.
 * Implementa o padrao Singleton garantindo uma unica
 * instancia durante toda a execucao do sistema.
 * Implementa o padrao Observer notificando Gerente
 * e Analista sobre mudancas no estoque.
 *
 * @author Alison
 * @version 1.0
 */
public class Estoque implements Observavel {

    /**
     * Unica instancia da classe Estoque (Singleton).
     */
    private static Estoque instancia;

    /**
     * Identificador do estoque.
     */
    private int id;

    /**
     * Capacidade maxima do estoque.
     */
    private int capacidadeMax;

    /**
     * Localizacao fisica do estoque.
     */
    private String localizacao;

    /**
     * Lista de observadores cadastrados.
     */
    private List<Observador> observadores;

    /**
     * Lista de produtos no estoque.
     */
    private List<Produto> produtos;

    /**
     * Construtor privado — padrao Singleton.
     * Impede instanciacao direta da classe.
     */
    private Estoque() {
        this.observadores = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.capacidadeMax = 1000;
        this.localizacao = "Deposito Principal";
    }

    /**
     * Retorna a unica instancia do Estoque.
     * Cria a instancia caso ainda nao exista.
     *
     * @return instancia unica de Estoque
     */
    public static Estoque getInstancia() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }

    /**
     * Adiciona um produto ao estoque.
     * Notifica observadores se capacidade maxima
     * for atingida.
     *
     * @param produto produto a ser adicionado
     */
    public void adicionarItem(Produto produto) {
        if (produtos.size() >= capacidadeMax) {
            notificarObservadores(
                "Estoque cheio! Capacidade maxima atingida.");
        } else {
            produtos.add(produto);
            System.out.println("Produto adicionado: " +
                produto.getNome());
            if (produto.getQuantidade() <= 10) {
                notificarObservadores(
                    "Estoque baixo para: " +
                    produto.getNome());
            }
        }
    }

    /**
     * Verifica a capacidade atual do estoque.
     *
     * @return numero de produtos no estoque
     */
    public int verificarCapacidade() {
        return produtos.size();
    }

    /**
     * Adiciona um observador a lista de notificacoes.
     *
     * @param observador objeto que deseja ser notificado
     */
    @Override
    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
        System.out.println("Observador adicionado: " +
            observador.getClass().getSimpleName());
    }

    /**
     * Notifica todos os observadores cadastrados.
     *
     * @param mensagem mensagem a ser enviada
     */
    @Override
    public void notificarObservadores(String mensagem) {
        if (observadores.isEmpty()) {
            System.out.println(
                "Nenhum observador cadastrado.");
            return;
        }
        for (Observador obs : observadores) {
            obs.atualizar(mensagem);
        }
    }

    /**
     * Retorna a lista de produtos no estoque.
     *
     * @return lista de produtos
     */
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Retorna a capacidade maxima do estoque.
     *
     * @return capacidadeMax
     */
    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    /**
     * Define a capacidade maxima do estoque.
     *
     * @param capacidadeMax nova capacidade
     */
    public void setCapacidadeMax(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    /**
     * Retorna a localizacao do estoque.
     *
     * @return localizacao
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * Define a localizacao do estoque.
     *
     * @param localizacao nova localizacao
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}