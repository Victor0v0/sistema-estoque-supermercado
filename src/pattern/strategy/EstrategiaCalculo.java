package pattern.strategy;

/**
 * Interface que define o contrato para as estrategias
 * de calculo de gasto na movimentacao do estoque.
 * Implementa o padrao Strategy permitindo trocar o
 * algoritmo de calculo em tempo de execucao.
 *
 * @author Miguel Santos
 * @version 1.0
 */
public interface EstrategiaCalculo {

    /**
     * Calcula o valor total de uma movimentacao.
     *
     * @param quantidade quantidade de itens movimentados
     * @param valorUnitario valor unitario do produto
     * @return valor total calculado
     */
    double calcular(int quantidade, double valorUnitario);
}