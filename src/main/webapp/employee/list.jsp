<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Employee</title>
</head>
<body>
	<table border="1px" cellpadding="8px">
		<tr>
			<th>ID</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
			<th>Telephone</th>
			<th colspan="2">Action</th>
		</tr>
		<s:iterator value="employees">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="firstname" /></td>
				<td><s:property value="lastname" /></td>
				<td><s:property value="email" /></td>
				<td><s:property value="telephone" /></td>

				<!-- Permet de creer un lien pour supprimer l'employee -->
				<td><s:url id="urlSupp" action="suppAction" includeParams="get">
						<s:param name="idToDelete" value="id" />
					</s:url> <s:a href="%{urlSupp}">Supprimer</s:a></td>

				<!-- Permet de creer un lien pour modifierl'employee -->
				<td><s:url id="urlModif" action="modifAction"
						includeParams="get">
						<s:param name="employee.id" value="id" />
						<s:param name="employee.firstname" value="firstname" />
						<s:param name="employee.lastname" value="lastname" />
						<s:param name="employee.email" value="email" />
						<s:param name="employee.telephone" value="telephone" />
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
