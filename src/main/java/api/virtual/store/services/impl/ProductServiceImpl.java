package api.virtual.store.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.virtual.store.handler.RulesException;
import api.virtual.store.model.Client;
import api.virtual.store.model.Product;
import api.virtual.store.repositories.ProductRepository;
import api.virtual.store.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void newProduct(Product product) {
		productRepository.save(product);
	}
	
	@Override
	public Iterable<Product> allProduct(){
		return productRepository.findAll();
	}
	
	@Override
	public Product findProductById(Long id){
		Optional<Product> product = productRepository.findById(id);
		return product.get();
	}
	
	@Override
	public void update(Long id, Product product){
		Product productbd = productRepository.findById(id)
				.orElseThrow(() -> new RulesException("Product not found"));
		
		productRepository.save(product);
	}
	
	@Override
	public void deleteProduct(Long id){
		productRepository.deleteById(id);
	}
}
