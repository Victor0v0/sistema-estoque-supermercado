package pattern.observer;

/**
 * Interface que define o contrato para os objetos observaveis.
 * Implementada pela classe Estoque, permitindo que observadores
 * sejam adicionados e notificados.
 *
 * @author Murilo
 * @version 1.0
 */
public interface Observavel {

    /**
     * Adiciona um observador a lista de notificacoes.
     *
     * @param observador objeto que deseja receber notificacoes
     */
    void adicionarObservador(Observador observador);

    /**
     * Notifica todos os observadores cadastrados
     * sobre uma mudanca no estado do estoque.
     *
     * @param mensagem mensagem a ser enviada aos observadores
     */
    void notificarObservadores(String mensagem);
}