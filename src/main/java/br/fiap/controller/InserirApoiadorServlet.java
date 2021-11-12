package br.fiap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.FornecedorDAO;
import br.fiap.entities.Fornecedor;

/**
 * Servlet implementation class InserirApoiadorServlet
 */
@WebServlet("/inserirApoiador")
public class InserirApoiadorServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String nome = request.getParameter("nome");
    String registro = request.getParameter("cnpj");
    Double valor = Double.parseDouble(request.getParameter("valor"));
    Fornecedor fornecedor = null;

    PrintWriter pw = response.getWriter();
    FornecedorDAO dao = new FornecedorDAO();
    Random random = new Random();

    int gerador = random.nextInt(1000) + 1;

    List<Fornecedor> lista = dao.obterTodos();
    boolean verdadeiro = true;
    do {
      for (int i = 0; i < lista.size(); i++) {
        if(gerador == lista.get(i).getIdFornecedor()) {
          gerador = random.nextInt(1000) + 1;
          break;
        }else {
          verdadeiro = false;
        }
      }
    }while(verdadeiro);
    

    // ele eh cpf
    if (registro.length() == 11) {
      fornecedor = new Fornecedor(gerador, nome, null, registro, valor);
    } else if (registro.length() == 14) {
      fornecedor = new Fornecedor(gerador, nome, registro, null, valor);
    } else {
      pw.println("<html><body> <h1> Voce colocou um CPF ou CNPJ invalido!</h1>"
          + "<a href=\"http://localhost:8080/projeto-totem/apoiador.html\"> <button>Voltar</button> </a>");
    }

    pw.println("<html><body font-size:30px>Obrigado por ajudar a nossa causa!<h1></h1>"
        + "<a href=\"http://localhost:8080/projeto-totem\"> <button>Voltar</button> </a>");

    dao.inserir(fornecedor);

  }

}
