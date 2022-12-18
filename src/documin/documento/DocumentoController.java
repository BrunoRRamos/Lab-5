package documin.documento;

import java.util.HashMap;

public class DocumentoController {
    private HashMap<String, Documento> documentos;

    public DocumentoController() {
        this.documentos = new HashMap<>();
    }

    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        TrataErros.verificaValorInvalido(tamanhoMaximo);
        if (TrataErros.verificaExistencia(documentos, titulo) && !titulo.isBlank()) {
            documentos.put(titulo, new Documento(titulo, tamanhoMaximo));
            return true;
        }
        return false;
    }

    public boolean criarDocumento(String titulo) {
        if (TrataErros.verificaExistencia(documentos, titulo) && !titulo.isBlank()) {
            documentos.put(titulo, new Documento(titulo));
            return true;
        }
        return false;
    }

    public void removerDocumento(String titulo) {
        if (!TrataErros.verificaExistencia(documentos,titulo)) {
           documentos.remove(titulo);
        }
        throw new IllegalArgumentException("Esse documento não existe !");
    }

    public int contarElementos(String titulo) {
        if (!TrataErros.verificaExistencia(documentos,titulo)) {
            return documentos.get(titulo).getElementosCadastrados();
        }
        throw new IllegalArgumentException("Esse documento não existe !");
    }

    public String[] exibirDocumento(String titulo) {
        return null;
    }

}
