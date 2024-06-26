package Strategy;

import Dominio.Editora;
import Dominio.EntidadeDominio;
import Dominio.Livro;

public class ValidarEditora implements IStrategy{
    @Override
    public String processsar(EntidadeDominio entidade) {

        Livro livro = (Livro) entidade;
        StringBuilder sb = new StringBuilder();

        Editora editora = livro.getEditora();

        if(editora == null) {
            sb.append("Editora é um campo obrigatório");
        }

        if(editora.getNome() == null){
            sb.append("Nome é um campo obrigatório");

        }

            return sb.toString();
        }
    }



