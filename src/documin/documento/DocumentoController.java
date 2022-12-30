package documin.documento;

import documin.documento.elementos.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import static java.lang.Math.ceil;

/**
 * @author Bruno Rodrigues Ramos
 * Classe responsável por controlar toda lógica envolvendo documentos, elementos, atalhos e visões
 */
public class DocumentoController {
    private HashMap<String, Documento> documentos;
    private ArrayList visoes;

    /**
     * Construtor que inicializa o HashMap de documentos e o ArrayList de visoes
     */
    public DocumentoController() {
        this.documentos = new HashMap<>();
        this.visoes = new ArrayList();
    }

    /**
     * Cria um novo documento COM número máximo de elementos e o adicona no HashMap
     * @param titulo Título do novo documento
     * @param tamanhoMaximo Número máximo de elementos
     * @return true ou false
     */
    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        Utilitarios.verificaValorInvalido(tamanhoMaximo);
        if (Utilitarios.verificaExistencia(documentos, titulo) && !titulo.isBlank()) {
            documentos.put(titulo, new Documento(titulo, tamanhoMaximo));
            return true;
        }
        return false;
    }

    /**
     * Cria um novo documento SEM número máximo de elementos e o adicona no HashMap
     * @param titulo Título do novo documento
     * @return true ou false
     */
    public boolean criarDocumento(String titulo) {
        if (Utilitarios.verificaExistencia(documentos, titulo) && !titulo.isBlank()) {
            documentos.put(titulo, new Documento(titulo));
            return true;
        }
        return false;
    }

    /**
     * Remove um documento do HashMap
     * @param titulo Título do documento
     */
    public void removerDocumento(String titulo) {
        verificaDoc(documentos, titulo);
        if (!Utilitarios.verificaExistencia(documentos, titulo)) {
           documentos.remove(titulo);
        } else {
            throw new NoSuchElementException("Esse documento não existe !");
        }
    }

    /**
     * Retorna o número de elementos cadastrados em um documento
     * @param titulo Título do documento
     * @return Número de elementos cadastrados
     */
    public int contarElementos(String titulo) {
        verificaDoc(documentos, titulo);
        return documentos.get(titulo).getElementosCadastrados();
    }

    /**
     * Retorna um Array com as representações completas do elementos cadastrados do documento
     * @param titulo Título do documento
     * @return Array com as representações completas do elementos
     */
    public String[] exibirDocumento(String titulo) {
        verificaDoc(documentos, titulo);
        if (!Utilitarios.verificaExistencia(documentos, titulo)) {
            ArrayList<ElementoAbstract> elementos = documentos.get(titulo).getElementosList();
            String[] documento = elementos.stream()
                    .map(ElementoAbstract::representacaoCompleta)
                    .toArray(String[]::new);
            return documento;
        }
        throw new NoSuchElementException("Esse documento não existe !");
    }

    /**
     * Cria um novo elemento do tipo Texto no documento referenciado
     * @param tituloDoc Título do documeto
     * @param valor Conteúdo do texto
     * @param prioridade Prioridade do elemento
     * @return Posição do elemento no ArrayList de elementos (id)
     */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        verificaDoc(documentos, tituloDoc);
        documentos.get(tituloDoc).adicionaElemento(new Texto(valor, null, prioridade));
        return documentos.get(tituloDoc).getElementosCadastrados() - 1;
    }

    /**
     * Cria um novo elemento do tipo Título no documento referenciado
     * @param tituloDoc Título do documento
     * @param valor Conteúdo do Título
     * @param prioridade Prioridade do elemento
     * @param nivel Nível do Título
     * @param linkavel Se o Título pode ser linkavel
     * @return Posição do elemento no ArrayList de elementos (id)
     */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        verificaDoc(documentos, tituloDoc);
        documentos.get(tituloDoc).adicionaElemento(new Titulo(prioridade, valor, null, nivel, linkavel));
        return documentos.get(tituloDoc).getElementosCadastrados() - 1;
    }

    /**
     * Cria um novo elemento do tipo Lista no documento referenciado
     * @param tituloDoc Título do documento
     * @param valorLista Conteúdo da Lista
     * @param prioridade Prioridade do elemento
     * @param separador Caractere que separa os items da lista
     * @param charLista Caractere de lista
     * @return Posição do elemento no ArrayList de elementos (id)
     */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        verificaDoc(documentos, tituloDoc);
        documentos.get(tituloDoc).adicionaElemento(new Lista(valorLista, null, prioridade, separador, charLista));
        return documentos.get(tituloDoc).getElementosCadastrados() - 1;
    }

    /**
     * Cria um novo elemento do tipo Termo no documento referenciado
     * @param tituloDoc Título do documento
     * @param valorTermos Conteúdo de Termo
     * @param prioridade Prioridade do elemento
     * @param separador Caractere que separa os termos
     * @param ordem Tipo de ordenação
     * @returnPosição do elemento no ArrayList de elementos (id)
     */
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        verificaDoc(documentos, tituloDoc);
        documentos.get(tituloDoc).adicionaElemento(new Termos(valorTermos, null, prioridade, separador, ordem));
        return documentos.get(tituloDoc).getElementosCadastrados() - 1;
    }

    /**
     * Retorna a representação completa de um elemento de um documento
     * @param tituloDoc Título do documento
     * @param elementoPosicao Posição do elemento no ArratList de elementos
     * @return (String) Representação completa do elemento
     */
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        verificaDoc(documentos, tituloDoc);
        Elemento elemento = (Elemento) documentos.get(tituloDoc).getElemento(elementoPosicao);
        return elemento.representacaoCompleta();
    }

    /**
     * Retorna a representação resumida de um elemento de um documento
     * @param tituloDoc Título do documento
     * @param elementoPosicao Posição do elemento no ArratList de elementos
     * @return (String) Representação resumida do elemento
     */
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        verificaDoc(documentos, tituloDoc);
        Elemento elemento = (Elemento) documentos.get(tituloDoc).getElemento(elementoPosicao);
        return elemento.representacaoResumida();
    }

    /**
     * Apaga um elemento de um documento
     * @param tituloDoc Título do documento
     * @param elementoPosicao Posição do elemento no ArrayList de elementos
     * @return true ou false
     */
    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        verificaDoc(documentos, tituloDoc);
        return documentos.get(tituloDoc).removeElemento(elementoPosicao);
    }

    /**
     * Move um elemento uma posição a cima no ArrayList de elementos
     * @param tituloDoc Título do documento
     * @param elementoPosicao Posição do elemento no ArrayList de elementos
     */
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        verificaDoc(documentos, tituloDoc);
        documentos.get(tituloDoc).moveElementoParaCima(elementoPosicao);
    }

    /**
     * Move um elemento uma posição a baixo no ArrayList de elementos
     * @param tituloDoc Título do documento
     * @param elementoPosicao Posição do elemento no ArrayList de elementos
     */
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        verificaDoc(documentos, tituloDoc);
        documentos.get(tituloDoc).moveElementoParaBaixo(elementoPosicao);
    }

    /**
     * Cria um novo atalho para um documento
     * @param tituloDoc Título do documento (Vai guardar a referência)
     * @param tituloDocReferenciado Título do documento (Vai ser referênciado)
     * @return Posição do atalho no ArrayList de elementos
     */
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        verificaDoc(documentos, tituloDoc);
        if (documentos.get(tituloDoc).getAtalhoAtivo()) {
            throw new IllegalStateException("Já possui Atalho");
        }

        documentos.get(tituloDoc).adicionaElemento(new AtalhoDocumento(calculaMediadePrioridade(documentos.get(tituloDocReferenciado)), tituloDocReferenciado, documentos.get(tituloDocReferenciado).getElementosList()));
        documentos.get(tituloDoc).setTrueAtalhoAtivo();
        documentos.get(tituloDocReferenciado).setTrueAtalhoAtivo();
        return documentos.get(tituloDocReferenciado).getElementosCadastrados() - 1;
    }

    private int calculaMediadePrioridade(Documento taget) {
        ArrayList<Object> elementosDoc = taget.getElementosList();
        int somatorioPrioridades = 0;
        for (int i = 0; i < elementosDoc.size(); i++) {
            Elemento atual = (Elemento) elementosDoc.get(i);
            somatorioPrioridades += atual.getPrioridade();
        }
        return (int) ceil(somatorioPrioridades / elementosDoc.size());
    }

    /**
     * Cria uma visão completa do documento no ArrayList de Visões
     * @param tituloDoc Título do documento
     * @return Posição da visão no ArrayList de Visões
     */
    public int criarVisaoCompleta(String tituloDoc) {
        verificaDoc(documentos, tituloDoc);
        ArrayList<ElementoAbstract> elementos = documentos.get(tituloDoc).getElementosList();
        visoes.add(elementos.stream()
                .map(ElementoAbstract::representacaoCompleta)
                .toArray(String[]::new));
        return visoes.size() - 1;
    }

    /**
     * Cria uma visão Resumida do documento no ArrayList de Visões
     * @param tituloDoc Título do documento
     * @return Posição da visão no ArrayList de Visões
     */
    public int criarVisaoResumida(String tituloDoc) {
        verificaDoc(documentos, tituloDoc);
        ArrayList<ElementoAbstract> elementos = documentos.get(tituloDoc).getElementosList();
        visoes.add(elementos.stream()
                .map(ElementoAbstract::representacaoResumida)
                .toArray(String[]::new));
        return visoes.size() - 1;
    }

    /**
     * Cria uma visão Prioritária do documento no ArrayList de Visões
     * @param tituloDoc Título do documento
     * @return Posição da visão no ArrayList de Visões
     */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        verificaDoc(documentos, tituloDoc);
        ArrayList<ElementoAbstract> elementos = documentos.get(tituloDoc).getElementosList();
        visoes.add(elementos.stream()
                .filter((element) -> element.getPrioridade() >= prioridade)
                .map(ElementoAbstract::representacaoResumida)
                .toArray(String[]::new));
        return visoes.size() - 1;
    }

    /**
     * Cria uma visão  de Títulos do documento no ArrayList de Visões
     * @param tituloDoc Título do documento
     * @return Posição da visão no ArrayList de Visões
     */
    public int criarVisaoTitulo(String tituloDoc) {
        verificaDoc(documentos, tituloDoc);
        ArrayList<ElementoAbstract> elementos = documentos.get(tituloDoc).getElementosList();
        visoes.add(elementos.stream()
                .filter(elemento -> elemento instanceof Titulo)
                .map(ElementoAbstract::representacaoResumida)
                .toArray(String[]::new));
        return visoes.size() - 1;
    }

    /**
     * Exibe um visão cadastrada no ArrayList de Visões
     * @param index Posição da visão no ArrayList de Visões
     * @return (Array de Strings) da visão
     */
    public String[] exibirVisao(int index) {
        return (String[]) visoes.get(index);
    }

    private void verificaDoc(HashMap<String, Documento> documentos, String tituloDoc) {
        if (!documentos.containsKey(tituloDoc)) {
            throw new NoSuchElementException("Esse documento não existe");
        }
    }
}
