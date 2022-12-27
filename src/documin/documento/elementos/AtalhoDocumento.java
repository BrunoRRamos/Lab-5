package documin.documento.elementos;
import documin.documento.DocumentoController;
import documin.documento.DocumentoController.*;

import java.util.ArrayList;

public class AtalhoDocumento {
    private int prioridade;
    private String valor;
    private ArrayList elementos;

    public AtalhoDocumento(int prioridade, String valor, ArrayList elementos) {
        this.prioridade = prioridade;
        this.valor = valor;
        this.elementos = elementos;
    }

    public String representacaoCompletaAtalho() {
        ArrayList elementos = this.elementos;
        String representacao = "";
        for (int i = 0; i < elementos.size(); i++) {
            Elemento atual = (Elemento) elementos.get(i);
            if (atual.getPrioridade() == 4 || atual.getPrioridade() == 5) {
                representacao += atual.representacaoCompleta() + "\n";
            }
        }
        return representacao;
    }

    public String representacaoResumidaAtalho() {
        ArrayList elementos = this.elementos;
        String representacao = "";
        for (int i = 0; i < elementos.size(); i++) {
            Elemento atual = (Elemento) elementos.get(i);
            if (atual.getPrioridade() == 4 || atual.getPrioridade() == 5) {
                representacao += atual.representacaoResumida() + "\n";
            }
        }
        return representacao;
    }

}
