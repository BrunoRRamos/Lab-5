package documin.documento.elementos;

import java.util.HashMap;

/**
 * @author Bruno Rodrigues Ramos
 * Classe Abstrata responsável por Criar a base para todos os Elementos
 */
public abstract class ElementoAbstract implements Elemento{
    private String valor;
    protected HashMap<String, Object> propriedades;
    private int prioridade;

    /**
     * Construtor base de elementos
     * @param valor Valor do elemento (Conteúdo)
     * @param propriedades (HashMap) Propiedades do elemento
     * @param prioridade (int) Prioridade do elemento
     */
    public ElementoAbstract(String valor, String propriedades, int prioridade) {
        this.valor = valor;
        this.propriedades = new HashMap<>();
        this.prioridade = prioridade;
    }

    /**
     * Retorna o HashMap de propiedades do elemento
     * @return HashMap de propiedades
     */
    public HashMap<String, Object> getPropriedades() {
        return this.propriedades;
    }

    public String getValor() {
        return this.valor;
    }

    @Override
    public int getPrioridade() {
        return this.prioridade;
    }
}
