package com.gcr.reuse;

import org.openqa.selenium.WebDriver;

import com.gcr.config.StartBrowser;
import com.gcr.or.HomePage;
import com.gcr.or.LoginPage;
import com.gcr.wdcmds.ActionDriver;

public class CommonFunctions {
	
	public ActionDriver aDriver;
	public WebDriver driver;
	
	public CommonFunctions()
	{
		aDriver = new ActionDriver();
		driver = StartBrowser.driver;
	}

	public void login() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to Application");
		aDriver.navigateToApplication("https://www.at-home.co.in/");
		aDriver.click(HomePage.lnkMyAccount, "My Account link");
		aDriver.type(LoginPage.txtEmail, "nagatraining@gmail.com", "Email textbox");
		Thread.sleep(2000);
		aDriver.type(LoginPage.txtPassword, "Sample@1234", "Password Textbox");
		Thread.sleep(2000);
		aDriver.click(LoginPage.btnSubmit, "Submit button");
	}
	
	public void login(String email, String password) throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to Applicationusing excel");
		aDriver.navigateToApplication("https://www.at-home.co.in/");
		aDriver.click(HomePage.lnkMyAccount, "My Account link");
		aDriver.type(LoginPage.txtEmail, email, "Email textbox");
		Thread.sleep(2000);
		aDriver.type(LoginPage.txtPassword, password, "Password Textbox");
		Thread.sleep(2000);
		aDriver.click(LoginPage.btnSubmit, "Submit button");
	}
	
	public void logout() throws Exception
	{
		StartBrowser.childTest = StartBrowser.parentTest.createNode("Logout from Application");
		aDriver.mouseHover(HomePage.lnkAccount, "Account link");
		aDriver.click(HomePage.lnkLogout, "Logout link");
	}
}
