<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="missingDatasets" scope="request" type="java.lang.String" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Retrieve Missing Datasets</title>
<link rel="stylesheet" type="text/css" href="simple.css" />
</head>
<body>
	Datasets updated to version; <c:out value="${missingDatasets}" />
</body>
</html>