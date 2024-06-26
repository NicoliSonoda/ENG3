package DAO;

import BancodeDados.OracleDBConnection;
import Dominio.Autor;
import Dominio.EntidadeDominio;
import Dominio.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO implements IDAO{

    private OracleDBConnection oracleDBConnection;

    @Override
    public Integer consultarUm(EntidadeDominio entidade) {

        Autor autor = (Autor) entidade;

        Integer aut_id = null;
        String sql = "SELECT aut_id FROM autores WHERE aut_nome = ?";

        try (Connection connection = OracleDBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, autor.getNome());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                aut_id = resultSet.getInt("aut_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aut_id;
    }

    @Override
    public void salvar(EntidadeDominio entidade) {};

    @Override
    public String alterar(EntidadeDominio entidade) {
        return null;
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        return null;
    }

    public Autor consultarPorId(Livro livro) {

        String sql = "SELECT a.aut_id, a.aut_nome " +
                "FROM autores a " +
                "JOIN livros_autores la ON a.aut_id = la.aut_id " +
                "JOIN livros l ON la.lvr_id = l.lvr_id " +
                "WHERE l.lvr_id = ?";

        try (Connection connection = OracleDBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, livro.getId());

            Autor autor = new Autor();

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                autor.setId(resultSet.getInt("aut_id"));
                autor.setNome(resultSet.getString("aut_nome"));
            }
            connection.close();
            return autor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public String excluir(EntidadeDominio entidade) {
        return null;
    }
}
