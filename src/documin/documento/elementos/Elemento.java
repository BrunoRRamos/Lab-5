package documin.documento.elementos;

import java.util.HashMap;

public interface Elemento {
    public HashMap<String, Object> getPropriedades();

    public String getValor();

    public String representacaoCompleta();

    public String representacaoResumida();
}
