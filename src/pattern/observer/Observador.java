package pattern.observer;

 /**
 * Essa interface serve para os observadores do sistema.
 * Eu usei ela para que algumas classes possam receber avisos
 * quando acontecer alguma mudança no estoque.
 *
 * Quando o grupo estava fazendo o projeto, percebemos que seria mais fácil
 * avisar todo mundo ao mesmo tempo usando esse método. Eles recebem
 * uma mensagem e podem mostrar a informação para o usuário.
 *
 * No padrão Observer, os observadores ficam esperando atualizações.
 * Quando algo muda, eles são avisados automaticamente.
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