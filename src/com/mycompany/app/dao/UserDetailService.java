package com.mycompany.app.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserDetailService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String login)throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		//login = login.toLowerCase();
		List<GrantedAuthority> arrayAuths = new LinkedList<GrantedAuthority>();
		GrantedAuthority r=new GrantedAuthorityImpl("ROLE_USER");
		arrayAuths.add(r);
		User user=new User(login,"Ernie",true,true, true, true,arrayAuths);
		return user;
	}
	
	public String getHash(String password) {
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
}
