package model;

/**
 * Classe responsavel pela geracao e impressao
 * de etiquetas dos produtos do supermercado.
 * Contem codigo de barras, QR Code e data de fabricacao.
 *
 * @author Victor
 * @version 1.0
 */
public class Etiqueta {

    /**
     * Codigo de barras do produto.
     */
    private String codigoBarras;

    /**
     * QR Code do produto.
     */
    private String qrCode;

    /**
     * Data de fabricacao do produto.
     */
    private String dataFabricacao;

    /**
     * Construtor da classe Etiqueta.
     *
     * @param codigoBarras codigo de barras
     * @param qrCode qr code do produto
     * @param dataFabricacao data de fabricacao
     */
    public Etiqueta(String codigoBarras, String qrCode,
            String dataFabricacao) {
        this.codigoBarras = codigoBarras;
        this.qrCode = qrCode;
        this.dataFabricacao = dataFabricacao;
    }

    /**
     * Gera a etiqueta do produto.
     */
    public void gerar() {
        System.out.println("Etiqueta gerada: " +
            codigoBarras + " | QR: " + qrCode +
            " | Fabricacao: " + dataFabricacao);
    }

    /**
     * Imprime a etiqueta do produto.
     */
    public void imprimir() {
        System.out.println("Imprimindo etiqueta: " +
            codigoBarras);
    }

    /**
     * Retorna o codigo de barras.
     *
     * @return codigoBarras
     */
    public String getCodigoBarras() { return codigoBarras; }

    /**
     * Retorna o QR Code.
     *
     * @return qrCode
     */
    public String getQrCode() { return qrCode; }

    /**
     * Retorna a data de fabricacao.
     *
     * @return dataFabricacao
     */
    public String getDataFabricacao() {
        return dataFabricacao;
    }
}