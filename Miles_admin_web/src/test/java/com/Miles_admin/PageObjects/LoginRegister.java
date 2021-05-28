package com.Miles_admin.PageObjects;

public class LoginRegister {

	
	public static final String register = "//a[contains(text(),'Register')]";
	public static final String firstname = "//input[@id='user_firstname']";
	public static final String lastname = "//input[@id='user_surname']";
	public static final String phone = "//input[@id='user_phone']";
	public static final String dobyear = "//select[@id='user_dateofbirth_1i']";
	public static final String dobdate = "//select[@id='user_dateofbirth_3i']";
	public static final String address= "//input[@id='user_address_attributes_street']";
	public static final String city = "//input[@id='user_address_attributes_city']";
	public static final String country= "//input[@id='user_address_attributes_county']";
	public static final String postcode = "//input[@id='user_address_attributes_postcode']";
	public static final String email= "//input[@id='user_user_detail_attributes_email']";
	public static final String password = "//input[@id='user_user_detail_attributes_password']";
	public static final String confirmpassword= "//input[@id='user_user_detail_attributes_email']";
	public static final String submit ="//input[@name='submit']";
	public static final String pagetitle = "//*[contains(text() ,'Sign up as a new user')]";
}


