<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Product</title>
</head>
<body>

<div style="center">
	<a href="home">home</a>
	</div>
	<fieldset>
		<legend>Delete Product Form</legend>
		<form action="deleteProduct" >
			<table>
				<tr>
					<td>ProductId</td>
					<td><input type="number" id="productId" name="productId"></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="submit">
					</td>
				</tr>

			</table>
		</form>
	</fieldset>
</body>
</html>