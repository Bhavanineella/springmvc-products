package com.capgemini.springmvcproducts.service;

import java.util.List;

import com.capgemini.springmvcproducts.beans.ProductInfo;

public interface ProductService {

	public ProductInfo getProduct(int productId);
	public boolean addProduct(ProductInfo productInfoBean);
	public boolean deleteProduct(int productId);
	public boolean updateProduct(ProductInfo productInfoBean);
	public List<ProductInfo> getAllProducts();
	
}
