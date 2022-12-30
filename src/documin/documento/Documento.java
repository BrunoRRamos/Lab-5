package documin.documento;

import java.util.ArrayList;


/**
 * @author Bruno Rodrigues Ramos
 * Classe responsável por representar um Documento no sistema.
 */
public class Documento {
    private String titulo;
    private int tamanhoMaximo;
    private int elementosCadastrados;
    private ArrayList<Object> elementos;
    private boolean atalhoAtivo;

    /**
     * Construtor utilizado caso seja passado um número máximo de elementos que um documento pode ter.
     * @param titulo Título do Documento
     * @param tamanho Número máximo de elementos permitidos
     */
    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.tamanhoMaximo = tamanho;
        this.elementosCadastrados = 0;
        this.elementos = new ArrayList<Object>();
        this.atalhoAtivo = false;
    }

    /**
     * Construtor utilizado caso o docmento não tenha um número máximo de elementos.
     * @param titulo Título do Documento
     */
    public Documento(String titulo) {
        this.titulo = titulo;
        this.tamanhoMaximo = 0;
        this.elementos = new ArrayList<Object>();
        this.elementosCadastrados = 0;
    }

    public int getElementosCadastrados() {
        return this.elementosCadastrados;
    }

    /**
     * Move um elemento para uma posição a cima no array de elementos
     * @param posicao Posição do elemento no array
     */
    public void moveElementoParaCima(int posicao) {
        if ((posicao - 1) >= 0) {
            Utilitarios.mudaPosicao(this.elementos, posicao, posicao - 1);
        } else {
            throw new IllegalArgumentException("Posição Inválida !");
        }
    }

    /**
     * Move um elemento para uma posição a baixo no array de elementos
     * @param posicao Posição do elemento no array
     */
    public void moveElementoParaBaixo(int posicao) {
        if ((posicao + 1) <= this.elementos.size() - 1) {
            Utilitarios.mudaPosicao(this.elementos, posicao, posicao + 1);
        } else {
            throw new IndexOutOfBoundsException("Posição Inválida !");
        }
    }

    /**
     * Recebe um novo elemento e o aloca no ArrayList de elementos
     * @param item Novo elemento (Object)
     */
    public void adicionaElemento(Object item) {
        this.elementos.add(item);
        this.elementosCadastrados += 1;
    }

    /**
     * Retorna um elemento do ArrayList de elementos através do seu índice
     * @param index Índice do elemento no ArrayList
     * @return (Object) Elemento
     */
    public Object getElemento(int index) {
       return this.elementos.get(index);
    }

    /**
     * Removeum elemento do ArrayList de elementos através do seu índice
     * @param index Índice do elemento no ArrayList
     * @return true ou false
     */
    public boolean removeElemento(int index) {
        try {
            this.elementos.remove(index);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retorna o ArrayList de Elementos
     * @return (ArrayList) Elementos
     */
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
