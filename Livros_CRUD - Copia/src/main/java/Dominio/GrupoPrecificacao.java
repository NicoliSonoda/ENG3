package Dominio;

public class GrupoPrecificacao extends  EntidadeDominio{
    private String descricao;
    private Double margemMinima;
    private Double margemMaxima;

    public GrupoPrecificacao(String descricao, Double margemMinima, Double margemMaxima) {
        this.descricao = descricao;
        this.margemMinima = margemMinima;
        this.margemMaxima = margemMaxima;
    }

    public GrupoPrecificacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getMargemMinima() {
        return margemMinima;
    }

    public void setMargemMinima(Double margemMinima) {
        this.margemMinima = margemMinima;
    }

    public Double getMargemMaxima() {
        return margemMaxima;
    }

    public void setMargemMaxima(Double margemMaxima) {
        this.margemMaxima = margemMaxima;
    }
}
