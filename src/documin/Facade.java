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
        return null;
    }

    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        return documentoController.criarTexto(tituloDoc, valor, prioridade);
    }

    public int  Titulo(int prioridade, String valor, String propiedades, int nivel, boolean linkavel) {
        return documentoController.criarTitulo(propiedades, valor, prioridade, nivel, linkavel);
    }

    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        return documentoController.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
    }

    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        return ;
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

}

