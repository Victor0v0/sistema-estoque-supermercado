package model;

import pattern.observer.Observador;

/**
 * Classe abstrata que representa um usuario do sistema.
 * Serve como base para os atores Gerente, Analista
 * e AuxiliarLogistico.
 *
 * @author Miguel Expedito
 * @version 1.0
 */
public abstract class Usuario {

    /**
     * Identificador unico do usuario.
     */
    private int id;

    /**
     * Nome completo do usuario.
     */
    private String nome;

    /**
     * Senha de acesso ao sistema.
     */
    private String senha;

    /**
     * Construtor da classe Usuario.
     *
     * @param id identificador do usuario
     * @param nome nome do usuario
     * @param senha senha do usuario
     */
    public Usuario(int id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    /**
     * Realiza o login do usuario no sistema.
     *
     * @param nome nome informado
     * @param senha senha informada
     * @return true se login valido, false caso contrario
     */
    public boolean login(String nome, String senha) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }

    /**
     * Realiza o logout do usuario.
     */
    public void logout() {
        System.out.println(nome + " saiu do sistema.");
    }

    /**
     * Retorna o id do usuario.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nome do usuario.
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuario.
     *
     * @param nome novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}