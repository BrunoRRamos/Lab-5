package documin.documento.elementos;

import java.util.ArrayList;
import java.util.Arrays;

public class Termos extends ElementoAbstract{
    private ArrayList<String> termosDoc;
    public Termos(String valor, String propiedades, int prioridade, String separador, String ordem) {
        super(valor, propiedades, prioridade);

        this.termosDoc = new ArrayList<String>();
        this.propriedades.put("ordem", ordem);
        this.propriedades.put("separador", separador);
        Arrays.asList(valor.split(separador)).stream()
                .forEach((str) -> this.termosDoc.add(str.trim()));
        this.sort();
    }

    private void sort() {
        if (this.getOrdem() == "ALFABETICA") {
            this.termosDoc.sort(String::compareTo);
        } else if (this.getOrdem() == "TAMANHO") {
            this.termosDoc.sort((a, b) -> a.length() - b.length());
        }
    }

    @Override
    public String representacaoCompleta() {
        return String.format("Total termos: %s\n- %s", this.termosDoc.size(), String.join(", ", this.termosDoc));
    }

    @Override
    public String representacaoResumida() {
        return String.join(String.format(" %s   %s", this.getSeparador(), this.termosDoc));
    }

    private String getSeparador() {
        return (String) this.propriedades.get("separador");
    }

    private String getOrdem() {
        return (String) this.propriedades.get("ordem");
    }
}
