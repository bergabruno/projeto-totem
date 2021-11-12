package br.fiap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.TotemDAO;
import br.fiap.entities.Totem;

@WebServlet("/inserirTotem")
public class InserirTotemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	  PrintWriter pw = response.getWriter();
	  boolean error = false;
	  int id= 0;
	  try {
	  id = Integer.parseInt(request.getParameter("id"));
	  }catch(NumberFormatException e) {
	    pw.println("<html> <body> <h1> Voce colocou alguma letra no lugar de NUMEROS!</h1>"
          + "<a href=\"http://localhost:8080/projeto-totem/inserirTotem.html\"> <button>Voltar</button> </a>");
      error = true;
	  }
	  String pais = request.getParameter("pais");
	  String cidade = request.getParameter("cidade");
	  String bairro = request.getParameter("bairro");
	  String longitude = request.getParameter("longitude");
	  String latitude = request.getParameter("latitude");
	  
	  if (error) {
    } else {
	  
	  Totem totem = new Totem(id, pais, cidade, bairro, longitude, latitude);
	  TotemDAO dao = new TotemDAO();
	  
	  dao.inserir(totem);
	  
	  if (totem != null) {
      pw.println("<html> <body> <h1> Totem inserido com sucesso!</h1>"
          + "<a href=\"http://localhost:8080/projeto-totem/paginacao.html\"> <button>Voltar</button> </a>");
    }
    }
	}

}
