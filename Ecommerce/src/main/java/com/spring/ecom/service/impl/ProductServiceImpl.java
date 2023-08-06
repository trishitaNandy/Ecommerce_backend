package com.spring.ecom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ecom.dao.ProductDao;
import com.spring.ecom.entities.Product;
import com.spring.ecom.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getProducts() {
		return productDao.findAll();
	}

	@Override
	public Product getProduct(Long productId) {
		return productDao.findById(productId).get();
	}

	@Override
	public Product addProduct(Product product) {
		productDao.save(product);
		return product;
	}

	@Override
	public Product updateProduct(Product product, Long productId) {
		Product existingProduct = productDao.findById(productId).orElse(null);

		if (existingProduct != null) {
			existingProduct.setProductName(product.getProductName());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setStockQuantity(product.getStockQuantity());

			productDao.save(existingProduct);
		}
		return existingProduct;
	}

	@Override
	public void deleteProduct(Long productId) {
		Product product=productDao.findById(productId).get();
		productDao.delete(product);

	}

}
