<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>

	<h2>Add Products</h2>

	<s:actionerror />

	<s:form action="addAction">
		<s:hidden name="id"></s:hidden>
		<s:textfield name="ref" label="REF" />
		<s:textfield name="description" label="Description" />
		<s:submit />
	</s:form>
	<s:a href="../index.jsp">Index</s:a>


</body>
</html>
