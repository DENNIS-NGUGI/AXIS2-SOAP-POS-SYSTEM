package com.axis.model;

public class Stockpurchase {
	
	private int productid;
	private String productname;
	private int supplierid;
	private int qtybought;
	private float buyingprice;
			
	public Stockpurchase() {

	}
	
	public Stockpurchase(String productname, int supplierid, int qtybought, float buyingprice) {
		this.productname = productname;
		this.supplierid = supplierid;
		this.qtybought = qtybought;
		this.buyingprice = buyingprice;
	}
	
	public Stockpurchase(int productid, String productname, int supplierid, int qtybought, float buyingprice) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.supplierid = supplierid;
		this.qtybought = qtybought;
		this.buyingprice = buyingprice;
	}
	
	
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public int getQtybought() {
		return qtybought;
	}
	public void setQtybought(int qtybought) {
		this.qtybought = qtybought;
	}
	public float getBuyingprice() {
		return buyingprice;
	}
	public void setBuyingprice(float buyingprice) {
		this.buyingprice = buyingprice;
	}

	@Override
	public String toString() {
		return "Stockpurchase [productid=" + productid + ", productname=" + productname + ", supplierid=" + supplierid
				+ ", qtybought=" + qtybought + ", buyingprice=" + buyingprice + "]";
	}
	
	

}
