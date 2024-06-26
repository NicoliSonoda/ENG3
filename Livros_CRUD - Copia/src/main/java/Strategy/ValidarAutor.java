package Strategy;

import Dominio.Autor;
import Dominio.EntidadeDominio;
import Dominio.Livro;

import java.util.ArrayList;
import java.util.List;

public class ValidarAutor implements IStrategy {
    @Override
    public String processsar(EntidadeDominio entidade) {

        Livro livro = (Livro) entidade;
        StringBuilder sb = new StringBuilder();
        Autor autores = livro.getAutores();

        if(autores.getNome().trim().isEmpty()) {
            sb.append("Autor é um campo obrigatório");
        }

        if(autores.getNome() == null){
            sb.append("Nome é um campo obrigatório");

        }
            return sb.toString();
        }
    }


