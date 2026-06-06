package pattern.observer;

/**
 * Interface que define o contrato para os observadores do sistema.
 * Implementada por classes que desejam ser notificadas sobre
 * mudancas no estoque.
 *
 * @author Murilo
 * @version 1.0
 */
public interface Observador {

    /**
     * Metodo chamado automaticamente quando o estado
     * do estoque e alterado.
     *
     * @param mensagem mensagem de notificacao enviada pelo estoque
     */
    void atualizar(String mensagem);
}