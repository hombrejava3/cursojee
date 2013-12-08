<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="ControllerServlet?action=agregarEmpleadoAnual">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input name="nombre" /></td>
			</tr>
			<tr>
				<td>Direccion:</td>
				<td><input name="direccion" /></td>
			</tr>
			<tr>
				<td>Dni:</td>
				<td><input name="dni" /></td>
			</tr>
			<tr>
				<td>Salario anual:</td>
				<td><input name="salarioAnual" /></td>
			</tr>
		</table>
		<input type="submit" />
	</form>
</body>
</html>
