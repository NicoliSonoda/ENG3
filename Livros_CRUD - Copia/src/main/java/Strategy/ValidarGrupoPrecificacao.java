package Strategy;

import Dominio.EntidadeDominio;
import Dominio.GrupoPrecificacao;
import Dominio.Livro;

public class ValidarGrupoPrecificacao implements IStrategy{
    @Override
    public String processsar(EntidadeDominio entidade) {

        Livro livro = (Livro) entidade;

        StringBuilder sb = new StringBuilder();

        GrupoPrecificacao grupoPrecificacao = livro.getGrupoPrecificacao();


        if(grupoPrecificacao.getDescricao() == null){
            sb.append("Descrição é um campo obrigatório");
        }

        if(!(grupoPrecificacao.getDescricao().equals("Diamante")||
                grupoPrecificacao.getDescricao().equals("Ouro") ||
                grupoPrecificacao.getDescricao().equals("Prata") ||
                grupoPrecificacao.getDescricao().equals("Bronze"))){
                sb.append("O grupo de precificação é inválido");

        }


            return sb.toString();
        }

    }



