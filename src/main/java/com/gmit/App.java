package com.gmit;

import java.util.ResourceBundle;

public class App {
	public int userlogin(String in_user, String in_pwd)
	{
		ResourceBundle rb = ResourceBundle.getBundle("config");
		System.out.println(App.class.getClassLoader().getResource("config.properties"));

		String userName = rb.getString("username");
		String password = rb.getString("password");
		
		if(in_user.equals(userName) && in_pwd.equals(password))
			return 1;
		else
			return 0;
		
	}
}
