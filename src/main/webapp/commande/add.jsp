<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>

	<h2>Add Commande</h2>

	<s:actionerror />

	<s:form action="addAction">
		<s:hidden name="commande.id"></s:hidden>
		<s:select label="Employee" name="commande.employee.id" headerKey="-1"
			headerValue="-- Please Select --" list="employees" />
		<s:select label="Product" name="commande.product.id" headerKey="-1"
			headerValue="-- Please Select --" list="products" />
		<s:textfield name="commande.date" label="Date commande" />
		<s:submit />
	</s:form>
	<s:a href="../index.jsp">Index</s:a>


</body>
</html>
