package com.axis.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
	

	/*public Stockpurchase getPurchase(int productid) throws SQLException { 
		String GET_USER = "SELECT * FROM stockpurchase WHERE productid="+ productid;
		Stockpurchase purchase = null;
		ResultSet resultSet = null;
		try {
			Connection connection = Databaseconnection.connectDB();
			PreparedStatement statement = connection.prepareStatement(GET_USER);
			//Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(GET_USER);
			
			if(resultSet.next()) {
								
				statement.setInt(1,purchase.getProductid());
				statement.setString(2,purchase.getProductname());
				statement.setInt(3,purchase.getSupplierid());
				statement.setInt(4,purchase.getQtybought());
				statement.setFloat(5,purchase.getBuyingprice());

			}
		}finally {
			DbUtil.close(resultSet);
			//DbUtil.close(connection);
			//DbUtil.close(statement);
		}
		return purchase;
	}
	@SuppressWarnings("unused")
	public static List<Stockpurchase> fetch(int productid){
		
		Stockpurchase purchase=null;
		List<Stockpurchase> l = new ArrayList<Stockpurchase>();
		try {
			Connection connection = Databaseconnection.connectDB();
			String GET_USER = "SELECT * FROM stockpurchase WHERE productid=" + productid;
			PreparedStatement statement = connection.prepareStatement(GET_USER);
			//Statement statement = connection.createStatement();
			ResultSet rs= statement.executeQuery(GET_USER);
			int i = 1;
			
				
			while(rs.next()) {
				
				purchase = new Stockpurchase();
				purchase.setProductid(rs.getInt(1));
				purchase.setProductname(rs.getString(2));
				purchase.setSupplierid(rs.getInt(3));
				purchase.setQtybought(rs.getInt(4));
				purchase.setBuyingprice(rs.getFloat(5));
								


			}}
			catch(Exception e) {System.out.println(e);}
			
		return l;
	}*/
	
	public Stockpurchase getPurchase(int productid) throws SQLException {
		String query = "SELECT * FROM stockpurchase WHERE productid="+productid;
		Stockpurchase purchase = null;
		ResultSet resultSet = null;
		try {
			Connection connection = Databaseconnection.connectDB();
			java.sql.Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			if(resultSet.next()) {
				purchase = new Stockpurchase();
				purchase.setProductid(resultSet.getInt("productid"));
				purchase.setProductname(resultSet.getString("productname"));
				purchase.setBuyingprice(resultSet.getFloat("buyingprice"));
				purchase.setSupplierid(resultSet.getInt("supplierid"));
				purchase.setQtybought(resultSet.getInt("qtybought"));
			}
		}finally {
			DbUtil.close(resultSet);

		}
		return purchase;
	}
	
	
	public List<Stockpurchase> getAllPurchases() throws SQLException {
		String query = "SELECT * FROM Stockpurchase";
		List<Stockpurchase> list = new ArrayList<Stockpurchase>();
		Stockpurchase purchase = null;
		ResultSet resultSet = null;
		try {
			Connection connection = Databaseconnection.connectDB();
			java.sql.Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				purchase = new Stockpurchase();
				/*Retrieve one employee details 
                and store it in employee object*/
				purchase.setProductid(resultSet.getInt("productid"));
				purchase.setProductname(resultSet.getString("productname"));
				purchase.setBuyingprice(resultSet.getFloat("buyingprice"));
				purchase.setSupplierid(resultSet.getInt("supplierid"));
				purchase.setQtybought(resultSet.getInt("qtybought"));
				
				list.add(purchase);
			}
		}finally {
			DbUtil.close(resultSet);

		}
		return list;
	}
	
	public List<Stock> getAllStock() throws SQLException {
		String query = "SELECT * FROM Stock";
		List<Stock> list = new ArrayList<Stock>();
		Stock stock = null;
		ResultSet resultSet = null;
		try {
			Connection connection = Databaseconnection.connectDB();
			java.sql.Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				stock = new Stock();
				

				
				stock.setStockid(resultSet.getInt("stockid"));
				stock.setProductid(resultSet.getInt("productid"));
				stock.setQty(resultSet.getInt("qty"));
				stock.setSellingprice(resultSet.getFloat("sellingprice"));

				
				list.add(stock);
			}
		}finally {
			DbUtil.close(resultSet);

		}
		return list;
	}
	public static int deletePurchase(int productid) throws ClassNotFoundException {
		String query = "DELETE FROM Stockpurchase WHERE productid="+productid+";";
		int insertResult = 0;
		
		try{
			Connection con = Databaseconnection.connectDB();
			PreparedStatement statement = con.prepareStatement(query);
			insertResult = statement.executeUpdate();		
			
		}catch(Exception e){
			System.out.println(e);
		}
		return insertResult;
	}

	public static int updatePurchase(Stockpurchase purchase) throws ClassNotFoundException{
			String query = "UPDATE Stockpurchase SET productname=?,buyingprice=?,supplierid=?,qtybought=? WHERE productid=?;";
			int insertResult = 0;
			
			try{
				Connection con = Databaseconnection.connectDB();
		
				PreparedStatement statement = con.prepareStatement(query);
				statement.setString(1, purchase.getProductname());
				statement.setFloat(2, purchase.getBuyingprice());
				statement.setInt(3, purchase.getSupplierid());
				statement.setInt(4, purchase.getQtybought());
				statement.setInt(5, purchase.getProductid());
				
				insertResult = statement.executeUpdate();		
				
			}catch(Exception e){
				System.out.println(e);
			}
			return insertResult;

	}
	


	
	
	
}
