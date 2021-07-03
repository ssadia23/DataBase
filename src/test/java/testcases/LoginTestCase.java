package testcases;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import page.DataBasePage;
import page.LoginBasePage.LoginPage;

public class LoginTestCase {

	public class LoginTestPage extends TestBase {
		LoginPage loginPageObj;
		SoftAssert softAssert = new SoftAssert();
		
		@BeforeMethod 
		public void setUp() {
			initializeDriver();
			loginPageObj = PageFactory.initElements(driver, LoginPage.class);
		}
		
		@Test
		public void LoginTest() throws InterruptedException, ClassNotFoundException, SQLException, IOException {
			
			loginPageObj.enterUserName(DataBasePage.getData("username"));
			loginPageObj.enterPassword(DataBasePage.getData("password"));
			loginPageObj.clickOnSignInButton();
			Thread.sleep(3000);
			
			takeScreenshotAtEndOfTest(driver);
		}
		
//		public void loginPageTitleTest() throws ClassNotFoundException, SQLException {
//			loginPageObj.enterUserName(DatabasePage.getData("username"));
//			loginPageObj.enterPassword(DatabasePage.getData("password"));
//			
//		}
		
		@AfterMethod
		public void tearDown() {
			driver.close();
			driver.quit();
		}

	}
	
}
