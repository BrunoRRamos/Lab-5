package documin.documento;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Bruno Rodrigues Ramos
 * Classe responsável por prover métodos estáticos para validações repetitivas
 */
public class Utilitarios {

    /**
     * Verifica se existe algum documento já cadastrado com o título fonecido
     * @param documentos HashMap de Documentos
     * @param key Título do Documento a ser buscado
     * @return true ou false
     */
    public static boolean verificaExistencia(HashMap<String, Documento> documentos, String key) {
        return !documentos.containsKey(key);
    }

    /**
     * Verifica se um valor fornecido é menor ou igual a 0
     * @param valor Valor a ser verificado
     */
    public static void verificaValorInvalido(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Tamanho Inválido !");
        }
    }

    /**
     * Muda a posição de um item em um ArrayList
     * @param lista ArrayList onde vai ocorrer a mudança
     * @param posicaoInicial Posicição inicial do item
     * @param posicaoAlvo Posição final do item
     */
    public static void mudaPosicao(ArrayList lista, int posicaoInicial, int posicaoAlvo) {
        lista.set(posicaoInicial, lista.set(posicaoAlvo, lista.get(posicaoInicial)));
    }
}
