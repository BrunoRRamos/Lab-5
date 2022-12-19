package documin.documento.elementos;

import java.util.HashMap;

public interface Elemento {
    public HashMap<String, String> getPropiedades();

    public String getValor();

    public String representacaoCompleta();

    public String representacaoResumida();
}
