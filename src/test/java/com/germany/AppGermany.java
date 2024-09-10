package com.germany;

import org.baseclass.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pom.POM;

public class AppGermany extends BaseClass {
	POM g;

	@BeforeMethod
	public void launchBrowser() {
		launchChromeBrowser();
		WindowsMaximazer();
		launchUrl("https://app.germanyiscalling.com/common/login/");
		g = new POM(driver);
	}

	@Test(priority = 1)
	public void loginPage() throws Exception {

//		Login Button validation
		boolean LoginBtn = g.getLoginBtn().isDisplayed();
		boolean LoginBtnEnable = g.getPassTxtBox().isEnabled();

//		Username text box validation
		boolean UsrTxtVis = g.getUsrTxtBox().isDisplayed();
		boolean UsrTxtEnb = g.getUsrTxtBox().isEnabled();

//		password text box validation
		boolean passTxtVis = g.getPassTxtBox().isDisplayed();
		boolean passTxtEnb = g.getPassTxtBox().isEnabled();

//		Discord sign in link
		boolean DiscordVis = g.getDiscordBtn().isDisplayed();
		boolean DiscordEnb = g.getDiscordBtn().isEnabled();

		SoftAssert s = new SoftAssert();

		s.assertEquals(LoginBtn, true);
		s.assertEquals(LoginBtnEnable, true);
		s.assertEquals(passTxtVis, true);
		s.assertEquals(passTxtEnb, true);
		s.assertEquals(UsrTxtEnb, true);
		s.assertEquals(UsrTxtVis, true);
		s.assertEquals(DiscordVis, true);
		s.assertEquals(DiscordEnb, true);

		g.getLoginBtn().click();
//		validate landing page
		String pagetitle = pageTitle();
		boolean pageTitleMtch = pagetitle.contains("Upload your CV | Germany Is Calling");

		s.assertFalse(pageTitleMtch, "Page title does not match for Unsuccessful login");

		s.assertAll();

		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void validCredentials() throws Exception {

//		enter valid user name
		g.getUsrTxtBox().sendKeys("deepaksundaravelu@gmail.com");

//		enter valid password
		g.getPassTxtBox().sendKeys("deepak.S1");

//		click the login button
		g.getLoginBtn().click();

//		wait for 3 seconds
		Thread.sleep(3000);
		String pagetitle = pageTitle();
		boolean pageTitleMtch = pagetitle.contains("Upload your CV | Germany Is Calling");

		SoftAssert s = new SoftAssert();
//		validate landing page
		s.assertTrue(pageTitleMtch, "Page title matches for Successful login");
		s.assertAll();

	}

	@Test(priority = 3)
	public void invalidCredentials() throws Exception {

//		enter valid user name
		g.getUsrTxtBox().sendKeys("deepaksundaravelu@gmail.com");

//		enter valid password
		g.getPassTxtBox().sendKeys("deepakS1");

//		click the login button
		g.getLoginBtn().click();

//		wait for 3 seconds
		Thread.sleep(3000);

		String pagetitle = pageTitle();
		boolean pageTitleMtch = pagetitle.contains("Upload your CV | Germany Is Calling");

		SoftAssert s = new SoftAssert();
//		validate landing page
		s.assertFalse(pageTitleMtch, "Page title does not match for Unsuccessful login");
		s.assertAll();

	}

	@AfterMethod
	public void closetheBrowser() {
		closeBrowser();
	}
}
