import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import com.axis.model.Stockpurchase;
import com.axis.model.Supplier;
import com.axis.model.User;
//import com.axis.service.MarqueeTest;
import com.axis.service.Superservice;






public class MainApplication {
	
	public static void main(String[] args) throws Exception{
//		MarqueeTest marq = new MarqueeTest();
//		
//		marq.display();
//		
	
		ASCIIArtGenerator artGen = new ASCIIArtGenerator();
		 System.out.println(); 
		 artGen.printTextArt("SUPERMART SYSTEM",ASCIIArtGenerator.ART_SIZE_MEDIUM); System.out.println();
		 

		 
		String dec;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you want to Register? y/n");
		dec = scanner.nextLine();
		if(dec.equalsIgnoreCase("y")) {
			Register();
				
			}
		else if(dec.equalsIgnoreCase("n")) {
			Login();
			
		}else {
			
			System.out.println("Wrong Input, Use y for Yes and n for No"  );
			clearC();
			main(args);
			
			
		}
		
		scanner.close();

		}
	
	
	public static void clearC() throws AWTException {


        Robot robbie = new Robot();
        //shows the Console View
        robbie.keyPress(KeyEvent.VK_ALT);
        robbie.keyPress(KeyEvent.VK_SHIFT);
        robbie.keyPress(KeyEvent.VK_Q);
        robbie.keyRelease(KeyEvent.VK_ALT);
        robbie.keyPress(KeyEvent.VK_SHIFT);
        robbie.keyPress(KeyEvent.VK_Q);
        robbie.keyPress(KeyEvent.VK_C);
        robbie.keyRelease(KeyEvent.VK_C);

        //clears the console
        robbie.keyPress(KeyEvent.VK_SHIFT);
        robbie.keyPress(KeyEvent.VK_F10);
        robbie.keyRelease(KeyEvent.VK_SHIFT);
        robbie.keyRelease(KeyEvent.VK_F10);
        robbie.keyPress(KeyEvent.VK_R);
        robbie.keyRelease(KeyEvent.VK_R);
		
	}
		public static void Register() {
		
		String username, useremail, password;

		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("To Register Fill Form");
			System.out.println("Name");
			username = scanner.nextLine();
			System.out.println("Email");
			useremail = scanner.nextLine();
			System.out.println("Password");
			password = scanner.nextLine();

			
			User user = new User();
			user.setUsername(username);
			user.setUseremail(useremail);
			user.setPassword(password);
			
			Superservice.RegisterUser(user);
			//scanner.close();
			System.out.println("User Registered");
			
			Login();

			}
			
