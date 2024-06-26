package Dominio;

public class ValorAquisicao extends EntidadeDominio{
    private float valor;

    public ValorAquisicao(float valor) {
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
