<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Person Application</title>
<style type="text/css">
html, body {
  height: 100%;
  margin: 0;
}

.full-height {
  height: 100%;
  background: pink;
}
</style> 
</head>
<body>
<div class="full-height">
	Person Application !!!
<div></div>
<div></div>
<div>
	<table>
		<tr>
			<td><a href="create-person">Create Person</a></td>
			<td><a href="delete-person">Delete Person</a></td>
			<td><a href="search-person">Search Person</a></td>
			<td><a href="get-all-person">Get All Person</a></td>
		</tr>
	</table>
</div>
