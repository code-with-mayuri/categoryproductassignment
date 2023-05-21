package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Product;
import com.example.demo.pojo.ProductInfo;

@Service

public class ProductService {
@Autowired
ProductDao dao;
public Product addProducts( Product pro,int cid) {
	// TODO Auto-generated method stub
return 	dao.addProducts(pro,cid);
	
}
public List<Product> showdata() {
	   return dao.showdata() ;	
		}
public String updateProduct(Product pro) {
	return dao.updateProduct(pro);
}
public Product deleteId(int pid) {
    return  dao.deleteId(pid);
	}
public Product viewproduct(int pid)
{
	return dao.viewproduct(pid);
}

}
