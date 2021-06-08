package pageOject.nopComerece;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.LoginPageUI;
import commons.BasePage;

public class LoginPageOject extends BasePage {
	
	WebDriver driver;
	
	public LoginPageOject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextbox(String emailAdress) {
		waitforElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAdress);
	}

	public void enterToPassword(String password) {
		waitforElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void clickToLoginButton() {
		waitforElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);		
	}
}
