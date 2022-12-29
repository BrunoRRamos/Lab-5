package documin.documento;

import java.util.ArrayList;


public class Documento {
    private String titulo;
    private int tamanhoMaximo;
    private int elementosCadastrados;
    private ArrayList<Object> elementos;
    private boolean atalhoAtivo;

    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.tamanhoMaximo = tamanho;
        this.elementosCadastrados = 0;
        this.elementos = new ArrayList<Object>();
        this.atalhoAtivo = false;
    }

    public Documento(String titulo) {
        this.titulo = titulo;
        this.tamanhoMaximo = 0;
        this.elementos = new ArrayList<Object>();
        this.elementosCadastrados = 0;
    }

    public int getElementosCadastrados() {
        return this.elementosCadastrados;
    }

    public void excluiElemento(int posicao) {
        elementos.remove(posicao);
    }

    public void moveElementoParaCima(int posicao) {
        if ((posicao - 1) >= 0) {
            Utilitarios.mudaPosicao(this.elementos, posicao, posicao - 1);
        } else {
            throw new IllegalArgumentException("Posição Inválida !");
        }
    }

    public void moveElementoParaBaixo(int posicao) {
        if ((posicao + 1) <= this.elementos.size() - 1) {
            Utilitarios.mudaPosicao(this.elementos, posicao, posicao + 1);
        } else {
            throw new IndexOutOfBoundsException("Posição Inválida !");
        }
    }

    public void adicionaElemento(Object item) {
        this.elementos.add(item);
        this.elementosCadastrados += 1;
    }

    public Object getElemento(int index) {
       return this.elementos.get(index);
    }

    public boolean removeElemento(int index) {
        try {
            this.elementos.remove(index);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList getElementosList() {
        return this.elementos;
    }

    public boolean getAtalhoAtivo() {
        return this.atalhoAtivo;
    }

    public void setTrueAtalhoAtivo() {
        this.atalhoAtivo = true;
    }

}
