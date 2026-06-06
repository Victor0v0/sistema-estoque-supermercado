package pattern.strategy;

/**
 * Implementacao da estrategia de calculo baseada
 * no tamanho do lote de produtos.
 * Divide a quantidade pelo tamanho do lote para
 * calcular o valor total.
 *
 * @author Miguel Santos
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
     * @param tamLote tamanho do lote
     */
    public CalculoPorLote(int tamLote) {
        this.tamLote = tamLote;
    }

    /**
     * Calcula o valor total dividindo a quantidade
     * pelo tamanho do lote e multiplicando pelo valor unitario.
     *
     * @param quantidade quantidade de itens
     * @param valorUnitario valor unitario do produto
     * @return valor total calculado por lote
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