		catch (Exception e)
		{
			System.out.println("Data Not Inserted!");
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void Login() throws ClassNotFoundException {
		
		String  useremail, password;
		Superservice service = new Superservice();
		User user = new User();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your Credentials to Login");
		System.out.println("Email");
		useremail = scanner.nextLine();
		System.out.println("Password");
		password = scanner.nextLine();
		
		
		if(useremail.isEmpty() || password.isEmpty()) {
			System.out.println("Email and Password cannot be empty");
			}
		else {
			user.setUseremail(useremail);
			user.setPassword(password);
			try {
				service.Login(user);
				Decision();
				
			}
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
							
			}
		//scanner.close();
		
	}
	
	public static void supplierInsert() {
		
		String supplierid, suppliername, contact;

		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the number of Suppliers: ");

			int numberOfSuppliers = scanner.nextInt();
			int countInsertion = 0;
			int countInformationToDisplay = 1;

			while (countInsertion < numberOfSuppliers) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter Details for Supplier #" + countInformationToDisplay);
			System.out.println(" ");
			System.out.println("Supplier ID:\t");
			supplierid = reader.readLine();
			System.out.println("Supplier Name:\t");
			suppliername = reader.readLine();
			System.out.println("Supplier Contact:\t");
			contact = reader.readLine();
			
			Supplier supplier = new Supplier();
			supplier.setSupplierid(Integer.parseInt(supplierid));
			supplier.setSuppliername(suppliername);
			supplier.setContact(contact);
						
			int rowInserted = Superservice.InsertSupplier(supplier);
			
			if(rowInserted > 0) {
				++countInsertion;
				++countInformationToDisplay;
			}
			//scanner.close();			
			System.out.println("" + countInsertion +"Supplier Details Inserted.");
			Decision();
			}
			}
		catch (Exception e)
		{
			System.out.println("Data Not Inserted!");
			e.printStackTrace();
		}
		
	}
	
	public static void Decision() throws SQLException, ClassNotFoundException {
		Superservice service = new Superservice();
		String dec;
		Scanner scanner = new Scanner(System.in);
		System.out.println("\t WELCOME TO SUPERMART");
		System.out.println("\t ////////////////////");
		System.out.println("SERVICES AVAILABLE: Type specific abreviation to Continue");
		System.out.print("\n View Stock = vs \n Insert Supplier = is"
				+ "\n Purchase Stock = ps \n Compute Sales  cs \n View Invoice = vi"
				+ "\n Delete Purchase = dp \n //////////////////// ");
		
		System.out.println("\nEnter Service (Service Abbreviation:");
		dec = scanner.nextLine();
		if(dec.equalsIgnoreCase("vs")) {
			
			service.getAllStock();
							
			}
		else if(dec.equalsIgnoreCase("is")) {
			InsertSupplier1();
			
		}
		else if(dec.equalsIgnoreCase("ps")) {
			InsertStock();
			
			
		}
		else if(dec.equalsIgnoreCase("vi")) {
			getInvoice();			
		}
		else if(dec.equalsIgnoreCase("dp")) {
			deletePurchase();			
		}
		else {
			System.out.println("Wrong Input, Use y for Yes and n for No");

		}
		
		//scanner.close();

	}
	public static void InsertSupplier1() {
		
		String suppliername,contact;
		int supplierid;

		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("To Insert the supplier fill the form");
			System.out.println("ID");
			supplierid = Integer.parseInt(scanner.nextLine());
			System.out.println("Supplier Name");
			suppliername = scanner.nextLine();
			System.out.println("Contact");
			contact = scanner.nextLine();

			
			Supplier supplier = new Supplier();
			supplier.setSupplierid(supplierid);
			supplier.setSuppliername(suppliername);
			supplier.setContact(contact);
			
			Superservice.InsertSupplier(supplier);
			System.out.println("Supplier Registered Succesfully!");
			Decision();
			}
		
			
		catch (Exception e)
		{
			System.out.println("Supplier Not Inserted!");
			e.printStackTrace();
		}		
	}
	public static void InsertStock() {
		
		String productname;
		int productid, qtybought, supplierid;
		float buyingprice;

		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("To Insert the Stock fill the form");
			System.out.println("Product ID");
			productid = Integer.parseInt(scanner.nextLine());
			System.out.println("Product Name");
			productname = scanner.nextLine();
			System.out.println("Supplier ID");
			supplierid = Integer.parseInt(scanner.nextLine());
			System.out.println("Qty Bought");
			qtybought = Integer.parseInt(scanner.nextLine());
			System.out.println("Buying Price");
			buyingprice = Float.parseFloat(scanner.nextLine());

			
			Stockpurchase purchase = new Stockpurchase();
			purchase.setProductid(productid);
			purchase.setProductname(productname);
			purchase.setSupplierid(supplierid);
			purchase.setQtybought(qtybought);
			purchase.setBuyingprice(buyingprice);

			
			Superservice.stockPurchase(purchase);
			System.out.println("Stock Succesfully Inserted!");
			Decision();
			}
		
			
		catch (Exception e)
		{
			System.out.println("Stock Not Inserted!");
			e.printStackTrace();
		}		
	}
	public static void deletePurchase() {
		

		int productid;


		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("To delete purchase Product ID");
			System.out.println("Product ID");
			productid = Integer.parseInt(scanner.nextLine());
			

			
			Stockpurchase purchase = new Stockpurchase();
			purchase.setProductid(productid);
			
			Superservice.deletePurchase(productid);
			System.out.println("Stock Succesfully Deleted!");
			Decision();
			}
		
			
		catch (Exception e)
		{
			System.out.println("Try Again");
			e.printStackTrace();
		}		
	}
	public static void getInvoice() {
		

		int productid;


		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("To View Invoice Enter Product ID");
			System.out.println("Product ID");
			productid = Integer.parseInt(scanner.nextLine());
			

			
			Stockpurchase purchase = new Stockpurchase();
			purchase.setProductid(productid);
			
			Superservice.getInvoice(productid);
			System.out.println("\n ///////////////////////////// \n");
			Decision();
			}
		
			
		catch (Exception e)
		{
			System.out.println("Try Again");
			e.printStackTrace();
		}		
	}
	
//	public static void Art() {
//		ASCIIArtGenerator artGen = new ASCIIArtGenerator();
//		System.out.println(); artGen.printTextArt("Hello",
//		ASCIIArtGenerator.ART_SIZE_MEDIUM); System.out.println();
//		System.out.println(); artGen.printTextArt("Love is life!",
//		ASCIIArtGenerator.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_MONO,"@");
//		System.out.println();
//		
//	}
//	

	

	
	
	
	}


			

	




