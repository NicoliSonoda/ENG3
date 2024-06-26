package Dominio;

public class Editora extends EntidadeDominio {
    private String nome;

    public Editora(){;}

    public Editora(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
