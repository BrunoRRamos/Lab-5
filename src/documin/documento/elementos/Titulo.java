package documin.documento.elementos;

public class Titulo extends ElementoAbstract {

    private String linkavel;

    public Titulo(String propiedades, int valor, String linkavel) {
        super(propiedades, valor);
        this.linkavel = linkavel;
    }

}
