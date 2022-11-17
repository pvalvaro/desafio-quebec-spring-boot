package api.virtual.store.services;

import api.virtual.store.model.Product;

public interface ProductService {

	Iterable<Product> allProduct();
	Product findProductById(Long id);
	void newProduct(Product product);
	void update(Long id, Product product);
	void deleteProduct(Long id);
}
