package DAO;

import BancodeDados.OracleDBConnection;
import Dominio.Editora;
import Dominio.EntidadeDominio;
import Dominio.GrupoPrecificacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GrupoPrecificacaoDAO implements IDAO{

    public void salvar(EntidadeDominio entidade) {};


    public String alterar(EntidadeDominio entidade) {
        return null;
    }


    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        return null;
    }


    public String excluir(EntidadeDominio entidade) {
        return null;
    }

    public Integer consultarUm(EntidadeDominio entidade) {
        GrupoPrecificacao grupoPrecificacao = (GrupoPrecificacao) entidade;

        Integer grp_id = null;
        String sql = "SELECT grp_id FROM grupo_precificacao WHERE grp_descricao = ?";

        try (Connection connection = OracleDBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            System.out.println(grupoPrecificacao.getDescricao());

            statement.setString(1, grupoPrecificacao.getDescricao());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                grp_id = resultSet.getInt("grp_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return grp_id;
    }
}

