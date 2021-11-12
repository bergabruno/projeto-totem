<%@page import="br.fiap.entities.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="br.fiap.dao.UsuarioDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
		#customers {
			font-family: Arial, Helvetica, sans-serif;
			border-collapse: collapse;
			width: 100%;
		}

		#customers td,
		#customers th {
			border: 1px solid #ddd;
			padding: 8px;
		}

		#customers tr:nth-child(even) {
			background-color: #f2f2f2;
		}

		#customers tr:hover {
			background-color: #ddd;
		}

		#customers th {
			padding-top: 12px;
			padding-bottom: 12px;
			text-align: left;
			background-color: rgb(24, 49, 68);
			color: white;
		}
		
		.botao{
			margin-left:23%;
			margin-top: 2%;
			width:90px;
			height:50px;
		}
		
	</style>



</head>
<body>

<h1>Usuarios:</h1>
	<table id="customers">
		<tr >
			<th>ID:</th>
			<th>Nome:</th>
			<th>Sobrenome:</th>
			<th>Idade:</th>
			<th>Codigo de barras:</th>
			<th>Matricula:</th>
		</tr>
		
		<%
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuarios = dao.obterTodos();
		
		for(int i = 0; i < usuarios.size(); i++){
		%>
		  
		<div>
		  <tr>
		  	<td><%=usuarios.get(i).getId()%></td>
			<td><%=usuarios.get(i).getNome()%></td>
			<td><%=usuarios.get(i).getSobrenome()%></td>
			<td><%=usuarios.get(i).getIdade()%></td>
			<td><%=usuarios.get(i).getCodBarras()%></td>
			<td><%=usuarios.get(i).getMatricula()%></td>
			
			</tr>
		
		</div>  
		
		
		<%}%>
	</table>
			<a class="botao" href="http://localhost:8080/projeto-totem/paginacao.html"><button class="botao">Voltar</button></a>
	
</body>
</html>