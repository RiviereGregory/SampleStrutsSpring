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
			<th>EMPLOYEE</th>
			<th>PRODUIT</th>
			<th>DATE</th>
			<th>Action</th>
		</tr>
		<s:iterator value="commandes">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="employee" /></td>
				<td><s:property value="product" /></td>
				<td><s:property value="date" /></td>
				<!-- Permet de creer un lien pour supprimer le produit -->
				<td><s:url id="urlSupp" action="suppAction" includeParams="get">
						<s:param name="idToDelete" value="id" />
					</s:url> <s:a href="%{urlSupp}">Supprimer</s:a></td>

				<!-- Permet de creer un lien pour modifierl'employee -->
				<td><s:url id="urlModif" action="modifAction"
						includeParams="get">
						<s:param name="commande.id" value="id" />
					</s:url> <s:a href="%{urlModif}">Modife</s:a></td>

			</tr>
		</s:iterator>
		<tr>
			<td><s:a href="initAction.action">Ajouter</s:a></td>
			<td><s:a href="../index.jsp">Index</s:a></td>
		</tr>
	</table>
</body>
</html>
