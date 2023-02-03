package com.axis.model;

public class Supplier {
	private int supplierid;
	private String suppliername;
	private String contact;
	
	public Supplier() {

	}
	public Supplier(String suppliername, String contact) {
		this.suppliername = suppliername;
		this.contact = contact;
	}
	public Supplier(int supplierid, String suppliername, String contact) {
		super();
		this.supplierid = supplierid;
		this.suppliername = suppliername;
		this.contact = contact;
	}
	
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
		
	}
	@Override
	public String toString() {
		return "Supplier [supplierid=" + supplierid + ", suppliername=" + suppliername + ", contact=" + contact + "]";
	}
}
