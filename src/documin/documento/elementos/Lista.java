package documin.documento.elementos;

import java.text.MessageFormat;
import java.util.ArrayList;

/**
 * @author Bruno Rodrigues Ramos
 * Classe responsável por representar um elemento do tipo Lista
 */
public class Lista extends ElementoAbstract implements Elemento{
    private ArrayList<String> itens;
    private String separador;
    private int prioridade;

    /**
     * Construtor que inicializa os atributos
     * @param valor Conteúdo da lista
     * @param propriedades (HashMap) Propiedades da lista
     * @param prioridade Prioridade do elemento
     * @param separador (String) Caractere de separação da lista
     * @param marcacao (String) Caractere de marcação da lista
     */
    public Lista(String valor, String propriedades, int prioridade, String separador, String marcacao) {
        super(valor, propriedades, prioridade);
        this.itens = new ArrayList<>();
        this.separador = separador;
        this.getPropriedades().put("marcacao", marcacao);

        for (String item : valor.split(separador)) {
            this.itens.add(item);
        }
    }

    /**
     * Gera a representação completa do elemento Lista
     * @return (String) Representação completa de Lista
     */
    @Override
    public String representacaoCompleta() {
        String charMarcacao = (String) this.propriedades.get("marcacao");
        return itens.stream().reduce("", (acc, curr) -> MessageFormat.format("{0}\n{1} {2}", acc, charMarcacao, curr));
    }

    /**
     * Gera a representação resumida do elemento Lista
     * @return (String) Representação resumida de Lista
     */
    @Override
    public String representacaoResumida() {
        return itens.stream().reduce("", (acc, curr) -> MessageFormat.format("{0}{1},", acc, curr));
    }
}
