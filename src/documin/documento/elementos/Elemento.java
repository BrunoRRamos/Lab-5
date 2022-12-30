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

    public String getValor();

    public String representacaoCompleta();

    public String representacaoResumida();

    public int getPrioridade();
}
