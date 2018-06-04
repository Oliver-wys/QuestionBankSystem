package qbs.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class User extends org.springframework.security.core.userdetails.User {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User(String username, String password, String... roles){
		
		//输入的用户名，密码，以及权限
		super(username, password, buildAuthorities(roles));
	}
	
	private static List<GrantedAuthority> buildAuthorities(String[] roles){
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(String role : roles){
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		}
		return authorities;
	}
}
