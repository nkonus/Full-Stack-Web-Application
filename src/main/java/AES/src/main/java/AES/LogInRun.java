package AES.src.main.java.AES;

import java.util.Scanner;

public class LogInRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//**********this code creates username and encrypted password and stores them in a database
	    
		Scanner sc = new Scanner(System.in);
		//LogInBody lb = new LogInBody();

	    LogInBody.getConnectionPractice();
	    String secretKey = "yabbadabbado!";
	        
	    System.out.println("Enter Username:");
	    String username = sc.nextLine();
	        
	    System.out.println("Enter password");
	    String password = sc.nextLine();
	        
	    LogInBody.createUser(username, password);
	    String originalString = password;
	        
	    String encryptedString = LogInBody.encrypt(originalString, secretKey) ;
	    String decryptedString = LogInBody.decrypt(encryptedString, secretKey) ;
	        
	    System.out.println(originalString);
	    System.out.println(encryptedString);
	    System.out.println(decryptedString);
	    }

	}
