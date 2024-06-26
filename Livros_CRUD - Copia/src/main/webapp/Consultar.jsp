<%@ page import="Dominio.EntidadeDominio" %>
<%@ page import="Dominio.Livro" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Livros</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
        }
        .search-container {
            margin-bottom: 20px;
            display: flex;
            align-items: center;
        }
        .search-container input[type=text] {
            flex: 1;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        .search-container button {
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            font-size: 14px;
            text-decoration: none;
            cursor: pointer;
            margin-left: 10px;
            min-width: 100px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border-bottom: 1px solid #ccc;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .btn {
            display: inline-block;
            padding: 8px 15px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            font-size: 14px;
            text-decoration: none;
            cursor: pointer;
            margin-right: 5px;
        }
        .btn-edit {
            background-color: #ffc107;
        }
        .btn-delete {
            background-color: #dc3545;
        }
        .btn-register {
            float: right;
            min-width: 100px;
        }
        .btn-container {
            text-align: right;
        }
        .action-buttons {
            display: flex;
        }
        .action-buttons a {
            margin-right: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>CRUD de Livros <a href="Cadastrar.html" class="btn btn-register">Cadastrar</a></h1>
    <form name="Cadastro" action="consultaLivro">
    <div class="search-container">
        <input type="text" id="search" name="search" placeholder="Consultar livro">
        <button type="button" class="btn">Consultar</button>
    </div>
    </form>

    <%
        List<EntidadeDominio> livros = (List<EntidadeDominio>)request.getAttribute("livros");

        if(livros != null || !livros.isEmpty()){


    %>

    <table>
        <thead>
        <tr>
            <th>Titulo</th>
            <th>Autor</th>
            <th>Editora</th>
            <th>Edicao</th>
            <th>Ano de Publicacao</th>
            <th>Acoes</th>
        </tr>
        </thead>

        <%
            for(EntidadeDominio entidade:livros){
                Livro livroConsulta = (Livro) entidade;

        %>

        <tbody>
        <tr>
            <td><%= livroConsulta.getTitulo() %></td>
            <td><%= livroConsulta.getAutor().getNome() %></td>
            <td><%= livroConsulta.getEditora().getNome() %></td>
            <td><%= livroConsulta.getEdicao() %></td>
            <td><%= livroConsulta.getAnoPublicacao() %></td>
            <td class="action-buttons">
                <a href="Editar.html?id=<%=livroConsulta.getId()%>" class="btn btn-edit">Editar</a>
                <a href="Excluir.html?id=<%=livroConsulta.getId()%>" class="btn btn-delete">Excluir</a>
            </td>
        </tr>

        <%
            }
        %>

        </tbody>
    </table>

    <%
        }
    %>

</div>
</body>
</html>
