package Strategy;

import Dominio.CaracteristicasLivro;
import Dominio.EntidadeDominio;
import Dominio.Livro;

public class ValidarCaractLivro implements IStrategy{
    @Override
    public String processsar(EntidadeDominio entidade) {

        Livro livro = (Livro) entidade;
        CaracteristicasLivro caractLivro = livro.getCaracteristicasLivro();

        StringBuilder sb = new StringBuilder();


        if(caractLivro == null) {
            sb.append("Características dos livros são obrigatórias.");

        }
        if(caractLivro.getAltura() <= 0){
            sb.append("Altura é um campo obrigatório e deve ser um número positivo.");
        }

        if(caractLivro.getLargura() <= 0){
            sb.append("Largura é um campo obrigatório e deve ser um número positivo.");
        }

        if(caractLivro.getProfundidade() <= 0){
            sb.append("Profundidade é um campo obrigatório e deve ser um número positivo.");
        }

        if(caractLivro.getPeso() <= 0){
            sb.append("Peso é um campo obrigatório e deve ser um um número positivo");
        }

        String msg = sb.toString();


        return sb.toString();
    }



}
