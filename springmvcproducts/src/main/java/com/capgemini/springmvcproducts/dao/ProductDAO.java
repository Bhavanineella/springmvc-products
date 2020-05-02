package com.capgemini.springmvcproducts.dao;

import java.util.List;

import com.capgemini.springmvcproducts.beans.ProductInfo;

public interface ProductDAO {
	public ProductInfo getProduct(int prodcutId);
	public boolean addProduct(ProductInfo productInfoBean);
	public boolean deleteProduct(int productId);
	public boolean updateProduct(ProductInfo productInfoBean);
	public List<ProductInfo> getAllProducts();
	
}
