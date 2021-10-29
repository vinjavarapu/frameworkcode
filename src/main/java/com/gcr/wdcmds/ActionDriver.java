package com.gcr.wdcmds;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.gcr.config.StartBrowser;

public class ActionDriver {

	public WebDriver driver;
	
	public ActionDriver()
	{
		driver = StartBrowser.driver;
	}
	/**
	 * Used to navigate to any application
	 * @param url -- URL of application
	 */
	public void navigateToApplication(String url)
	{
		try {
			driver.get(url);
			StartBrowser.childTest.pass("Successfully Navigated to :"+url);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Uanble to  Navigate to :"+url);
		}
	}
	/**
	 * Used to perform click on links, buttons, radio buttons and checkboxes
	 * @param locator -- Get it from Object Repository
	 * @param eleName -- Name of the element
	 * @throws Exception
	 */
	public void click(By locator, String eleName) throws Exception
	{
		try {
			driver.findElement(locator).click();
			StartBrowser.childTest.pass("Performed click action on :"+eleName);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to performe click action on :"+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	/**
	 * Used to perform type action in textbox or text area
	 * @param locator-- Get it from OR
	 * @param testData -- Get it from external files
	 * @param eleName -- Name of the element
	 * @throws Exception
	 */
	public void type(By locator, String testData, String eleName) throws Exception
	{
		try {
			driver.findElement(locator).sendKeys(testData);
			StartBrowser.childTest.pass("Successfully performed type action on :"+eleName + " With test data :"+testData);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to performe type action action on :"+eleName + " With test data :"+testData,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	/**
	 * used to perform mousehover action on element
	 * @param locator -- OR
	 * @param eleName -- Name of the element
	 * @throws Exception
	 */
	public void mouseHover(By locator, String eleName) throws Exception
	{
		try {
			WebElement we=driver.findElement(locator);
			Actions a = new Actions(driver);
			a.moveToElement(we).build().perform();
			StartBrowser.childTest.pass("Successfully performed mousehover action on :"+eleName );
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to performe mousehover action action on :"+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	/**
	 * select value from DD using Visible text
	 * @param locator -- OR
	 * @param visibleText -- Dropdown value
	 * @param eleName -- Name of the dropdown
	 * @throws Exception
	 */
	public void selectByVisibleText(By locator, String visibleText, String eleName) throws Exception
	{
		try {
			WebElement we=driver.findElement(locator);
			Select s = new Select(we);
			s.selectByVisibleText(visibleText);
			StartBrowser.childTest.pass("Successfully Selected value  :"+visibleText + " From Dropdown :"+eleName);
		} catch (Exception e) {
			StartBrowser.childTest.pass("Unable to selecte value  :"+visibleText + " From Dropdown :"+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	public String screenShot()
	{
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
}
