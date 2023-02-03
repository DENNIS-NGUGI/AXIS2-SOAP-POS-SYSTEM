package com.axis.model;

public class Sales {
	private int salesid;
	private int productid;
	private int qtysold;
	private float total;
	private String customername;
	private String servedby;
	
	
	public Sales() {

	}
	
	public Sales(int productid, int qtysold, float total, String customername, String servedby) {
		this.productid = productid;
		this.qtysold = qtysold;
		this.total = total;
		this.customername = customername;
		this.servedby = servedby;
	}
	
	public Sales(int salesid, int productid, int qtysold, float total, String customername, String servedby) {
		super();
		this.salesid = salesid;
		this.productid = productid;
		this.qtysold = qtysold;
		this.total = total;
		this.customername = customername;
		this.servedby = servedby;
	}
	
	
	public int getSalesid() {
		return salesid;
	}
	public void setSalesid(int salesid) {
		this.salesid = salesid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getQtysold() {
		return qtysold;
	}
	public void setQtysold(int qtysold) {
		this.qtysold = qtysold;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getServedby() {
		return servedby;
	}
	public void setServedby(String servedby) {
		this.servedby = servedby;
	}

	@Override
	public String toString() {
		return "Sales [salesid=" + salesid + ", productid=" + productid + ", qtysold=" + qtysold + ", total=" + total
				+ ", customername=" + customername + ", servedby=" + servedby + "]";
	}
	
}
