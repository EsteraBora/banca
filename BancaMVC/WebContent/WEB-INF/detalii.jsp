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
<h1>Detalii banca</h1>
Id:<c:out value="${banca.id}"/><br/>
Nume:<c:out value="${banca.nume}"/><br/>
Adresa:<c:out value="${banca.adresa}"/><br/>
Telefon:<c:out value="${banca.telefon}"/><br/>
<br></br>
<a href="<c:url value ="/list.htm?id=${bt.id}"/>">Inapoi la lista</a>


</body>
</html>