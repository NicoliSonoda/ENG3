package Controller;

import DAO.LivroDAO;
import Dominio.*;
import Fachada.Fachada;
import Fachada.IFachada;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/cadastroLivro","/consultaLivro", "/excluir"})

public class ControllerLivro extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action= req.getServletPath();
        System.out.println(action);
        if(action.equals("/cadastroLivro")){
            cadastrar(req,resp);
        } else if (action.equals("/consultaLivro")) {
            listarLivros(req,resp);
        } else if (action.equals("/excluir")) {
            inativarLivro(req,resp);

        }
    }

    protected void cadastrar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String sinopse = request.getParameter("sinopse");
        int anoPublicacao = Integer.parseInt(request.getParameter("ano_publicacao"));
        String isbn = request.getParameter("isbn");
        int numPaginas = Integer.parseInt(request.getParameter("numero_paginas"));
        String codBarras = request.getParameter("codigo_barras");
        String edicao = request.getParameter("edicao");


        String autor = request.getParameter("autor");

        Autor au = new Autor(autor);

     //   au.setId(Integer.parseInt(autor));


        System.out.println(autor);


        String editora = request.getParameter("editora");
        Editora editora1 = new Editora(editora);


        String fornecedor = request.getParameter("fornecedor");
        Fornecedor fornecedor1 = new Fornecedor(fornecedor);


        String grupoPrecificacao = request.getParameter("grupo_precificacao");
        GrupoPrecificacao grupoPrecificacao1 = new GrupoPrecificacao(grupoPrecificacao);

        float valorAquisicao = Float.parseFloat(request.getParameter("valor_aquisicao"));
        ValorAquisicao valorAquisicao1 = new ValorAquisicao(valorAquisicao);


        float altura = Float.parseFloat(request.getParameter("altura"));
        float largura = Float.parseFloat(request.getParameter("largura"));
        float profundidade = Float.parseFloat(request.getParameter("profundidade"));
        float peso = Float.parseFloat(request.getParameter("peso"));
        CaracteristicasLivro caracteristicasLivro1 = new CaracteristicasLivro(altura, largura, profundidade, peso);


        String categoriaLivro1 = request.getParameter("categoria1");
        System.out.println(categoriaLivro1);
        //String categoriaLivro2 = request.getParameter("categoriaLivro2");
        //String categoriaLivro3 = request.getParameter("categoriaLivro3");
        List<Categoria> categorias = new ArrayList<>();

        categorias.add(new Categoria(categoriaLivro1));

        /*if (categoriaLivro1 != null && !categoriaLivro1.isEmpty()) {
            categorias.add(new Categoria(categoriaLivro1));
        }
        if (categoriaLivro2 != null && !categoriaLivro2.isEmpty() && !categoriaLivro2.equals("(vazio)")) {
            categorias.add(new Categoria(categoriaLivro2));
        }
        if (categoriaLivro3 != null && !categoriaLivro3.isEmpty() && !categoriaLivro2.equals("(vazio)")) {
            categorias.add(new Categoria(categoriaLivro3));
        }*/


        Livro livro = new Livro(titulo, sinopse, anoPublicacao, isbn, numPaginas, codBarras, edicao);
        livro.setAutores(au);
        livro.setEditora(editora1);
        livro.setFornecedor(fornecedor1);
        livro.setGrupoPrecificacao(grupoPrecificacao1);
        livro.setCaracteristicasLivro(caracteristicasLivro1);
        livro.setCategorias(categorias);
        livro.setValorAquisicao(valorAquisicao1);


        IFachada fachada = new Fachada();
        String mensagemErro = null;
        mensagemErro = fachada.salvar(livro);
        System.out.println(mensagemErro);

        if (mensagemErro != null) {
            request.setAttribute("mensagemErro", mensagemErro);
            request.getRequestDispatcher("/Cadastrar.html").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }



    }

    protected void listarLivros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Livro livro = new Livro();

        livro.setTitulo(request.getParameter("search"));

        LivroDAO livroDAO = new LivroDAO();

        List<EntidadeDominio> livros = livroDAO.consultar(livro);

        request.setAttribute("livros", livros);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);

    }

    protected void inativarLivro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Livro livro = new Livro();
        LivroDAO livroDAO = new LivroDAO();
        livro.setId(Integer.parseInt(request.getParameter("id")));
        livro.setAtivo(false);
        livroDAO.inativarLivro(livro);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

}
