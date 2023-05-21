package com.example.demo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.pojo.Category;
import com.example.demo.pojo.Product;
import com.example.demo.pojo.ProductInfo;
@Repository
public class ProductDao {
	@Autowired
	SessionFactory cf;
		public Product addProducts( Product product,@PathVariable int cid) 
		{
		Session session=cf.openSession();
		Category category=session.load(Category.class, cid);
		List<Product> productlist=category.getPro();
		
		
		Transaction transaction=session.beginTransaction();
		
			productlist.add(product);
						
		transaction.commit();
				
		System.out.println("product added into database");
		
		return product;
		}
		public List<Product> showdata() {
			Session session=cf.openSession();
			Criteria cr=session.createCriteria(Product.class);
			 List<Product> list=  cr.list();
			 return list;
			
			}
		
		public String updateProduct(Product pro) {
			// TODO Auto-generated method stub
			Session session=cf.openSession();
			
			
			Transaction transaction=session.beginTransaction();
			
				session.update(pro);
							
			transaction.commit();
			
			
			return "Record Updated";


		}
		public Product deleteId(int pid) {
			  Session session=cf.openSession();	
			  Product p=  session.get(Product.class, pid);
			  Transaction tr=session.beginTransaction();
			  session.delete(p);
			  tr.commit();
			  return p;
		}
		
		public Product viewproduct(int pid)
		{
			Session session=cf.openSession();
			
			Product product=session.get(Product.class,pid);
			
			return product;
		
		}	
		

		
}
