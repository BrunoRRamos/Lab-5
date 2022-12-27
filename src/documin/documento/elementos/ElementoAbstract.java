package documin.documento.elementos;

import java.util.HashMap;

public abstract class ElementoAbstract implements Elemento{
    private String valor;
    protected HashMap<String, Object> propriedades;
    private int prioridade;

    public ElementoAbstract(String valor, String propriedades, int prioridade) {
        this.valor = valor;
        this.propriedades = new HashMap<>();
        this.prioridade = prioridade;
    }

    public HashMap<String, Object> getPropriedades() {
        return this.propriedades;
    }

    public String getValor() {
        return this.valor;
    }
}
