package DAO;

import BancodeDados.OracleDBConnection;
import Dominio.Editora;
import Dominio.EntidadeDominio;
import Dominio.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FornecedorDAO implements IDAO{


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
        Fornecedor fornecedor = (Fornecedor) entidade;

        Integer frn_id = null;
        String sql = "SELECT frn_id FROM fornecedores WHERE frn_razaosocial = ?";

        try (Connection connection = OracleDBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, fornecedor.getCNPJ());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                frn_id = resultSet.getInt("frn_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return frn_id;
    }
}
