<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Products</title>
</head>
<body>
	<table border="1px" cellpadding="8px">
		<tr>
			<th>ID</th>
			<th>REF</th>
			<th>DESC</th>
			<th>Action</th>
		</tr>
		<s:iterator value="products">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="ref" /></td>
				<td><s:property value="description" /></td>
				<!-- Permet de creer un lien pour supprimer le produit -->
				<td><s:url id="urlSupp" action="suppAction" includeParams="get">
						<s:param name="idToDelete" value="id" />
					</s:url> <s:a href="%{urlSupp}">Supprimer</s:a></td>

				<!-- Permet de creer un lien pour modifierl'employee -->
				<td><s:url id="urlModif" action="modifAction"
						includeParams="get">
						<s:param name="product.id" value="id" />
						<s:param name="product.ref" value="ref" />
						<s:param name="product.description" value="description" />
					</s:url> <s:a href="%{urlModif}">Modife</s:a></td>

			</tr>
		</s:iterator>
		<tr>
			<td><s:a href="add.jsp">Ajouter</s:a></td>
			<td><s:a href="../index.jsp">Index</s:a></td>
		</tr>
	</table>
</body>
</html>
