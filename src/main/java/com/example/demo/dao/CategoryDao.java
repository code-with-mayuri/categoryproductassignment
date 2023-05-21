package com.example.demo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Category;


@Repository
public class CategoryDao {
	@Autowired
	SessionFactory cf;


	public Category savedata(Category category) {
		Session session=cf.openSession();
	Transaction tr=	session.beginTransaction();
		session.save(category);
		tr.commit();
		/*
		 * session.close();
		 */		return  category;
	}
	public List<Category> GetId() {
		Session session = cf.openSession();
		
		/*
		 * Category cr= session.get(Category.class, cid);
		 */		  
		  Query query=session.createQuery("from Category");// HQL - class & variables
		  List<Category> list=query.getResultList();
		  
		  
		  
		  return list ;
		 
		
		/*
		 * Transaction tr=session.beginTransaction(); session.save(cr); return cr;
		 */
		

	}
	public Category getCategory(int cid) {
		Session session= cf.openSession();
	
		
		 Category category= session.get(Category.class, cid);
				 		
		
		/*
		 * Criteria cr=session.createCriteria(Category.class);
		 * 
		 * cr.add(Restrictions.eq("cid",cid)); List<Category> list= cr.list(); if
		 * (list.isEmpty()) { return null; } Category category=list.get(0);
		 */
		return category;
		

	}

	public Category UpdateCategory(Category category) {
     Session session=cf.openSession();
     Transaction tr=session.beginTransaction();
     session.update(category);
     tr.commit();
     return category;
	}

	public Category deletecategory(int cid) {
	     Session session=cf.openSession();
	     Category category=  session.get(Category.class, cid);
	     Transaction tr=session.beginTransaction();
	     session.delete(category);
	     tr.commit();
	     return category;

	}

	public List<Category> getallcategory() {
		Session session=cf.openSession();
		
		Criteria criteria=session.createCriteria(Category.class);
		
		List<Category> list=criteria.list();
				
		return list;		
	} 

}
