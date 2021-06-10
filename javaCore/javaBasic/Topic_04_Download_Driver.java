package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Topic_04_Download_Driver {
	public static void main(String[] args) {
		WebDriver driver;
		
		WebDriverManager.chromedriver().driverVersion("88.0.4324.27").setup();
		driver = new ChromeDriver();
		
		driver.get("https://facebook.com");
		
		driver.quit();
	}

}
