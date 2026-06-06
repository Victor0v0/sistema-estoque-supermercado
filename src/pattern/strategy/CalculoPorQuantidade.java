package pattern.strategy;

/**
 * Implementacao da estrategia de calculo baseada
 * na quantidade de itens movimentados.
 * Aplica um fator multiplicador sobre o valor unitario.
 *
 * @author Miguel Santos
 * @version 1.0
 */
public class CalculoPorQuantidade implements EstrategiaCalculo {

    /**
     * Fator multiplicador aplicado no calculo.
     */
    private double fator;

    /**
     * Construtor da classe CalculoPorQuantidade.
     *
     * @param fator fator multiplicador do calculo
     */
    public CalculoPorQuantidade(double fator) {
        this.fator = fator;
    }

    /**
     * Calcula o valor total multiplicando quantidade,
     * valor unitario e o fator configurado.
     *
     * @param quantidade quantidade de itens
     * @param valorUnitario valor unitario do produto
     * @return valor total calculado com fator
     */
    @Override
    public double calcular(int quantidade, double valorUnitario) {
        return quantidade * valorUnitario * fator;
    }

    /**
     * Retorna o fator multiplicador.
     *
     * @return fator
     */
    public double getFator() {
        return fator;
    }

    /**
     * Define o fator multiplicador.
     *
     * @param fator novo fator
     */
    public void setFator(double fator) {
        this.fator = fator;
    }
}