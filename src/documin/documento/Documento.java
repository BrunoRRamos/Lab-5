package documin.documento;

public class Documento {
    private String titulo;
    private int tamanhoMaximo;
    private int elementosCadastrados;

    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.tamanhoMaximo = tamanho;
        this.elementosCadastrados = 0;
    }

    public Documento(String titulo) {
        this.titulo = titulo;
        this.tamanhoMaximo = 0;
        this.elementosCadastrados = 0;
    }

    public int getElementosCadastrados() {
        return this.elementosCadastrados;
    }

    public String[] returnaDocumento() {
        return null;
    }
}
