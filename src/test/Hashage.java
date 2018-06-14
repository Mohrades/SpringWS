package test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.sun.org.apache.xml.internal.security.utils.Base64;




public class Hashage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parseurs.Base64 base64=new parseurs.Base64();
		System.out.println(getHash("Ernie"));
		System.out.println(calculatePasswordDigest(base64.decode("c3ByaW5nd3M="),"2014-09-22T21:22:10Z","Ernie"));
	}
	
	public static String getHash(String password) {
		try{
	       MessageDigest digest = MessageDigest.getInstance("SHA");
	       digest.reset();
	       byte[] input = digest.digest(password.getBytes());
	       String mdp=hashToHexString(input);
	       return mdp;
	       }catch(NoSuchAlgorithmException e){
	    	  return null;  	 
	       }
	 }
	
	public static String hashToHexString(byte[] hash) {  
	    StringBuilder sb = new StringBuilder(); 
	    for (int i = 0; i < hash.length; i++) {  
	        int v = hash[i] & 0xFF; 
	        if(v < 16) {
	            sb.append("0"); 
	        }
	        sb.append(Integer.toString(v, 16)); 
	    }  
	    return sb.toString(); 
	}
	
	public static String calculatePasswordDigest(String nonce,String created,String password){
		String encoded=null;
		try {
			String pass=nonce+created+password;
			MessageDigest md=MessageDigest.getInstance("SHA-1");
			md.update(pass.getBytes());
			byte[]encodedPassword=md.digest();
			encoded=Base64.encode(encodedPassword);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return encoded;
	}
}
