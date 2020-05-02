<%@page import="com.capgemini.springmvcproducts.beans.ProductInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	ProductInfo productInfoBean = (ProductInfo) request.getAttribute("productInfo");
	String errMsg = (String) request.getAttribute("errmsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>

	<div>
		<a href="home">home</a>
	</div>
	<fieldset>
		<legend>Search Product></legend>
		<form action="getProduct" method="get">
			<label>Employee Id:</label> <input type="text" name="productId"
				required><br> <input type="submit" value="Search">
		</form>
	</fieldset>
	<%
		if ((errMsg != null) && !errMsg.isEmpty()) {
	%>
	<h3 style="color: red;"><%=errMsg%></h3>
	<%
		}
	%>
	<%
		if (productInfoBean != null) {
	%>
	<div align="center">
		<table border="1" style="width: 60%">
			<tr style="background: navy; color: white;">
				<th>productId</th>
				<th>productName</th>
				<th>productPrice</th>
				<th>productDescription</th>

			</tr>
			<tr>
				<td><%=productInfoBean.getProductId()%></td>
				<td><%=productInfoBean.getProductName()%></td>
				<td><%=productInfoBean.getProductPrice()%></td>
				<td><%=productInfoBean.getProductDescription()%></td>

			</tr>

		</table>
	</div>
	<%
		}
	%>
</body>
</html>