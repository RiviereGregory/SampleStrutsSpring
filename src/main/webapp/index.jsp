<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<h1>Employee</h1>
	<s:a href="employee/add.jsp">Add Employee</s:a>
	<s:a href="employee/listAction.action">List Employee</s:a>

	<h1>Produit</h1>
	<s:a href="product/add.jsp">Add Produit</s:a>
	<s:a href="product/listAction.action">List Produit</s:a>

</body>
</html>
