<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="2">Context</td>
		</tr>
		<%
			java.util.Enumeration contextAttributeNames = application.getAttributeNames();
			while (contextAttributeNames.hasMoreElements()) {
				String name = (String) contextAttributeNames.nextElement();
				if (name.contains(".")){
					continue;
				}
				Object value =  application.getAttribute(name);
		%>
		<tr>
			<td><%=name%></td>
			<td><%=value%></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="2">Session</td>
		</tr>
		<tr>
			<td>id</td>
			<td><%=session.getId()%></td>
		</tr>
		<%
			java.util.Enumeration sessionAttributeNames = session.getAttributeNames();
			while (sessionAttributeNames.hasMoreElements()) {
				String name = (String) sessionAttributeNames.nextElement();
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
