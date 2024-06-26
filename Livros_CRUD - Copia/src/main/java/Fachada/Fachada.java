package Fachada;

import DAO.IDAO;
import DAO.LivroDAO;
import Dominio.*;
import Strategy.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fachada implements IFachada{

    private Map<String, IDAO> daos;
    private Map<String, List<IStrategy>> rns;

    public Fachada() {
        daos = new HashMap<String, IDAO>();
        rns = new HashMap<String, List<IStrategy>>();

        daos.put(Livro.class.getName(), new LivroDAO());


        ValidarDadosObrig vLivro = new ValidarDadosObrig();
        DefinirValorVenda vDefinir = new DefinirValorVenda();
        ValidarExistencia vExistencia = new ValidarExistencia();


        List<IStrategy> rnLivro = new ArrayList<IStrategy>();
        rnLivro.add(vLivro);
        rnLivro.add(vDefinir);
        rnLivro.add(vExistencia);
        rns.put(Livro.class.getName(), rnLivro);
    }

    @Override
    public String salvar(EntidadeDominio entidadeDominio) {
        String msgRetorno = validar(entidadeDominio);
        if(msgRetorno == null) {
            IDAO dao = daos.get(entidadeDominio.getClass().getName());
            System.out.println(entidadeDominio.getClass().getName());
            dao.salvar(entidadeDominio);
            return "Registro realizado com sucesso!";
        }else {
            return msgRetorno;
        }
    }

    @Override
    public String alterar(EntidadeDominio entidade) {
        return null;
    }

    private String validar(EntidadeDominio entidade) {
        String nmClasse = entidade.getClass().getName();
        List<IStrategy> regras = rns.get(nmClasse);
        StringBuilder sb = new StringBuilder();
        for(IStrategy s:regras) {
            String msg = s.processsar(entidade);
            System.out.println(msg);
            if(msg!= null) {
                sb.append(msg);
            }
            if(sb.length()!=0) {
                return sb.toString();
            }

        }
        return null;
    }

    @Override
    public void deleter(EntidadeDominio entidadeDominio) {

    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidadeDominio) {

        return null;
    }

    @Override
    public String excluir(EntidadeDominio entidade) {

        return null;
    }

    @Override
    public void atualizar(EntidadeDominio entidadeDominio) {

    }
}
