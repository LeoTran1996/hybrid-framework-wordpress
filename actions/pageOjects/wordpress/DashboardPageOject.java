package pageOjects.wordpress;

import org.openqa.selenium.WebDriver;

import PageUIs.wordpress.DashboardPageUI;
import commons.BasePage;

public class DashboardPageOject extends BasePage{
	
WebDriver driver;
	
	public DashboardPageOject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardHeaderTextDisplayed() {
		waitforElementVisible(driver, DashboardPageUI.DASHBOARD_HEADER_TEXT);
		isElementDisplayed(driver, DashboardPageUI.DASHBOARD_HEADER_TEXT);
		return isElementDisplayed(driver, DashboardPageUI.DASHBOARD_HEADER_TEXT);
	}

	
}
