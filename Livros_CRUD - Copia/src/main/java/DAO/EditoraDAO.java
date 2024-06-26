package DAO;

import BancodeDados.OracleDBConnection;
import Dominio.Autor;
import Dominio.Editora;
import Dominio.EntidadeDominio;
import Dominio.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EditoraDAO implements IDAO{

    public void salvar(EntidadeDominio entidade){};


    public String alterar(EntidadeDominio entidade) {
        return null;
    }


    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        return null;
    }


    public String excluir(EntidadeDominio entidade) {
        return null;
    }

    @Override
    public Integer consultarUm(EntidadeDominio entidade) {
        Editora editora = (Editora) entidade;

        Integer edi_id = null;
        String sql = "SELECT edi_id FROM editoras WHERE edi_nome = ?";

        try (Connection connection = OracleDBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, editora.getNome());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                edi_id = resultSet.getInt("edi_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return edi_id;
    }

}
