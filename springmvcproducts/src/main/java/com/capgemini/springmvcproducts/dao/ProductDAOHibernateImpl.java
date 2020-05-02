package com.capgemini.springmvcproducts.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.springmvcproducts.beans.ProductInfo;

@Repository
public class ProductDAOHibernateImpl implements ProductDAO {
	
	
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public ProductInfo getProduct(int empId) {
		EntityManager manager = factory.createEntityManager();
		ProductInfo productInfoBean = manager.find(ProductInfo.class, empId);
		manager.close();
		return productInfoBean;
	}

	@Override
	public boolean addProduct(ProductInfo productInfoBean) {
		boolean isAdded = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(productInfoBean);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public boolean deleteProduct(int productId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isDeleted = false;
		try {
			transaction.begin();
			ProductInfo productInfo = manager.find(ProductInfo.class, productId);
			System.out.println(productInfo.getProductId());
			System.out.println(productInfo.getProductName());
			manager.remove(productInfo);
			transaction.commit();
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return isDeleted;
	}

	@Override
	public boolean updateProduct(ProductInfo productInfo) {
		EntityManager manager = factory.createEntityManager();
		ProductInfo bean = manager.find(ProductInfo.class, productInfo.getProductId());
		boolean isUpdated = false;
		if (bean != null) {
			try {
				System.out.println("in update"+productInfo.getProductName());
				EntityTransaction transaction = manager.getTransaction();
				transaction.begin();
				manager.remove(bean);
				manager.persist(productInfo);
				transaction.commit();
				isUpdated = true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} finally {
				manager.close();
			}

		}
		return isUpdated;
	}

	@Override
	public List<ProductInfo> getAllProducts() {
		EntityManager manager = factory.createEntityManager();
		String jpql = "Select p from ProductInfoBean p";
		Query query = manager.createQuery(jpql);
		List<ProductInfo> list = query.getResultList();
		return list;

	}

}
