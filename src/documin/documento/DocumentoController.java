package documin.documento;

import documin.documento.elementos.Lista;
import documin.documento.elementos.Texto;
import documin.documento.elementos.Titulo;

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

}
