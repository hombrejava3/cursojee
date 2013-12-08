<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>id</td>
			<td><%=session.getId()%></td>
		</tr>
		<tr>
			<td>contador sesiones</td>
			<td><%=application.getAttribute("contadorSesiones")%></td>
		</tr>
		<%
			java.util.Enumeration attributeNames = session.getAttributeNames();
			while (attributeNames.hasMoreElements()) {
				String name = (String) attributeNames.nextElement();
				Object value =  session.getAttribute(name);
		%>
		<tr>
			<td><%=name%></td>
			<td><%=value%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
