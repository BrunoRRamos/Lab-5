package documin.documento;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class DocumentoController {
    private HashMap<String, Documento> documentos;

    public DocumentoController() {
        this.documentos = new HashMap<>();
    }

    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        Utilitarios.verificaValorInvalido(tamanhoMaximo);
        if (Utilitarios.verificaExistencia(documentos, titulo) && !titulo.isBlank()) {
            documentos.put(titulo, new Documento(titulo, tamanhoMaximo));
            return true;
        }
        return false;
    }

    public boolean criarDocumento(String titulo) {
        if (Utilitarios.verificaExistencia(documentos, titulo) && !titulo.isBlank()) {
            documentos.put(titulo, new Documento(titulo));
            return true;
        }
        return false;
    }

    public void removerDocumento(String titulo) {
        if (!Utilitarios.verificaExistencia(documentos,titulo)) {
           documentos.remove(titulo);
        }
        throw new NoSuchElementException("Esse documento não existe !");
    }

    public int contarElementos(String titulo) {
        if (!Utilitarios.verificaExistencia(documentos,titulo)) {
            return documentos.get(titulo).getElementosCadastrados();
        }
        throw new NoSuchElementException("Esse documento não existe !");
    }

    public String[] exibirDocumento(String titulo) {
        return null;
    }

}
