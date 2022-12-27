package documin.documento.elementos;

public class Texto extends ElementoAbstract{

    public Texto(String valor, String propiedades, int prioridade) {
        super(valor, propiedades, prioridade);
    }

    @Override
    public String representacaoCompleta() {
        return this.getValor();
    }

    @Override
    public String representacaoResumida() {
        return this.getValor();
    }
}
