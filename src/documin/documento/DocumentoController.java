package documin.documento;

import documin.documento.elementos.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import static java.lang.Math.ceil;

public class DocumentoController {
    private HashMap<String, Documento> documentos;
    private ArrayList visoes;

    public DocumentoController() {
        this.documentos = new HashMap<>();
        this.visoes = new ArrayList();
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

    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        documentos.get(tituloDoc).adicionaElemento(new Texto(valor, null, prioridade));
        return documentos.get(tituloDoc).getElementosCadastrados() - 1;
    }

    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        documentos.get(tituloDoc).adicionaElemento(new Titulo(prioridade, valor, null, nivel, linkavel));
        return documentos.get(tituloDoc).getElementosCadastrados() - 1;
    }

    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        documentos.get(tituloDoc).adicionaElemento(new Lista(valorLista, null, prioridade, separador, charLista));
        return documentos.get(tituloDoc).getElementosCadastrados() - 1;
    }

    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        return ;
    }

    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        Elemento elemento = (Elemento) documentos.get(tituloDoc).getElemento(elementoPosicao);
        return elemento.representacaoCompleta();
    }
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        Elemento elemento = (Elemento) documentos.get(tituloDoc).getElemento(elementoPosicao);
        return elemento.representacaoResumida();
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return documentos.get(tituloDoc).removeElemento(elementoPosicao);
    }

    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        documentos.get(tituloDoc).moveElementoParaCima(elementoPosicao);
    }

    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        documentos.get(tituloDoc).moveElementoParaBaixo(elementoPosicao);
    }

    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        if (documentos.get(tituloDoc).getAtalhoAtivo()) {
            throw new IllegalStateException("Já possui Atalho");
        }

        documentos.get(tituloDoc).adicionaElemento(new AtalhoDocumento(calculaMediadePrioridade(documentos.get(tituloDocReferenciado)), tituloDocReferenciado, documentos.get(tituloDocReferenciado).getElementosList()));
        documentos.get(tituloDoc).setTrueAtalhoAtivo();
        documentos.get(tituloDocReferenciado).setTrueAtalhoAtivo();
        return documentos.get(tituloDocReferenciado).getElementosCadastrados() - 1;
    }

    private int calculaMediadePrioridade(Documento taget) {
        ArrayList elementosDoc = taget.getElementosList();
        int somatorioPrioridades = 0;
        for (int i = 0; i < elementosDoc.size(); i++) {
            Elemento atual = (Elemento) elementosDoc.get(i);
            somatorioPrioridades += atual.getPrioridade();
        }
        return (int) ceil(somatorioPrioridades / elementosDoc.size());
    }

    public int criarVisaoCompleta(String tituloDoc) {
        ArrayList<ElementoAbstract> elementos = documentos.get(tituloDoc).getElementosList();
        visoes.add(elementos.stream().map(ElementoAbstract::representacaoCompleta).toArray(String[]::new));
        return visoes.size() - 1;
    }

    public int criarVisaoResumida(String tituloDoc) {
        ArrayList<ElementoAbstract> elementos = documentos.get(tituloDoc).getElementosList();
        visoes.add(elementos.stream().map(ElementoAbstract::representacaoResumida).toArray(String[]::new));
        return visoes.size() - 1;
    }

    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        ArrayList<ElementoAbstract> elementos = documentos.get(tituloDoc).getElementosList();
        visoes.add(elementos.stream().filter((element) -> element.getPrioridade() >= prioridade).map(ElementoAbstract::representacaoResumida).toArray(String[]::new));
        return visoes.size() - 1;
    }

    public int criarVisaoTitulo(String tituloDoc) {
        ArrayList<ElementoAbstract> elementos = documentos.get(tituloDoc).getElementosList();
        visoes.add(elementos.stream().filter(elemento -> elemento instanceof Titulo));
        return visoes.size() - 1;
    }

    public String[] exibirVisao(int index) {
        return (String[]) visoes.get(index);
    }
}
