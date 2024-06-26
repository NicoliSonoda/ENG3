package Dominio;

public class Categoria extends EntidadeDominio{
    private String categoria;

    public Categoria() {
    }
    public Categoria(String categoria) {
        this.categoria = categoria;
    }
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
