<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Adaugare banca</h1>
<form:form action="${pageContext.request.contextPath}/adugare-banca-save.htm" method="post" modelAttribute="bancaForm">
Nume: <form:input path="nume"/><br/>
Adresa: <form:input path="adresa"/><br/>
Telefon: <form:input path="telefon"/><br/>
<input type="submit" value = "Salveaza"/><br/>

</form:form>
<br></br>
<a href="<c:url value="list.htm"/>">Inapoi la lista</a>
</body>
</html>