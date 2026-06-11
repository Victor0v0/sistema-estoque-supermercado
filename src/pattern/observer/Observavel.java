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
     * Envia uma mensagem para todos os observadores cadastrados.
     * Usamos esse método para avisar quando o estoque sofre
     * alguma alteração.
     *
     * Eles recebem a mesma mensagem ao mesmo tempo, o que
     * deixa a comunicação mais organizada.
     *
     * @param mensagem mensagem enviada para os observadores
     */
    void notificarObservadores(String mensagem);
}