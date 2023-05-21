package com.example.demo.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	int cid;
	String name;

	@OneToMany (targetEntity = Product.class,cascade = CascadeType.ALL)
	@JoinColumn(name="cid")
	List<Product> pro;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int cid, String name, List<Product> pro) {
		super();
		this.cid = cid;
		this.name = name;
		this.pro = pro;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getPro() {
		return pro;
	}

	public void setPro(List<Product> pro) {
		this.pro = pro;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", name=" + name + ", pro=" + pro + "]";
	}

}
