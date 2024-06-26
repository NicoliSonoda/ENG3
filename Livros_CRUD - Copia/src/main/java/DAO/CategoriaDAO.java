package DAO;

import BancodeDados.OracleDBConnection;
import Dominio.Autor;
import Dominio.Categoria;
import Dominio.EntidadeDominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements IDAO {

    @Override
    public Integer consultarUm(EntidadeDominio entidade) {
        Categoria categoria = (Categoria) entidade;

        Integer cat_id = null;
        String sql = "SELECT cat_id FROM categorias WHERE cat_categoria = ?";
        System.out.println(categoria.getCategoria());

        try (Connection connection = OracleDBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, categoria.getCategoria());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cat_id = resultSet.getInt("cat_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cat_id;
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

    @Override
    public String excluir(EntidadeDominio entidade) {

        return null;
    }
}
