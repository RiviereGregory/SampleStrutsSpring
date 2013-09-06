package fr.treeptik.service;

import java.util.List;

import fr.treeptik.entity.Product;

public interface ProductService {
	public void add(Product product);

	public List<Product> getAll();

	public Product get(Integer id);

	public void delete(Integer productId);
}
