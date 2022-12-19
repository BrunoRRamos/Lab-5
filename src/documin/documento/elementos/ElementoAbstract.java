package documin.documento.elementos;

import java.util.HashMap;

public abstract class ElementoAbstract implements Elemento{
    private String valor;
    private HashMap<String, String> propiedades;

    public ElementoAbstract(String valor, String propiedades) {
        this.valor = valor;
        this.propiedades = new HashMap<>();
    }

    public HashMap<String, String> getPropiedades() {
        return this.propiedades;
    }

    public String getValor() {
        return this.valor;
    }
}
