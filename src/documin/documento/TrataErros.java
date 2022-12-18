package documin.documento;

import documin.documento.Documento;

import java.util.HashMap;

public class TrataErros {
    public static boolean verificaExistencia(HashMap<String, Documento> documentos, String key) {
        return !documentos.containsKey(key);
    }

    public static void verificaValorInvalido(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Tamanho Inválido !");
        }
    }

}
