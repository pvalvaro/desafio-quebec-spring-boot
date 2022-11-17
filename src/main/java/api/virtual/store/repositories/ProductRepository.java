package api.virtual.store.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.virtual.store.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	boolean existsByProductName(String productName); 
}
