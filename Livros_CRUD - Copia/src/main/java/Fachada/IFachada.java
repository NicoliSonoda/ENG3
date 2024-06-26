package Fachada;

import Dominio.EntidadeDominio;

import java.util.List;

public interface IFachada {

    public String salvar(EntidadeDominio entidade);


    public String alterar(EntidadeDominio entidade);


    void deleter(EntidadeDominio entidadeDominio);

    public List<EntidadeDominio> consultar(EntidadeDominio entidade);


    public String excluir(EntidadeDominio entidade);

    void atualizar(EntidadeDominio entidadeDominio);
}
