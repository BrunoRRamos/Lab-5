package documin.documento.elementos;

import java.text.MessageFormat;
import java.util.ArrayList;

public class Lista extends ElementoAbstract{
    private ArrayList<String> itens;
    private String separador;
    private int prioridade;

    public Lista(String valor, String propriedades, int prioridade, String separador, String marcacao) {
        super(valor, propriedades, prioridade);
        this.itens = new ArrayList<>();
        this.separador = separador;
        this.getPropriedades().put("marcacao", marcacao);

        for (String item : valor.split(separador)) {
            this.itens.add(item);
        }
    }

    @Override
    public String representacaoCompleta() {
        String charMarcacao = (String) this.propriedades.get("marcacao");
        return itens.stream().reduce("", (acc, curr) -> MessageFormat.format("{0}\n{1} {2}", acc, charMarcacao, curr));
    }

    @Override
    public String representacaoResumida() {
        return itens.stream().reduce("", (acc, curr) -> MessageFormat.format("{0}{1},", acc, curr));
    }
}
