package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Category;
import com.example.demo.pojo.Product;
import com.example.demo.pojo.ProductInfo;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductService ser;
	
	@PostMapping("addproduct/{cid}")
		public Product addProduct(@RequestBody Product product,@PathVariable int cid) 
		{
	return	ser.addProducts(product,cid);
		
		}
	@RequestMapping("getalldata")
	public List<Product> showdata()
	{
		
		return ser.showdata();
	}
	

	@PutMapping("updateproduct")
	public String updateProduct(@RequestBody Product pro)
	{
			return ser.updateProduct(pro)	;
	}
	@DeleteMapping("deleteid/{pid}")
	public Product deleteId(@PathVariable    int pid)
	{
	return	ser.deleteId(pid);
	}
	@RequestMapping("viewproduct/{pid}")
    public Product viewproduct(@PathVariable int pid)
	{
		return ser.viewproduct(pid);
	}
		
}
