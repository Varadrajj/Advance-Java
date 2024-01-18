package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Product;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService pservice;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.ok(pservice.displayAllProducts());
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getbyid(@PathVariable int id){
		Product p=pservice.getById(id);
		if(p!=null) {
			return ResponseEntity.ok(p);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	@PostMapping("/products/{pid}")
	public ResponseEntity<String> addproduct(@RequestBody Product p){
		pservice.addNewProduct(p);
		return ResponseEntity.ok("Data Added Sucessfully");
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		pservice.deleteById(id);
		return ResponseEntity.ok("Deleted Successfully");
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<String> updateProduct(@RequestBody Product p){
		pservice.updateById(p);
		return ResponseEntity.ok("Modified Successfully");
	}
//	
//	@GetMapping("/products/{title}")
//	public ResponseEntity<Product> getByName(@PathVariable String title){
//		Product p=pservice.getByName(title);
//		if(p!=null) {
//			return ResponseEntity.ok(p);
//		}else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//	}
//	
	
	
}
