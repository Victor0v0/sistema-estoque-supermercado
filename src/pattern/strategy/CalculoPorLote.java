package pattern.strategy;

/**
 * Implementacao da estrategia de calculo baseada
 * no tamanho do lote de produtos e na quantidade.
 * A quantidade e dividida pelo tamanho do lote (divisao inteira),
 * e o resultado e multiplicado pelo valor unitario para obter o valor total
 *
 * @author Miguel Expedito, Miguel Santos
 * @version 1.0
 */
public class CalculoPorLote implements EstrategiaCalculo {

    /**
     * Tamanho do lote utilizado no calculo.
     */
    private int tamLote;

    /**
     * Construtor da classe CalculoPorLote.
     *
     * @param tamLote tamanho do lote; deve ser maior que zero
     */
    public CalculoPorLote(int tamLote) {
        this.tamLote = tamLote;
    }

    /**
     * Calcula o valor total com base no numero de lotes completos.
     * A divisao entre "quantidade" e "tamLote" e inteira, ou seja, lotes incompletos nao sao contabilizados.
     *
     * @param quantidade quantidade de itens
     * @param valorUnitario valor unitario do produto
     * @return valor total calculado com base nos lotes completos
     */
    @Override
    public double calcular(int quantidade, double valorUnitario) {
        return (quantidade / tamLote) * valorUnitario;
    }

    /**
     * Retorna o tamanho do lote.
     *
     * @return tamLote
     */
    public int getTamLote() {
        return tamLote;
    }

    /**
     * Define o tamanho do lote.
     *
     * @param tamLote novo tamanho do lote
     */
    public void setTamLote(int tamLote) {
        this.tamLote = tamLote;
    }
}