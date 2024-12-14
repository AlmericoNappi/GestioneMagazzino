<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Articolo" %>
    <%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>paginaAlme</title>
</head>
<body>
<table>
<%
	List<Articolo> elenco = (List<Articolo>)request.getSession().getAttribute("elencoArticoli");
	for(Articolo a: elenco){	
%>
 <tr>
 		<td><%=a.getCodice() %></td>
 	 	<td><%=a.getDescrizione() %></td>
 	 	<td><%=a.getQuantita() %></td>
 </tr>

<% } %>
</table>
</body>
</html>