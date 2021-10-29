package com.gcr.scripts;

import org.testng.annotations.Test;

import com.gcr.config.StartBrowser;
import com.gcr.reuse.CommonFunctions;

public class Login_Logout extends StartBrowser{
  @Test
  public void Login_LogoutTestCase() throws Exception {
	  CommonFunctions cfs = new CommonFunctions();
	  cfs.login();
	  Thread.sleep(2000);
	  cfs.logout();
	  Thread.sleep(2000);
  }
}
