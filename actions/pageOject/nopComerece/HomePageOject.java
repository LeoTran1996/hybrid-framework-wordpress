package pageOject.nopComerece;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageUIs.nopCommerce.HomePageUI;
import commons.BasePage;

public class HomePageOject extends BasePage {
	
	WebDriver driver;
	PageGeneratorManager pageGenerator;
	
	public HomePageOject(WebDriver driver) {
		this.driver = driver;
		//pageGenerator = PageGeneratorManager.getPageGenerator();
	}

	public RegisterPageOject clickToRegisterLink() {
		waitforElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return  PageGeneratorManager.getRegisterPageOject(driver);
	}

	public LoginPageOject clickToLoginLink() {
		waitforElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);	
		return PageGeneratorManager.getLoginPageOject(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitforElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
	}

	public CustomerInforPageOject clickToMyAccountLink() {
		waitforElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);	
		return PageGeneratorManager.getCustomerPageOject(driver);
		
	}

	
}
