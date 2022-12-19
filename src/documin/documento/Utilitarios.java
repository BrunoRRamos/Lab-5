package documin.documento;

import java.util.ArrayList;
import java.util.HashMap;

public class Utilitarios {
    public static boolean verificaExistencia(HashMap<String, Documento> documentos, String key) {
        return !documentos.containsKey(key);
    }

    public static void verificaValorInvalido(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Tamanho Inválido !");
        }
    }

    public static void mudaPosicao(ArrayList lista, int posicaoInicial, int posicaoAlvo) {
        lista.set(posicaoInicial, lista.set(posicaoAlvo, lista.get(posicaoInicial)));
    }
}
