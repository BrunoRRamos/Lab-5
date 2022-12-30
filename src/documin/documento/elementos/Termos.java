package documin.documento.elementos;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Bruno Rodrigues Ramos
 * Classe responsável por representar um elemento do tipo Termo
 */
public class Termos extends ElementoAbstract{
    private ArrayList<String> termosDoc;

    /**
     * Construtor responsável por inicializar os atributos da classe e por em ordem os valores
     * @param valor Conteúdo de termos
     * @param propiedades Propiedades de termos
     * @param prioridade Prioridade do elemento
     * @param separador Separador de termos
     * @param ordem Ordem de organização
     */
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

    /**
     * Gera a representação completa do elemento Termos
     * @return (String) Representação completa de Termos
     */
    @Override
    public String representacaoCompleta() {
        return String.format("Total termos: %s\n- %s", this.termosDoc.size(), String.join(", ", this.termosDoc));
    }

    /**
     * Gera a representação resumida do elemento Termos
     * @return (String) Representação resumida de Termos
     */
    @Override
    public String representacaoResumida() {
        return String.join(String.format(" %s   %s", this.getSeparador(), this.termosDoc));
    }

    private String getSeparador() {
        return (String) this.propriedades.get("separador");
    }

    /**
     * Retorna o tipo de ordem de organização dos Termos
     * @return (String) Tipo de organização
     */
    private String getOrdem() {
        return (String) this.propriedades.get("ordem");
    }
}
