<%@page import="java.util.List"%>
<%@page import="com.capgemini.springmvcproducts.beans.ProductInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	// List<ProdcutInfoBean> prodcutInfoBean2 = (List<ProdcutInfoBean>) request.getAttribute("beanList");
	List<ProductInfo> prodcutInfoBean2 = (List<ProductInfo>)request.getAttribute("beanList");
	String errMsg = (String) request.getAttribute("zero");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>
<div style="center">
	<a href="home">home</a>
	</div>
<fieldset>
		<legend>Search Product></legend>
		<form action="getProduct" method="get">
			<label>Product Id:</label> <input type="text" name="productId" required><br>
			<input type="submit" value="Search">
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
		if (prodcutInfoBean2 != null) {
	%>
	<div align="center">
	<table border="1" style="width: 60%">
		<tr style="background: navy; color: white;">
			<th>prodcutId</th>
			<th>prodcutName</th>
			<th>productPrice</th>
			<th>productDescription</th>
		</tr>
		<%
			for(ProductInfo prodcutInfoBean : prodcutInfoBean2){
		%>
		<tr>
			<td><%=prodcutInfoBean.getProductId()%></td>
			<td><%=prodcutInfoBean.getProductName() %></td>
			<td><%=prodcutInfoBean.getProductPrice()%></td>
			<td><%=prodcutInfoBean.getProductDescription()%></td>

		</tr>
		<% }%>
	</table>
	</div>
	<%} %>
</body>
</html>