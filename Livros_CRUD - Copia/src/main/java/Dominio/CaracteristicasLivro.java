package Dominio;

public class CaracteristicasLivro extends EntidadeDominio {
    private float altura;
    private float largura;
    private float profundidade;
    private float peso;

    public CaracteristicasLivro(float altura, float largura, float profundidade, float peso) {
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
        this.peso = peso;
    }

    public CaracteristicasLivro() {

    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(float profundidade) {
        this.profundidade = profundidade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
