package com.gvp.swarajya;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sub_category")
public class SubCategory {
	@Column(name="sc_id")
	private int id;

	@Column(name="ref_id")
	private int refId;
	
	@Column(name="ref_from")
	private int refFrom;
	
	@Column(name="sub_category_name",length=40)
	private String subCategoryName;
	
	@Column(name="icon",length=30)
	private String icon;

	public SubCategory(int id, int refId, int refFrom, String subCategoryName, String icon) {
		super();
		this.id = id;
		this.refId = refId;
		this.refFrom = refFrom;
		this.subCategoryName = subCategoryName;
		this.icon = icon;
	}

	public SubCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	public int getRefFrom() {
		return refFrom;
	}

	public void setRefFrom(int refFrom) {
		this.refFrom = refFrom;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
	
}
