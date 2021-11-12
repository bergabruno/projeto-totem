package br.fiap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.UsuarioDAO;
import br.fiap.entities.Usuario;

/**
 * Servlet implementation class InserirUsuarioServlet
 */
@WebServlet("/inserirUsuario")
public class InserirUsuarioServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int id = 0;
    String nome = "";
    String sobrenome = "";
    int idade = 0;
    int cdBarras = 0;
    int matricula = 0;
    boolean error = false;

    PrintWriter pw = response.getWriter();
    try {
      id = Integer.parseInt(request.getParameter("id"));
      nome = request.getParameter("nome");
      sobrenome = request.getParameter("sobrenome");
      idade = Integer.parseInt(request.getParameter("idade"));
      cdBarras = Integer.parseInt(request.getParameter("cdBarras"));
      matricula = Integer.parseInt(request.getParameter("matricula"));
    } catch (NumberFormatException e) {
      pw.println("<html> <body> <h1> Voce colocou alguma letra no lugar de NUMEROS!</h1>"
          + "<a href=\"http://localhost:8080/projeto-totem/inserirUsuario.html\"> <button>Voltar</button> </a>");
      error = true;
    }
    if (error) {
    } else {

      Usuario user = null;

      user = new Usuario(id, nome, sobrenome, idade, cdBarras, matricula);

      UsuarioDAO dao = new UsuarioDAO();

      if (dao.buscar(id)) {
        pw.println("<html> <body> <h1> Ja existe um usuario com este ID!</h1>"
            + "<a href=\"http://localhost:8080/projeto-totem/inserirUsuario.html\"> <button>Voltar</button> </a>");
      } else {
        dao.inserir(user);
        if (user != null) {
          pw.println("<html> <body> <h1> Usuario inserido com sucesso!</h1>"
              + "<a href=\"http://localhost:8080/projeto-totem/paginacao.html\"> <button>Voltar</button> </a>");
        }

      }

    }
  }
}
