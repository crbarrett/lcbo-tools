<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="product" scope="request"
	type="org.cbarrett.lcbo.domain.Product" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LCBO Product</title>
<link rel="stylesheet" type="text/css" href="../static/css/simple.css" />
</head>
<body>

	<h2>Product</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>

		</tr>
		<tr>
			<td><c:out value="${product.id}" /></td>
			<td><c:out value="${product.name}" /></td>
		</tr>
	</table>
	
	<p>
		<c:set var="separator" value=", "/>
		<c:set var="data" value="${product}" />
		${fn:replace(data, separator, "<br/>")}
	</p>

</body>
</html>