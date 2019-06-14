package AES.src.main.java.AES;

public class AESrun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String secretKey = "cst341!";
	     
	    String password = "jimloui!";
	    String encryptedString = AES.encrypt(password, secretKey) ;
	    String decryptedString = AES.decrypt(encryptedString, secretKey) ;
	     
	    System.out.println(password);
	    System.out.println(encryptedString);
	    System.out.println(decryptedString);
	}

}
