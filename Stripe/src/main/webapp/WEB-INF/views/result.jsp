<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<c:if test="${error}">
				<h3 style="color: red;">${error}</h3>
			        <h3 style='color: green;'>Success!</h3>
			        <div>Id.: ${id}</div>
			        <div>Status: ${status}</div>
			        <div>Charge id.: ${chargeId}</div>
			        <div>Balance transaction id.: ${balance_transaction}</div>
			</c:if>
</body>
</html>