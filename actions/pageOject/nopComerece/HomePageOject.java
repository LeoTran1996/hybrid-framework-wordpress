package pageOject.nopComerece;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.HomePageUI;
import commons.BasePage;

public class HomePageOject extends BasePage {
	
	WebDriver driver;
	
	public HomePageOject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterLink() {
		waitforElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		waitforElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);	
	}

	public boolean isMyAccountLinkDisplayed() {
		waitforElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK);
	}
}
