package pageOject.nopComerece;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	
	public  static HomePageOject getHomePageOject(WebDriver driver) {
		return new HomePageOject(driver);
	}
	
	public static LoginPageOject getLoginPageOject(WebDriver driver) {
		return new LoginPageOject(driver);
	}
	
	public static RegisterPageOject getRegisterPageOject(WebDriver driver) {
		return new RegisterPageOject(driver);
	}
	
	public static CustomerInforPageOject getCustomerPageOject(WebDriver driver) {
		return new CustomerInforPageOject(driver);
	}
}
