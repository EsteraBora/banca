<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
<tr>
     <td>ID</td>
     <td>Nume</td>
     <td>Adresa</td>
     <td>Telefon</td>
     <td></td>
     <td></td>
     
</tr>
<c:forEach var ="bt" items="${banca}">
<tr>
      <td><c:out value="${bt.id}"/></td>
      <td><c:out value="${bt.nume}"/></td>
      <td><c:out value="${bt.adresa}"/></td>
      <td><c:out value="${bt.telefon}"/></td>
      <td><a href="<c:url value ="/detalii.htm?id=${bt.id}"/>">Detalii</a></td>
      <td><a href="<c:url value ="/delete.htm?id=${bt.id}"/>">Delete</a></td>
      
</tr>
</c:forEach>
</table>
<a href="<c:url value ="/adaugare-banca.htm"/>">Adaugare banca</a>

Lista bancilor
</body>
</html>