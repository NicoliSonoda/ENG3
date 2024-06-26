package Dominio;

public class Autor extends Pessoa{
    private String pseudonimo;


    public Autor() {
    }

    public Autor(String nome) {
        super(nome);
    }

    public Autor(String nome, String pseudonimo) {
        super(nome);
        this.pseudonimo = pseudonimo;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }
}
