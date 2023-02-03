package com.axis.model;

public class Stock {
	
	private int stockid;
	private int productid;
	private int qty;
	private float sellingprice;
	
		
	public Stock() {

	}
	public Stock(int productid, int qty, float sellingprice) {
		this.productid = productid;
		this.qty = qty;
		this.sellingprice = sellingprice;
	}
	public Stock(int stockid, int productid, int qty, float sellingprice) {
		super();
		this.stockid = stockid;
		this.productid = productid;
		this.qty = qty;
		this.sellingprice = sellingprice;
	}
	
	public int getStockid() {
		return stockid;
	}
	public void setStockid(int stockid) {
		this.stockid = stockid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getSellingprice() {
		return sellingprice;
	}
	public void setSellingprice(float sellingprice) {
		this.sellingprice = sellingprice;
	}
	
	
	@Override
	public String toString() {
		return "Stock [stockid=" + stockid + ", productid=" + productid + ", qty=" + qty + ", sellingprice="
				+ sellingprice + "]";
	}
}
