package api.virtual.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.virtual.store.model.Product;
import api.virtual.store.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired 
	private ProductService productService;
		
	@PostMapping("/add")
	public ResponseEntity<Product> newProduct(@RequestBody Product product){
		productService.newProduct(product);
		return ResponseEntity.ok(product);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Object> allProduct(){
		return ResponseEntity.ok(productService.allProduct());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findProductById(@PathVariable Long id){
		return ResponseEntity.ok(productService.findProductById(id));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Product product){
		productService.update(id, product);
		return ResponseEntity.ok(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
		productService.deleteProduct(id);
		return ResponseEntity.ok().build();
	}
}
