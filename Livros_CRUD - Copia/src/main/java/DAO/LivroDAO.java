package DAO;

import BancodeDados.OracleDBConnection;
import Dominio.*;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class LivroDAO implements IDAO {

    private EditoraDAO editoraDAO = new EditoraDAO();
    private FornecedorDAO fornecedorDAO = new FornecedorDAO();
    private GrupoPrecificacaoDAO grupoPrecificacaoDAO = new GrupoPrecificacaoDAO();
    private AutorDAO autorDAO = new AutorDAO();
    private CategoriaDAO categoriaDAO = new CategoriaDAO();

    @Override
    public void salvar(EntidadeDominio entidade) {
        Livro livro = (Livro) entidade;


        String query = "INSERT INTO livros (lvr_titulo, lvr_sinopse, lvr_anoPublicacao, lvr_isbn, lvr_numPaginas, " +
                "lvr_codBarras, lvr_edicao, lvr_valorAquisicao, lvr_valorVenda, lvr_margemLucro, lvr_altura, lvr_peso, lvr_largura, lvr_profundidade, " +
                "lvr_edi_id, lvr_frn_id, lvr_gpc_id, lvr_ativo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try (Connection connection = OracleDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, livro.getTitulo());
            preparedStatement.setString(2, livro.getSinopse());
            preparedStatement.setInt(3, livro.getAnoPublicacao());
            preparedStatement.setString(4, livro.getISBN());
            preparedStatement.setInt(5, livro.getNumPaginas());
            preparedStatement.setString(6, livro.getCodBarras());
            preparedStatement.setString(7, livro.getEdicao());
            preparedStatement.setFloat(8, livro.getValorAquisicao().getValor());
            preparedStatement.setFloat(9, livro.getValorVenda().getValorVenda());
            preparedStatement.setFloat(10, livro.getMargemLucro().getMargem());
            preparedStatement.setFloat(11, livro.getCaracteristicasLivro().getAltura());
            preparedStatement.setFloat(12, livro.getCaracteristicasLivro().getPeso());
            preparedStatement.setFloat(13, livro.getCaracteristicasLivro().getLargura());
            preparedStatement.setFloat(14, livro.getCaracteristicasLivro().getProfundidade());
            preparedStatement.setInt(15, editoraDAO.consultarUm(livro.getEditora()));
            preparedStatement.setInt(16, fornecedorDAO.consultarUm(livro.getFornecedor()));
            preparedStatement.setInt(17, grupoPrecificacaoDAO.consultarUm(livro.getGrupoPrecificacao()));
            preparedStatement.setInt(18, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }


        salvarCategorias(livro);
    }



    private void salvarCategorias(Livro livro) {
        String query = "INSERT INTO livros_categorias (lvr_id, cat_id) VALUES (?, ?)";
        try (Connection connection = OracleDBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (EntidadeDominio categoria : livro.getCategorias()) {
                preparedStatement.setInt(1, consultarUm(livro));
                preparedStatement.setInt(2, categoriaDAO.consultarUm(categoria));
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar categorias do livro: " + e.getMessage());
        }
    }

    @Override
    public String alterar(EntidadeDominio entidade) {

        return null;
    }

    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
        Livro livroConsulta = (Livro) entidade;
        List<EntidadeDominio> livrosEncontrados = new ArrayList<>();

        String sql = "SELECT * FROM livros WHERE lvr_titulo LIKE ?";
        try (Connection connection = OracleDBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + livroConsulta.getTitulo() + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setId(resultSet.getInt("lvr_id"));
                livro.setTitulo(resultSet.getString("lvr_titulo"));

                livro.setSinopse(resultSet.getString("lvr_sinopse"));
                livro.setAnoPublicacao(resultSet.getInt("lvr_anoPublicacao"));
                livro.setISBN(resultSet.getString("lvr_isbn"));
                livro.setNumPaginas(resultSet.getInt("lvr_numPaginas"));
                livro.setCodBarras(resultSet.getString("lvr_codBarras"));
                livro.setEdicao(resultSet.getString("lvr_edicao"));
                // livro.setValorAquisicao(resultSet.getFloat("lvr_valorAquisicao"));
                // livro.setValorVenda(resultSet.getFloat("lvr_valorVenda"));
                // livro.setMargemLucro(resultSet.getFloat("lvr_margemLucro"));
                livro.setAtivo(resultSet.getBoolean("lvr_ativo"));


                CaracteristicasLivro caracteristicasLivro = new CaracteristicasLivro();
                caracteristicasLivro.setAltura(resultSet.getFloat("lvr_altura"));
                caracteristicasLivro.setPeso(resultSet.getFloat("lvr_peso"));
                caracteristicasLivro.setLargura(resultSet.getFloat("lvr_largura"));
                caracteristicasLivro.setProfundidade(resultSet.getFloat("lvr_profundidade"));



                AutorDAO autorDAO1 = new AutorDAO();

                Autor autorConsultado = autorDAO1.consultarPorId(livro);

                livro.setAutores(autorConsultado);

                Editora editora = new Editora();
                editora.setId(resultSet.getInt("lvr_edi_id"));


                Editora edit = consultarPorEditora(editora);

                livro.setCaracteristicasLivro(caracteristicasLivro);

                livro.setEditora(edit);

                livrosEncontrados.add(livro);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livrosEncontrados;
    }
    @Override
    public String excluir(EntidadeDominio entidade) {
        Livro livro = (Livro) entidade;

        String sqlDeleteLivro = "DELETE FROM livros WHERE lvr_id = ?";
        String sqlDeleteAutores = "DELETE FROM livros_autores WHERE lvr_id = ?";
        String sqlDeleteCategorias = "DELETE FROM livros_categorias WHERE lvr_id = ?";

        try (Connection connection = OracleDBConnection.getConnection()) {

            connection.setAutoCommit(false);

            try (PreparedStatement stmtDeleteAutores = connection.prepareStatement(sqlDeleteAutores);
                 PreparedStatement stmtDeleteCategorias = connection.prepareStatement(sqlDeleteCategorias);
                 PreparedStatement stmtDeleteLivro = connection.prepareStatement(sqlDeleteLivro)) {


                Integer lvr_id  = consultarUm(livro);


                if (lvr_id != null) {

                    stmtDeleteAutores.setInt(1, lvr_id );
                    stmtDeleteAutores.executeUpdate();


                    stmtDeleteCategorias.setInt(1, lvr_id );
                    stmtDeleteCategorias.executeUpdate();


                    stmtDeleteLivro.setInt(1, lvr_id );
                    stmtDeleteLivro.executeUpdate();


                    connection.commit();
                    return "Livro excluído com sucesso.";
                } else {
                    connection.rollback();
                    return "Livro não encontrado.";
                }
            } catch (SQLException e) {

                connection.rollback();
                e.printStackTrace();
                return "Erro ao excluir o livro: " + e.getMessage();
            } finally {

                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao conectar ao banco de dados: " + e.getMessage();
        }
    }


    @Override
    public Integer consultarUm(EntidadeDominio entidade) {
        Livro livro = (Livro) entidade;

        Integer lvr_id = null;
        String sql = "SELECT lvr_id FROM livros WHERE lvr_isbn = ?";

        try (Connection connection = OracleDBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, livro.getISBN());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                lvr_id = resultSet.getInt("lvr_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lvr_id;
    }


    public Editora consultarPorEditora(Editora editora) {


        String sql = "SELECT * FROM editoras WHERE edi_id = ?";


        try (Connection connection = OracleDBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, editora.getId());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                editora = new Editora();
                editora.setId(resultSet.getInt("edi_id"));
                editora.setNome(resultSet.getString("edi_nome"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return editora;
    }


    public void inativarLivro(Livro livro) {


        String sql = "UPDATE livros SET lvr_ativo = ? WHERE lvr_id=?";

        try (Connection connection = OracleDBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {


            statement.setBoolean(1, livro.isAtivo());

            statement.setInt(2, livro.getId());

            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}


