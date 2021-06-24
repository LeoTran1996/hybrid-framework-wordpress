package pageOject.nopComerece;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.RegisterPageUI;
import commons.BasePage;

public class RegisterPageOject extends BasePage {
	
	WebDriver driver;
	PageGeneratorManager pageGenerator;
	
	public RegisterPageOject(WebDriver driver) {
		this.driver = driver;
		//pageGenerator = PageGeneratorManager.getPageGenerator();
	}

	public void enterToFirstNameTextbox(String firstname) {
		waitforElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstname);
	}

	public void enterToLastNameTextbox(String lastname) {
		waitforElementVisible(driver, RegisterPageUI.LASTTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTTNAME_TEXTBOX, lastname);
		
	}
	
	public void enterToEmailTextbox(String emailAdress) {
		waitforElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAdress);
		
	}

	public void enterToPassword(String password) {
		waitforElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void enterToConfirmPassword(String confirmPassword) {
		waitforElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public void clickToRegisterButton() {
		waitforElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public boolean isSuccessMessageDisplayed() {
		waitforElementVisible(driver, RegisterPageUI.REGISTER_SUCCESSMESSAGE);	
		return isElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESSMESSAGE);
	}

	public HomePageOject clickToLogoutLink() {
		waitforElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePageOject(driver);
	}
}
