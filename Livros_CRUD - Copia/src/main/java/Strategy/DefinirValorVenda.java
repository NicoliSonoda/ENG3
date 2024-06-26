package Strategy;

import Dominio.*;

public class DefinirValorVenda implements IStrategy {

    @Override
    public String processsar(EntidadeDominio entidade) {

        Livro livro = (Livro) entidade;

        StringBuilder sb = new StringBuilder();

        GrupoPrecificacao grupoPrecificacao = livro.getGrupoPrecificacao();

        MargemLucro margemLucro = new MargemLucro();

        ValorVenda valorVenda = new ValorVenda();

        ValorAquisicao valorAquisicao = livro.getValorAquisicao();

        switch (grupoPrecificacao.getDescricao()){

            case "Diamante":
                margemLucro.setMargem(0.4f);
                break;

            case "Ouro":
                margemLucro.setMargem(0.3f);
                break;

            case "Prata":
                margemLucro.setMargem(0.2f);
                break;

            case "Bronze":
                margemLucro.setMargem(0.1f);
                break;

            default:
                sb.append("Não foi possível definir a margem de lucro");
        }

        livro.setMargemLucro(margemLucro);
        valorVenda.setValorVenda(valorAquisicao.getValor() * livro.getMargemLucro().getMargem() + valorAquisicao.getValor());
        livro.setValorVenda(valorVenda);


            return sb.toString();
        }

    }


