package documin.documento;

import java.util.ArrayList;
import java.util.Collections;


public class Documento {
    private String titulo;
    private int tamanhoMaximo;
    private int elementosCadastrados;
    private ArrayList<Object> elementos;

    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.tamanhoMaximo = tamanho;
        this.elementosCadastrados = 0;
        this.elementos = new ArrayList<>();
    }

    public Documento(String titulo) {
        this.titulo = titulo;
        this.tamanhoMaximo = 0;
        this.elementosCadastrados = 0;
    }

    public int getElementosCadastrados() {
        return this.elementosCadastrados;
    }

    public String[] returnaDocumento() {
        return null;
    }

    public void excluiElemento(int posicao) {
        elementos.remove(posicao);
    }

    public void moveElementoParaCima(int posicao) {
        if ((posicao - 1) > 0) {
            Utilitarios.mudaPosicao(elementos, posicao, posicao - 1);
        }
    }

    public void moveElementoParaBaixo(int posicao) {
        if ((posicao + 1) < elementos.size() - 1) {
            Utilitarios.mudaPosicao(elementos, posicao, posicao + 1);
        }
    }

}
