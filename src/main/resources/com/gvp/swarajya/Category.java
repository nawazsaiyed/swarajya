package com.gvp.swarajya;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@Column(name="cate_id")
	private int id;
	@Column(name="category_name",length=40)
	private String categoryName;
	@Column(name="category_icon",length=30)
	private String categoryIcon;
	
	
	
	public Category(int id, String categoryName, String categoryIcon) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.categoryIcon = categoryIcon;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryIcon() {
		return categoryIcon;
	}
	public void setCategoryIcon(String categoryIcon) {
		this.categoryIcon = categoryIcon;
	}

	
}
