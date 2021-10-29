package com.gcr.scripts;

import org.testng.annotations.Test;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.gcr.config.StartBrowser;
import com.gcr.reuse.CommonFunctions;

public class Login_Logout_Excel extends StartBrowser{
  @Test
  public void Login_Logout_ExcelTestCase() throws Exception {
	  CommonFunctions cfs = new CommonFunctions();
	  Fillo f = new Fillo();
	  Connection con = f.getConnection("TestData/Data.xlsx");
	  String query = "select * from Login";
	  Recordset rs = con.executeQuery(query);
	  while (rs.next()) {
		  cfs.login(rs.getField("Email"), rs.getField("Password"));
		  Thread.sleep(2000);
		  cfs.logout();
		  Thread.sleep(2000);
	}
	 // 
  }
}
