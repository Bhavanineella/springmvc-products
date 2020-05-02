<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product Form</title>
</head>
<body>
<div style="center">
	<a href="home">home</a>
	</div>
	<form action="updateProduct" method="post">
		<table>

			<tr>

				<td><label>ProductId:</label></td>
				<td><input type="text" id="productId" name="productId" required><br>
				</td>
			</tr>
			<tr>
				<td><label>Product Name:</label></td>
				<td><input type="text" id="productName" name="productName"
					required><br></td>
			</tr>

			<tr>
				<td><label>Product Price:</label></td>
				<td><input type="text" id="productPrice" name="productPrice"
					required><br></td>
			</tr>
			<tr>
				<td><label>Product Designation:</label></td>
				<td><input type="text" id="productDescription"
					name="productDescription" required><br></td>

			</tr>
			</tr>
			<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>