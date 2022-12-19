package documin.documento.elementos;

public class Titulo extends ElementoAbstract {

    private boolean linkavel;
    private int prioridade;

    public Titulo(int prioridade, String valor, String propiedades, boolean linkavel) {
        super(valor, propiedades);
        this.linkavel = linkavel;
        this.prioridade = prioridade;
    }

    @Override
    public String representacaoCompleta() {
        if (linkavel) {
            return String.format("%s. %s --\n%s-%s", this.prioridade, this.getValor(), this.prioridade, this.getValor());
        }
        return String.format("%s. %s", this.prioridade, this.getValor());
    }

    @Override
    public String representacaoResumida() {
        return String.format("%s. %s", this.prioridade, this.getValor());
    }
}
