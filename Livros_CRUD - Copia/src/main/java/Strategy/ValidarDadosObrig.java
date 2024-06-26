package Strategy;

import Dominio.EntidadeDominio;
import Dominio.Livro;

public class ValidarDadosObrig implements IStrategy {

    @Override
    public String processsar(EntidadeDominio entidade) {

        Livro livro = (Livro) entidade;

        StringBuilder sb = new StringBuilder();

        ValidarAutor validarAutor = new ValidarAutor();

        ValidarEditora validarEditora = new ValidarEditora();

        ValidarCaractLivro validarCaractLivro = new ValidarCaractLivro();

        ValidarGrupoPrecificacao validarGrupoPrecificacao = new ValidarGrupoPrecificacao();

        sb.append(validarAutor.processsar(livro));

        sb.append(validarEditora.processsar(livro));

        sb.append(validarCaractLivro.processsar(livro));

        sb.append(validarGrupoPrecificacao.processsar(livro));

        if(livro.getTitulo() == null){
            sb.append("Título é um campo obrigatório\n");
        }

        if(livro.getSinopse() == null){
            sb.append("Sinopse é um campo obrigatório\n");
        }

        if(livro.getAnoPublicacao() <= 0){
            sb.append("Ano de publicação é um campo obrigatório e deve ser maior que zero\n");
        }

        if(livro.getISBN() == null){
            sb.append("ISBN é um campo obrigatório\n");
        }

        if(livro.getNumPaginas() <= 0){
            sb.append("Número de páginas é um campo obrigatório e deve ser maior que zero\n");
        }

        if(livro.getCodBarras() == null){
            sb.append("Código de barras é um campo obrigatório\n");

        }


            return sb.toString();
        }
    }



