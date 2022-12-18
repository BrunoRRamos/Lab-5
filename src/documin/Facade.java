package documin;

import documin.documento.DocumentoController;

public class Facade {

    private DocumentoController documentoController;

    public Facade() {
        this.documentoController = new DocumentoController();
    }

    public boolean criarDocumento(String titulo) {
        return documentoController.criarDocumento(titulo);
    }

    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        return documentoController.criarDocumento(titulo, tamanhoMaximo);
    }

    public void removerDocumento(String titulo) {
        documentoController.removerDocumento(titulo);
    }

    public int contarElementos(String titulo) {
        return documentoController.contarElementos(titulo);
    }

}

