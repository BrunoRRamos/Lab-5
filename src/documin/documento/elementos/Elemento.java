package documin.documento.elementos;

import java.util.HashMap;

/**
 * @author Bruno Rodrigues Ramos
 * Interface responsável por gerar representações completas e resumidas de elementos e alguns gets
 */
public interface Elemento {
    /**
     * Retorna o HashMap de propiedades de um elemento
     * @return HashMap de propiedades
     */
    public HashMap<String, Object> getPropriedades();

    /**
     * Retorna o conteúdo do atributo valor do elemento
     * @return (String) conteúdo de valor
     */
    public String getValor();

    /**
     * Retorna a representação completa do elemento
     * @return (String) Representação completa
     */
    public String representacaoCompleta();

    /**
     * Retorna a representação resumida do elemento
     * @return (String) Representação resumida
     */
    public String representacaoResumida();

    /**
     * Retorna a prioridade do elemento
     * @return (int) priotidade do elemento
     */
    public int getPrioridade();
}
