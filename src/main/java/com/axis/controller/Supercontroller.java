package com.axis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.axis.model.Supplier;
import com.axis.service.Superservice;
import com.axis.model.Sales;
import com.axis.model.Stock;
import com.axis.model.Stockpurchase;

public class Supercontroller extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 319867896525879301L;
	
	public Supercontroller()
	{
		super();
	}
	
	
	protected void doGetSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int supplierid = Integer.parseInt(request.getParameter("supplierid"));
		String suppliername = request.getParameter("suppliername");
		String contact = request.getParameter("contact");
		
		Supplier supplier = new  Supplier();
		supplier.setSupplierid(supplierid);
		supplier.setSuppliername(suppliername);
		supplier.setContact(contact);
		
	try {
		
		int res = Superservice.InsertSupplier(supplier);
		if (res==0) {
			HttpSession session = request.getSession(true);
			session.setAttribute("Error", "Supplier Exist");
			//response.sendRedirect("");
		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("Valid", "Supplier Entered");
			//response.sendRedirect("");
		}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	protected void doGetStockpurchase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int productid = Integer.parseInt(request.getParameter("productid"));
		String productname = request.getParameter("productname");
		int supplierid = Integer.parseInt(request.getParameter("supplierid"));
		int qtybought = Integer.parseInt(request.getParameter("qtybought"));
		Float buyingprice = Float.parseFloat(request.getParameter("buyingprice"));
		
		Stockpurchase stockpurchase = new  Stockpurchase();
		stockpurchase.setProductid(productid);
		stockpurchase.setProductname(productname);
		stockpurchase.setSupplierid(supplierid);
		stockpurchase.setQtybought(qtybought);
		stockpurchase.setBuyingprice(buyingprice);
		
	try {
		
		int res1 = Superservice.stockPurchase(stockpurchase);
		if (res1==0) {
			HttpSession session = request.getSession(true);
			session.setAttribute("Error", "Stock Exist");
			//response.sendRedirect("");
		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("Valid", "Stock Entered");
			//response.sendRedirect("");
		}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	protected void doGetStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int stockid = Integer.parseInt(request.getParameter("stockid"));
		int productid = Integer.parseInt(request.getParameter("productid"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		Float sellingprice = Float.parseFloat(request.getParameter("sellingprice"));
		
		Stock stock = new  Stock();
		stock.setStockid(stockid);
		stock.setProductid(productid);
		stock.setQty(qty);
		stock.setSellingprice(sellingprice);
		
	try {
		
		int res2 = Superservice.InsertStock(stock);
		if (res2==0) {
			HttpSession session = request.getSession(true);
			session.setAttribute("Error", "Stock Exist");
			//response.sendRedirect("");
		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("Valid", "Stock Entered");
			//response.sendRedirect("");
		}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	protected void doGetSales(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int salesid = Integer.parseInt(request.getParameter("salesid"));
		int productid = Integer.parseInt(request.getParameter("productid"));
		int qtysold = Integer.parseInt(request.getParameter("qtysold"));
		Float total = Float.parseFloat(request.getParameter("total"));
		String customername = request.getParameter("customername");
		String servedby = request.getParameter("servedby");
		
		Sales sales = new  Sales();
		sales.setSalesid(salesid);
		sales.setProductid(productid);
		sales.setQtysold(qtysold);
		sales.setTotal(total);
		sales.setCustomername(customername);
		sales.setServedby(servedby);
		
	try {
		
		int res3 = Superservice.computeSales(sales);
		if (res3==0) {
			HttpSession session = request.getSession(true);
			session.setAttribute("Error", "Stock Exist");
			//response.sendRedirect("");
		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("Valid", "Stock Entered");
			//response.sendRedirect("");
		}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	
	protected void doDeletePurchase(HttpServletRequest request, HttpServletResponse response) {
		int product_id = Integer.parseInt(request.getParameter("productid"));
		
		try {
			 Superservice.deletePurchase(product_id);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doUpdatePurchase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int productid = Integer.parseInt(request.getParameter("productid"));
		String productname = request.getParameter("productname");
		float buyingprice = Float.parseFloat(request.getParameter("buyingprice"));
		int supplierid = Integer.parseInt(request.getParameter("supplierid"));
		int qtybought = Integer.parseInt(request.getParameter("qtybought"));
		
		Stockpurchase purchase = new Stockpurchase();
		purchase.setProductid(productid);
		purchase.setProductname(productname);
		purchase.setBuyingprice(buyingprice);
		purchase.setSupplierid(supplierid);
		purchase.setQtybought(qtybought);
		
	try {
		int res = Superservice.updatePurchase(purchase);
		if (res==0) {
			HttpSession session = request.getSession(true);
			session.setAttribute("Error", "Unable to update purchase");
		} else {
			HttpSession session = request.getSession(true);
			session.setAttribute("Valid", "Purchase updated");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
