package Form;

import Controller.ControllerLivro;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FormLivro {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Map<String, String> requisicao = new HashMap<String, String>();

        System.out.print("Digite o nome do livro: \n");
        requisicao.put("titulo",sc.next());

        System.out.print("Digite o nome do autor: \n");
        requisicao.put("nome",sc.next());

        System.out.print("Digite a edição do livro: \n");
        requisicao.put("edicao",sc.next());

        System.out.print("Digite o número de páginas: \n");
        requisicao.put("edicao",sc.next());

        System.out.print("Escolha uma categoria: \n");
        requisicao.put("categoria",sc.next());

        System.out.print("Digite a sinopse: \n");
        requisicao.put("sinopse",sc.next());

        System.out.print("Digite o ano de publicação: \n");
        requisicao.put("anoPublicacao",sc.next());

        System.out.print("Digite o ISBM: \n");
        requisicao.put("isbm",sc.next());

        System.out.print("Digite o código de barras: \n");
        requisicao.put("codigoBarras",sc.next());

        System.out.print("Digite o valor de aquisição: \n");
        requisicao.put("valorAquisicao",sc.next());

        System.out.print("Digite a altura do livro: \n");
        requisicao.put("altura",sc.next());

        System.out.print("Digite a largura do livro: \n");
        requisicao.put("largura",sc.next());

        System.out.print("Digite a profundidade do livro: \n");
        requisicao.put("profundidade",sc.next());

        System.out.print("Digite o peso do livro: \n");
        requisicao.put("peso",sc.next());

        System.out.print("Digite o fornecedor: \n");
        requisicao.put("fornecedor",sc.next());

        System.out.print("Escolha um grupo de precificação: \n");
        requisicao.put("grupoPrecificacao",sc.next());


     //   String retProcReq = ControllerLivro.processarReq(requisicao);
        // System.err.print(retProcReq);
    }

}

