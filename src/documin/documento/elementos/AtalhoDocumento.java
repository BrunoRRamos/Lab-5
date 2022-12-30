package documin.documento.elementos;

import java.util.ArrayList;

/**
 * @author Bruno Rodrigues Ramos
 * Classe responsável por representar um atalho de um documento
 */
public class AtalhoDocumento {
    private int prioridade;
    private String valor;
    private ArrayList elementos;

    /**
     * Construtor responsável por inicializar os atributos
     * @param prioridade Prioridade do atalho
     * @param valor Valor do atalho
     * @param elementos ArrayList
     */
    public AtalhoDocumento(int prioridade, String valor, ArrayList elementos) {
        this.prioridade = prioridade;
        this.valor = valor;
        this.elementos = elementos;
    }

    /**
     * Gera uma representação Completa do atalho
     * @return Representação completa
     */
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

    /**
     * Gera uma representação Completa do atalho
     * @return Representação completa
     */
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
