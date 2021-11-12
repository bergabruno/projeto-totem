package br.fiap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EntrarServlet
 */
@WebServlet("/entrar")
public class EntrarServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String email = request.getParameter("email");
    String senha = request.getParameter("senha");


    PrintWriter pw = response.getWriter();
    
    
    if(email.equals("admin") && senha.equals("admin")) {
      RequestDispatcher dispatcher = request.getRequestDispatcher("paginacao.html");
      dispatcher.forward(request, response);
    }else {
      pw.println("<html> <body> <h1> Usuario administrador incorreto!</h1>"
          + "<a href=\"http://localhost:8080/projeto-totem/administrativo.html\"> <button>Voltar</button> </a>");
    }
    
      
      
      

  }
}
