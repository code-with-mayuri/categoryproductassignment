package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoryDao;
import com.example.demo.pojo.Category;

@Service
public class CategoryService {
@Autowired
CategoryDao dao;

public Category savedata(Category category) {
	dao.savedata(category);
	return category;
}
public List<Category> GetId() {
	List<Category> list	=dao.GetId();
	return list;
}

public Category getCategory(int cid) {
	return   dao.getCategory(cid)	;
       
}
public Category UpdateCategory(Category category) {
	return dao.UpdateCategory(category);
}
public Category deletecategory(int cid) {
         return   dao.deletecategory( cid);
}
public List<Category> getallcategory() {
     return   dao.	getallcategory() ;
}

}
