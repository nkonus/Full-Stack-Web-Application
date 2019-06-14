package AES.src.main.java.AES;

//**********this code creates username and encrypted password and stores them in a database

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class LogInBody {

		static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		static final String ENDPOINT = "cst235loui.chk1hnimv5m9.us-west-2.rds.amazonaws.com";
		static final String PORT = "3306";
		static final String USER = "cst235loui";
		static final String PASS = "cst235loui!";
	    
	    static Connection conn;
	    static Scanner sc = new Scanner(System.in);
	    
	    public static Connection getConnectionPractice() {
	        try {
	            //forName is static because using CLass to access it
	            Class.forName(JDBC_DRIVER);
	            String dbName = "cst235loui";
	            
	            String jdbcConnect = "jdbc:mysql://" + ENDPOINT + ":" + PORT + "/" + dbName + "?user=" + USER + "&password=" + PASS;
	            //System.out.println(jdbcConnect);
	            conn = DriverManager.getConnection(jdbcConnect);    
	            
	        }catch(Exception e) {
	            System.out.println(e.toString());
	        }
	        finally {
	            System.out.println("I got connected!!!!");
	        }
	        return conn;
	    }

	   private static SecretKeySpec secretKey;
	   private static byte[] key;


	   public static void setKey(String myKey)
	   {
	       MessageDigest sha = null;
	       try {
	           key = myKey.getBytes("UTF-8");
	           sha = MessageDigest.getInstance("SHA-1");
	           key = sha.digest(key);
	           key = Arrays.copyOf(key, 16);
	           secretKey = new SecretKeySpec(key, "AES");
	       }
	       catch (NoSuchAlgorithmException e) {
	           e.printStackTrace();
	       }
	       catch (UnsupportedEncodingException e) {
	           e.printStackTrace();
	       }
	   }

	   public static void createUser(String username, String password) {
	       Statement sqlText = null;
	       
	       try
	       {
	           //creating a statement (statement variable) = conn(connection variable)
	           sqlText = conn.createStatement();
	           //inserting info into these column names
	           String sql = "INSERT INTO users2 (uname, upassword)\n" +
	           //values username (variable/parameter) + encrypt method name (encrypt variable/parameter "create a key name")
	                   " VALUES ('"+username+"', '"+encrypt(password, "yabbadabbado!")+"');";
	                  // " VALUES ('"+username+"', '"+encryptedString+"');";
	           System.out.println(sql);
	           sqlText.execute(sql);

	         }
	         catch (Exception e)
	         {
	           System.err.println("Got an exception!");
	           System.err.println(e.getMessage());
	         }
	       }

	   public static String encrypt(String strToEncrypt, String secret)
	   {
	       try
	       {
	           setKey(secret);
	           Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	           cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	           return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	       }
	       catch (Exception e)
	       {
	           System.out.println("Error while encrypting: " + e.toString());
	       }
	       return null;
	   }

	   public static String decrypt(String strToDecrypt, String secret)
	   {
	       try
	       {
	           setKey(secret);
	           Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	           cipher.init(Cipher.DECRYPT_MODE, secretKey);
	           return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	       }
	       catch (Exception e)
	       {
	           System.out.println("Error while decrypting: " + e.toString());
	       }
	       return null;
	   }
	}
