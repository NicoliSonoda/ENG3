package DAO;

import Dominio.EntidadeDominio;

import java.util.List;

public interface IDAO {

    void salvar(EntidadeDominio entidade);

    String alterar(EntidadeDominio entidade);

    List<EntidadeDominio> consultar(EntidadeDominio entidade);

    String excluir(EntidadeDominio entidade);

    Integer consultarUm(EntidadeDominio entidade);

}


