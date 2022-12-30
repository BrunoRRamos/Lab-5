package documin.documento.elementos;

/**
 * @author Bruno Rodrigues ramos
 * Classe responsável por representar um elemento tipo título
 */
public class Titulo extends ElementoAbstract implements Elemento{
    private boolean linkavel;
    private int prioridade;

    /**
     * Construtor responsável por inicializar os atributos da classe
     * @param prioridade Prioridade do elemento
     * @param valor Conteúdo do elemento
     * @param propiedades Propiedades de Título
     * @param nivel Nível do Título
     * @param linkavel Se o elemento é linkavel
     */
    public Titulo(int prioridade, String valor, String propiedades, int nivel, boolean linkavel) {
        super(valor, propiedades, prioridade);
        this.linkavel = linkavel;
        this.prioridade = prioridade;
        this.getPropriedades().put("nivel", nivel);
    }

    /**
     * Gera a representação completa do elemento Título
     * @return (String) Representação completa de Título
     */
    @Override
    public String representacaoCompleta() {
        if (linkavel) {
            return String.format("%s. %s --\n%s-%s", this.prioridade, this.getValor(), this.prioridade, this.getValor());
        }
        return String.format("%s. %s", this.prioridade, this.getValor());
    }

    /**
     * Gera a representação resuida do elemento Título
     * @return (String) Representação resumida de Título
     */
    @Override
    public String representacaoResumida() {
        return String.format("%s. %s", this.prioridade, this.getValor());
    }
}
