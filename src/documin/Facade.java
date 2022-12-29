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

    public String[] exibirDocumento(String titulo){
        return documentoController.exibirDocumento(titulo);
    }

    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        return documentoController.criarTexto(tituloDoc, valor, prioridade);
    }

    public int criaTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        return documentoController.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
    }

    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        return documentoController.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
    }

    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        return documentoController.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
    }

    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return documentoController.pegarRepresentacaoCompleta(tituloDoc, elementoPosicao);
    }

    public String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return documentoController.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return documentoController.apagarElemento(tituloDoc, elementoPosicao);
    }

    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        documentoController.moverParaCima(tituloDoc, elementoPosicao);
    }

    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        documentoController.moverParaBaixo(tituloDoc, elementoPosicao);
    }

    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        return documentoController.criarAtalho(tituloDoc, tituloDocReferenciado);
    }

    public int criarVisaoCompleta(String tituloDoc) {
        return documentoController.criarVisaoCompleta(tituloDoc);
    }

    public int criarVisaoResumida(String tituloDoc) {
        return documentoController.criarVisaoResumida(tituloDoc);
    }

    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        return documentoController.criarVisaoPrioritaria(tituloDoc, prioridade);
    }

    public int criarVisaoTitulo(String tituloDoc) {
        return documentoController.criarVisaoTitulo(tituloDoc);
    }

    public String[] exibirVisao(int visaoId) {
        try {
            return documentoController.exibirVisao(visaoId);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Essa visão não existe !");
        }

    }

}

