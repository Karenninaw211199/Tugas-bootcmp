package qaautomation.december2022;

import org.testng.annotations.Test;

import qaautomation.december2022.pages.LoginPageFactory;
import qaautomation.december2022.pages.ProfilePageFactory;

import org.testng.AssertJUnit;


public class WebTestUsingThreadLocalParalelUsingPageFactory extends BasedWebTestUsingThreadLocalParalel{
//	LoginPage loginPage = new LoginPage(driver, explicitWait);
//	ProfilePage profilePage = new ProfilePage(driver, explicitWait);
	
	String username = "tomsmith";
	String password = "SuperSecretPassword!";
	String wrongUsername = "ngasal";
	String wrongPassword = "password";
	
	@Test
	public void testSuccessLogin() {
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver, explicitWait);
		ProfilePageFactory profilePageFactory = new ProfilePageFactory(driver, explicitWait);
		//explicitwait
//		WebDriverWait wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(0));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		
		//hardwait
		Utility.hardWait(0);
		//login
		loginPageFactory.inputUsername(username);
		loginPageFactory.inputPassword(password);
		loginPageFactory.loginBtn();
		
		//profile
		String actualText = profilePageFactory.getProfileText();
		String expectedText = "You logged into a secure area";
		System.out.println("actual"+actualText);
		System.out.println("expected"+expectedText);
		AssertJUnit.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testWrongUsername() {
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver, explicitWait);
		ProfilePageFactory profilePageFactory = new ProfilePageFactory(driver, explicitWait);
		//login
		loginPageFactory.inputUsername(wrongUsername);
		loginPageFactory.inputPassword(password);
		loginPageFactory.loginBtn();
		//profile
		String actualText = profilePageFactory.getProfileText();
		String expectedText = "Your username is invalid";
		System.out.println("actual"+actualText);
		System.out.println("expected"+expectedText);
		AssertJUnit.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testWrongPassword() {
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver, explicitWait);
		ProfilePageFactory profilePageFactory = new ProfilePageFactory(driver, explicitWait);
		//login
		loginPageFactory.inputUsername(username);
		loginPageFactory.inputPassword(wrongPassword);
		loginPageFactory.loginBtn();
		//profile
		String actualText = profilePageFactory.getProfileText();
		String expectedText = "Your password is invalid";
		System.out.println("actual"+actualText);
		System.out.println("expected"+expectedText);
		AssertJUnit.assertTrue(actualText.contains(expectedText));
	}
}
