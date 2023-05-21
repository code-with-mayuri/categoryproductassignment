package com.example.demo.controller;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
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
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {

	@Autowired
	CategoryService ser;
	@GetMapping("/getid")
public	List<Category> GetId( )
	{
		return  ser.GetId();
		
		
	}
	@PostMapping("savedata")
	public Category savedata(@RequestBody Category category)
	{
		System.out.println(category);
		ser.savedata(category);
		return category;
		
	}

	@PutMapping("update")
	Category UpdateCategory( @RequestBody   Category category)
	{
		return ser.UpdateCategory(category);
	}
	
	@DeleteMapping("deletecategory/{cid}")
	public Category deletecategory(@PathVariable   int cid)
	{
		
		return ser.deletecategory(cid);
	}
	@RequestMapping("getalldata")
	public List<Category> getallcategory()
	{
		
		return ser.getallcategory();
		
		}
	
	@RequestMapping("getinfo/{cid}")
	public Category getCategory( @PathVariable   int cid)
	{
		Category category =	ser.getCategory(cid);
		if(category==null)
  	   {
System.out.println("categoery not found");  		   
  		   // raising exception using throw keyword
  	   }
  	   else
  	   {
  		   return category;
  	   }
		return category;
		
	}
}
