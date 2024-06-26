package Dominio;

import java.util.List;

public class Livro extends EntidadeDominio {
    private String titulo;
    private String sinopse;
    private int anoPublicacao;
    private String ISBN;
    private int numPaginas;
    private String codBarras;
    private String edicao;
    private Autor autores;
    private Editora editora;
    private CaracteristicasLivro caracteristicasLivro;
    private GrupoPrecificacao grupoPrecificacao;
    private ValorVenda valorVenda;
    private ValorAquisicao valorAquisicao;
    private MargemLucro margemLucro;
    private List<Categoria> categorias;
    private Fornecedor fornecedor;
    private boolean ativo;


    public Livro() {
    }


    public Livro(String titulo, String sinopse, int anoPublicacao, String ISBN, int numPaginas, String codBarras, String edicao) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.anoPublicacao = anoPublicacao;
        this.ISBN = ISBN;
        this.numPaginas = numPaginas;
        this.codBarras = codBarras;
        this.edicao = edicao;
    }


    public Livro(String titulo, String sinopse, int anoPublicacao, String ISBN, int numPaginas, String codBarras, String edicao,
                 Autor autores, Editora editora, CaracteristicasLivro caracteristicasLivro, GrupoPrecificacao grupoPrecificacao,
                 ValorVenda valorVenda, ValorAquisicao valorAquisicao, MargemLucro margemLucro, List<Categoria> categorias, Fornecedor fornecedor) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.anoPublicacao = anoPublicacao;
        this.ISBN = ISBN;
        this.numPaginas = numPaginas;
        this.codBarras = codBarras;
        this.edicao = edicao;
        this.autores = autores;
        this.editora = editora;
        this.caracteristicasLivro = caracteristicasLivro;
        this.grupoPrecificacao = grupoPrecificacao;
        this.valorVenda = valorVenda;
        this.valorAquisicao = valorAquisicao;
        this.margemLucro = margemLucro;
        this.categorias = categorias;
        this.fornecedor = fornecedor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public Autor getAutores() {
        return autores;
    }

    public void setAutores(Autor autores) {
        this.autores = autores;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public CaracteristicasLivro getCaracteristicasLivro() {
        return caracteristicasLivro;
    }

    public void setCaracteristicasLivro(CaracteristicasLivro caracteristicasLivro) {
        this.caracteristicasLivro = caracteristicasLivro;
    }

    public GrupoPrecificacao getGrupoPrecificacao() {
        return grupoPrecificacao;
    }

    public void setGrupoPrecificacao(GrupoPrecificacao grupoPrecificacao) {
        this.grupoPrecificacao = grupoPrecificacao;
    }

  //  public float getValorVenda() {
   //     return valorVenda;
//    }

    public void setValorVenda(ValorVenda valorVenda) {
        this.valorVenda = valorVenda;
    }

  //  public float getValorAquisicao() {
  //      return valorAquisicao;
  //  }

    public void setValorAquisicao(ValorAquisicao valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

  //  public float getMargemLucro() {
  //      return margemLucro;
  //  }

    public void setMargemLucro(MargemLucro margemLucro) {
        this.margemLucro = margemLucro;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Autor getAutor() {
        return null;
    }

    public ValorVenda getValorVenda() {
        return valorVenda;
    }

    public ValorAquisicao getValorAquisicao() {
        return valorAquisicao;
    }

    public MargemLucro getMargemLucro() {
        return margemLucro;
    }
}
