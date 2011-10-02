<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LCBO Tools Reference</title>

<!-- <link rel="icon" type="image/x-icon" href="/api/dav/static/images/favicon.ico" /> -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/more.css" />
</head>
<body>

	<h1 style="font-weight: bold;">LCBO Services APIs</h1>
	<h2>Contents</h2>

	<ul class="style2">
		<li><a href="#overview">Overview</a></li>
		<li><a href="#urlschema">URL Schema</a></li>
		<li><a href="#services">Services</a></li>
		<li><a href="#views">Views</a></li>
		<li><a href="#supportedformats">Supported Output Formats </a></li>
		<li><a href="#xmlschema">XML Schema </a></li>
		<li><a href="#customhttp">Custom HTTP Headers </a></li>
		<li><a href="#usingwebservices">Using LCBO Services </a></li>
		<li><a href="#errors">Error Handling </a></li>
	</ul>

	<h2>
		<a name="overview" id="overview"></a>Overview
	</h2>

	<p>LCBO Services provide a simple but powerful REST-style web services API
	    that grants direct access to LCBO data, providing the opportunity to
	    easily integrate through one simple protocol.</p>

	<p>LCBO Services provide the following functionality
		through this API:</p>

	<ul>
		<li><strong>New Products:</strong> Access lists of new products
		    from LCBO product list</li>
	</ul>

	<p>
		The API's main entry point is: <b>http(s)://host:port/lcbotools</b>.
	</p>

	<h1>An Introduction to Some Terminology</h1>

	<p class="style3">The application uses some LCBO terminology described
	                   below;</p>

	<p>
		<strong>Listing:</strong> Either Vintages or LCBO to indicate
		regular of special product types. <br>
	</p>

	<h2>
		<span class="mozTocH1"></span><a name="urlschema" id="urlschema"></a>URL
		Schema
	</h2>

	Every resource in the system has a URL assigned to it so that it can be
	addressed individually. Some examples are:
	<ul>
		<li>Products</li>
	</ul>

</body>
</html>