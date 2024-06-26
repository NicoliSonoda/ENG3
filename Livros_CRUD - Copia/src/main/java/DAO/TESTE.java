package DAO;

import Dominio.Autor;
import Dominio.Livro;

public class TESTE {

    public static void main(String[] args) {
        testarConsultarUm();
    }

    public static void testarConsultarUm() {
        LivroDAO livroDAO = new LivroDAO();
        Livro livroConsultado = new Livro();


        livroConsultado.setId(1);

        livroConsultado.setAtivo(true);

        livroDAO.inativarLivro(livroConsultado);


    }
}
