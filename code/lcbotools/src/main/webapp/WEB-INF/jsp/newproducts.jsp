<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="newProducts" scope="request" type="java.util.List" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>New Products at the LCBO</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/simple.css" />	
</head>
<body>

	<h2>New Product List</h2>
		
	<display:table id="product" name="${newProducts}">
		<display:setProperty name="basic.msg.empty_list" value="No new products to display."/>		
		<display:column title="CSPC">
			<a href="product/${product.id}.html">
				<c:out value="${product.id}" />
			</a>
		</display:column>
		<display:column property="name" title="Name" />
		<display:column property="producer_name" title="Producer" />
		<display:column property="primary_category" title="Primary Category" />
		<display:column title="Price">
			<fmt:formatNumber value="${product.price_in_cents / 100}" type="CURRENCY" />
		</display:column>
		<display:column property="inventory_count" title="On Hand" />
		<display:column title="Update Date">
			<fmt:formatDate value="${product.updatedAtJavaDate}" type="DATE" pattern="yyyy-MM-dd"/>
		</display:column>
	</display:table>
	
</body>
</html>