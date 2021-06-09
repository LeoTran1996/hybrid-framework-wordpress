package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	public WebDriver getBrowserDriver(String browserName) {
		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge_chromium")){
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}else{
			throw new RuntimeException("Input valid browser name");
		}	
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
	
}
