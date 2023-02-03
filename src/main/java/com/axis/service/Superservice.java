package com.axis.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.axis.model.*;


public class Superservice {
	public static int InsertSupplier(Supplier supplier) throws ClassNotFoundException {
		String INPUT_USER = "INSERT INTO supplier" +
	"(supplierid, suppliername, contact) VALUES (?, ?, ?);";
		int insertResult = 0;
		
		try
		{
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermart?serverTimezone=UTC","root","10960301n.");
			
			Connection con = Databaseconnection.connectDB();
			//create a statement using Connection object
	
			PreparedStatement statement = con.prepareStatement(INPUT_USER);
			
			statement.setInt(1,supplier.getSupplierid());
			statement.setString(2, supplier.getSuppliername());
			statement.setString(3,supplier.getContact());
			
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return insertResult;
		
	}
	
	public static int InsertStock(Stock stock) throws ClassNotFoundException {
		String INPUT_USER = "INSERT INTO stock" +
	"(stockid, productid, qty, sellingprice) VALUES (?, ?, ?, ?);";
		int insertResult = 0;
		
		try
		{
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermart?serverTimezone=UTC","root","10960301n.");
			
			Connection con = Databaseconnection.connectDB();
			//create a statement using Connection object
	
			PreparedStatement statement = con.prepareStatement(INPUT_USER);
			
			statement.setInt(1,stock.getStockid());
			statement.setInt(2, stock.getProductid());
			statement.setInt(3,stock.getQty());
			statement.setFloat(4,stock.getSellingprice());
			
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return insertResult;
		
	}
	
	public static int computeSales(Sales sales) throws ClassNotFoundException {
		String INPUT_USER = "INSERT INTO sales" +
	"(salesid, productid, qtysold, total, customername, servedby) VALUES (?, ?, ?, ?, ?, ?);";
		int insertResult = 0;
		
		try
		{
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermart?serverTimezone=UTC","root","10960301n.");
			
			Connection con = Databaseconnection.connectDB();
			//create a statement using Connection object
	
			PreparedStatement statement = con.prepareStatement(INPUT_USER);
			
			statement.setInt(1, sales.getSalesid());
			statement.setInt(2, sales.getProductid());
			statement.setInt(3,sales.getQtysold());
			statement.setFloat(4,sales.getTotal());
			statement.setString(5,sales.getCustomername());
			statement.setString(6,sales.getServedby());
			
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return insertResult;
		
	}
	
	
	public static int stockPurchase(Stockpurchase stockpurchase) throws ClassNotFoundException {
		String INPUT_USER = "INSERT INTO stockpurchase" +
	"(productid, productname, supplierid, qtybought, buyingprice) VALUES (?, ?, ?, ?, ?);";
		int insertResult = 0;
		
		try
		{
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermart?serverTimezone=UTC","root","10960301n.");
			
			Connection con = Databaseconnection.connectDB();
			//create a statement using Connection object
	
			PreparedStatement statement = con.prepareStatement(INPUT_USER);
			
			statement.setInt(1,stockpurchase.getProductid());
			statement.setString(2,stockpurchase.getProductname());
			statement.setInt(3,stockpurchase.getSupplierid());
			statement.setInt(4,stockpurchase.getQtybought());
			statement.setFloat(5,stockpurchase.getBuyingprice());

			
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return insertResult;
		
	}
	
	


	
	
	
}
