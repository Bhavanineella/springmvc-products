package com.capgemini.springmvcproducts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springmvcproducts.beans.ProductInfo;
import com.capgemini.springmvcproducts.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO dao;

	@Override
	public ProductInfo getProduct(int productId) {
		if (productId < 1) {
			return null;
		}
		return dao.getProduct(productId);
	}

	@Override
	public boolean addProduct(ProductInfo productInfoBean) {
		if (productInfoBean != null) {
			return dao.addProduct(productInfoBean);
		} else {
			return false;
		}

	}

	@Override
	public boolean deleteProduct(int productId) {
		if (productId < 1) {
			return false;
		} else {
			return dao.deleteProduct(productId);
		}
	}

	@Override
	public boolean updateProduct(ProductInfo productInfo) {
		if (productInfo.getProductId() > 1 && productInfoBean != null) {
			System.out.println("kjdcn"+productInfo.getProductId());
			return dao.updateProduct(productInfo);
		}else {
		return false;
	}
	}

	@Override
	public List<ProductInfo> getAllProducts() {
		return dao.getAllProducts();
	}

}
