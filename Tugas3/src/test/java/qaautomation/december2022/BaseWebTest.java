package qaautomation.december2022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseWebTest {
	
	//pertemuan 4
	//ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();;
		driver = new ChromeDriver();
		driver.get("https://yopmail.com");
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
