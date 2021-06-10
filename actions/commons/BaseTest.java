package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");

	protected WebDriver getBrowserDriver(String browserName) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		
		if (browser == Browser.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser == Browser.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser == Browser.EDGE_CHROMIUM) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Input valid browser name");
		}

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		return driver;

	}

	protected void setBrowserDriverProperty() {
		String browserFolderPath = projectPath + getDirectorySlash("browserDriver");
		if (isWindows()) {
			System.setProperty("webdriver.gecko.driver", browserFolderPath + "geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", browserFolderPath + "chromedriver.exe");
			System.setProperty("webdriver.edge.driver", browserFolderPath + "msedgedriver.exe");
		} else if (isMac()) {
			System.setProperty("webdriver.firefox.driver", browserFolderPath + "geckodriver_mac");
			System.setProperty("webdriver.chrome.driver", browserFolderPath + "chromedriver_mac");
			System.setProperty("webdriver.edge.driver", browserFolderPath + "msedgedriver_mac");

		} else {
			System.setProperty("webdriver.firefox.driver", browserFolderPath + "geckodriver_linux");
			System.setProperty("webdriver.chrome.driver", browserFolderPath + "chromedriver_linux");
			System.setProperty("webdriver.edge.driver", browserFolderPath + "msedgedriver_linux");
		}
	}

	private String getDirectorySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else if (isWindows()) {
			folderName = "\\" + folderName + "\\";
		} else {
			folderName = null;
		}
		return folderName;
	}

	private boolean isWindows() {
		return (osName.toLowerCase().indexOf("win") >= 0);
	}

	private boolean isMac() {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}

	private boolean isUnix() {
		return (osName.toLowerCase().indexOf("nix") >= 0 || osName.toLowerCase().indexOf("nux") >= 0);
	}

	private boolean isSolaris() {
		return (osName.toLowerCase().indexOf("sunos") >= 0);
	}

	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

}
