package com.capgemini.springmvcproducts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.springmvcproducts.beans.ProductInfo;
import com.capgemini.springmvcproducts.service.ProductService;

@Controller
public class ProductController {

		@Autowired
		ProductService service;
			
		
		@GetMapping("home")
		public String home() {
			return "home";
		}

		@GetMapping("/getProductForm")
		public String getProductForm() {
			return "searchProduct";
		}
		@GetMapping("/getProduct")
		public String getProduct(int prodcutId,ModelMap map) {
			ProductInfo productInfoBean = service.getProduct(prodcutId);
			if(productInfoBean != null) {
				map.addAttribute("productInfo", productInfoBean);
			}else {
				map.addAttribute("errmsg","Product Id Not Found");
			}
			
			return "searchProduct";
		}

		@GetMapping("/addProductForm")
		public String addProductForm() {
			return "addProductForm";
		}
		
		@PostMapping("/addProduct")
		public String addProduct(ProductInfo productInfo,ModelMap map) {
			System.out.println(productInfo.getProductId());
			boolean isAdded = service.addProduct(productInfo);
			if(isAdded) {
				map.addAttribute("done","SucessFully added to the table");
			}else {
				map.addAttribute("notDone", "Unscessfull add to the table");
			}
			return "sucess";
		}
		
		@GetMapping("/deleteProductForm")
		public String deleteProductForm() {
			return "deleteProductForm";
		}
		@GetMapping("/deleteProduct")
		public String deleteProduct(int productId,ModelMap map) {
			boolean isDeleted = service.deleteProduct(productId);
			if(isDeleted) {
				map.addAttribute("done", "Successfully Deleted from the table");
			}else {
				map.addAttribute("Not Done", "Not Deleted");
			}
			return "sucess";
					
		}
		
		@GetMapping("/updateProductForm")
		public String updateProductForm() {
			return "updateProductForm";
		}
		
		@PostMapping("/updateProduct")
		public String updateProduct(ProductInfo productInfoBean,ModelMap map) {
			boolean isUpdated = service.updateProduct(productInfoBean);
			if(isUpdated) {
				map.addAttribute("done", "Successfully Updated from the table");
			}else {
				map.addAttribute("Not Done", "Not Updated");
			}
			return "sucess";
		}
		
		@GetMapping("/allProductDetails")
		public String allProductDetails(ModelMap map) {
			List<ProductInfo> beanList = service.getAllProducts();
			if(beanList.size()!=0) {
				map.addAttribute("beanList", beanList);
			}else {
				map.addAttribute("zero", "no products");
			}
			return "allProductDetails";
		}
		
	}


