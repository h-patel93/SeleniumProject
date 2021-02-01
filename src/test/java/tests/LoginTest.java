package tests;

import org.testng.annotations.Test; 

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import base.TestBase;

import pages.LoginPage;

public class LoginTest extends TestBase {

	LoginPage loginPage;
	

	public LoginTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	
	@Test
	public void loginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String homePageTitle = loginPage.verifyTitle();
		Assert.assertEquals(homePageTitle, "Amicus Cloud - Home", "title did not matched , error");

	}

	
	@Test
	public void verifyLogoutSuccess() {
		loginPage.clickLogoutButton();
		String homePageTitle = loginPage.verifyTitle();
		Assert.assertEquals(homePageTitle, "Amicus Cloud", "title did not matched , error");
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}

}
