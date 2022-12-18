package documin.documento.elementos;

public abstract class ElementoAbstract implements Elemento{
    private String propiedades;
    private int valor;

    public ElementoAbstract(String propiedades, int valor) {
        this.propiedades = propiedades;
        this.valor = valor;
    }

    public String getPropiedades() {
        return this.propiedades;
    }

    public int getValor() {
        return this.valor;
    }
}
