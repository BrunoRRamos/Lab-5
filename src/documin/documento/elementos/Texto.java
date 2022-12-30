package documin.documento.elementos;

/**
 * @author Bruno Rodrigues Ramos
 * Classe responsável por representar um elemento do tipo Texto
 */
public class Texto extends ElementoAbstract implements Elemento{

    /**
     * Construtor responsável por inicializar os atributos
     * @param valor Conteúdo
     * @param propiedades Propiedades de Texto
     * @param prioridade Prioridade do elemento
     */
    public Texto(String valor, String propiedades, int prioridade) {
        super(valor, propiedades, prioridade);
    }

    /**
     * Gera a representação completa do elemento Texto
     * @return (String) Representação completa de Texto
     */
    @Override
    public String representacaoCompleta() {
        return this.getValor();
    }

    /**
     * Gera a representação resumida do elemento Texto
     * @return (String) Representação resumida de Texto
     */
    @Override
    public String representacaoResumida() {
        return this.getValor();
    }
}
