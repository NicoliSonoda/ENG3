package DAO;

import Dominio.Autor;
import Dominio.EntidadeDominio;
import Dominio.Livro;

import java.util.List;

public class LivroDAOTest {

    public static void main(String[] args) {
        testarConsultar();
    }

    public static void testarConsultar() {
        LivroDAO livroDAO = new LivroDAO();
        Livro livroConsulta = new Livro();
        AutorDAO autorDAO = new AutorDAO();
        livroConsulta.setTitulo("Um país nas maravilhas - II");

        List<EntidadeDominio> livrosEncontrados = livroDAO.consultar(livroConsulta);

        if (livrosEncontrados.isEmpty()) {
            System.out.println("Nenhum livro encontrado com o título informado.");
        } else {
            System.out.println("Livros encontrados:");
            for (EntidadeDominio entidade : livrosEncontrados) {
                Livro livro = (Livro) entidade;
                System.out.println("ID: " + livro.getId());
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Sinopse: " + livro.getSinopse());
                System.out.println("Ano de Publicação: " + livro.getAnoPublicacao());
                System.out.println("ISBN: " + livro.getISBN());
                System.out.println("Número de Páginas: " + livro.getNumPaginas());
                System.out.println("Código de Barras: " + livro.getCodBarras());
                System.out.println("Edição: " + livro.getEdicao());
                System.out.println("Valor de Aquisição: " + livro.getValorAquisicao());
                System.out.println("Valor de Venda: " + livro.getValorVenda());
                System.out.println("Margem de Lucro: " + livro.getMargemLucro());
                System.out.println("Altura: " + livro.getCaracteristicasLivro());
                System.out.println("Largura: " + livro.getCaracteristicasLivro().getLargura());
                System.out.println("Profundidade: " + livro.getCaracteristicasLivro().getProfundidade());
                System.out.println("Peso: " + livro.getCaracteristicasLivro().getPeso());
                System.out.println("Status: " + livro.isAtivo());
                System.out.println("Autor: " + livro.getAutor().getNome());

                System.out.println();

            }
        }
    }
}
