package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageUIs.JQuery.HomePageUIs;
import PageUIs.nopCommerce.BasePageUI;
import pageOject.nopComerece.AboutUsPageOject;
import pageOject.nopComerece.HomePageOject;
import pageOject.nopComerece.NewsPageOject;
import pageOject.nopComerece.PageGeneratorManager;
import pageOject.nopComerece.ShoppingCartPageOject;
import pageOject.nopComerece.SiteMapPageOject;

public class BasePage {
	
	public static BasePage getBasePage() {
		return new BasePage();
	}
	
	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}
	
	public void setAllCookies(WebDriver driver, Set<Cookie> allCookies) {
		for (Cookie cookie : allCookies) {
			driver.manage().addCookie(cookie);
		}
	}
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void getAlertText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	public void getAlertText2222(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().activeElement().sendKeys(value);
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public String getDynamicLocator(String locator, String...values) {
		return String.format(locator, (Object[]) values);
	}
	
	public void clickToElement(WebDriver driver, String locator, String... values) {
		getWebElement(driver, getDynamicLocator(locator, values)).click();
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}
	
	public void clickToElement(WebElement element) {
		element.click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value, String... values) {
		WebElement element = getWebElement(driver, getDynamicLocator(locator, values));
		element.clear();
		element.sendKeys(value);
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = getWebElement(driver, locator);
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String valueItem) {
		Select select = new Select(getWebElement(driver, locator));
		select.selectByVisibleText(valueItem);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String valueItem, String... params) {
		Select select = new Select(getWebElement(driver, getDynamicLocator(locator, params)));
		select.selectByVisibleText(valueItem);
	}

	public String getTextOfSelectedItemInDropDown(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		clickToElement(driver, parentLocator);
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, 30);

		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));
		List<WebElement> allItems = getListWebElement(driver, childItemLocator);
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				clickToElement(item);
				sleepInSecond(1);
				break;
			}
		}
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getElementTex(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText().trim();
	}
	
	public String getElementTex(WebDriver driver, String locator, String... values) {
		return getWebElement(driver, getDynamicLocator(locator, values)).getText().trim();
	}

	public String getElementAttributeByName(WebDriver driver, String locator, String attributeName) {
		return getWebElement(driver, locator).getAttribute(attributeName);
	}
	
	public String getElementAttributeValue(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getAttribute("value");
	}

	public int getElementNumber(WebDriver driver, String locator) {
		return getListWebElement(driver, locator).size();
	}
	
	public int getElementNumber(WebDriver driver, String locator, String... values) {
		return getListWebElement(driver, getDynamicLocator(locator, values)).size();
	}

	public void checkToCheckboxOrRadioButton(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (!element.isSelected()) {
			clickToElement(element);
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (element.isSelected()) {
			clickToElement(element);
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}
	
	public boolean isControlDisplayed(WebDriver driver, String locator) {
		boolean status = false;
		try {
			status = getWebElement(driver, locator).isDisplayed();
			return status ;
		} catch (Exception e) {
			return status;
		}
		
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		return getWebElement(driver, getDynamicLocator(locator, values)).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}

	public void switchToIframe(WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver, locator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locator)).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
	}

	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locator), key).perform();
	}
	
	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key, String...values ) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicLocator(locator, values)), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}
	
	public void clickToElementByJS(WebDriver driver, String locator, String... values) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, getDynamicLocator(locator, values)));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitforElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOf(getWebElement(driver, locator)));
	}
	
	public void waitforElementVisible(WebDriver driver, String locator, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOf(getWebElement(driver, getDynamicLocator(locator, values))));
	}

	public void waitforListElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}

	public void waitforElementInvisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOf(getWebElement(driver, locator)));
	}

	public void waitforElementClickable(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public void waitforElementClickable(WebDriver driver, String locator, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, values))));
	}
	
	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String filePath = System.getProperty("user.dir") + getDirectorySlash("uploadFile");
		String fullFileName = "";	
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, HomePageUIs.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		overrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, locator);
		overrideImplicitTimeout(driver, longTimeout);
		
		if(elements.size() == 0) {
			return false;
		}else if(elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return false;
		}else {
			return true;
			
		}
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locator, String... values) {
		overrideImplicitTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, getDynamicLocator(locator, values));
		overrideImplicitTimeout(driver, longTimeout);
		
		if(elements.size() == 0) {
			return false;
		}else if(elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return false;
		}else {
			return true;
		
		}
	}
	
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
	
	public void overrideImplicitTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	public static String getDirectorySlash(String folderName) {
		String separator = System.getProperty("file.separator");
		return separator + folderName + separator;
	}
	
	
/* Common Page Oject*/
	
	public SiteMapPageOject openSiteMapPage(WebDriver driver) {
		waitforElementClickable(driver, BasePageUI.SITEMAP_LINK);
		clickToElement( driver, BasePageUI.SITEMAP_LINK);
		return PageGeneratorManager.getSiteMapPageOject(driver);
	}
	
	public HomePageOject openHomePage(WebDriver driver) {
		waitforElementClickable(driver, BasePageUI.HOME_PAGE_IMG);
		clickToElement( driver, BasePageUI.HOME_PAGE_IMG);
		return PageGeneratorManager.getHomePageOject(driver);
	}

	public ShoppingCartPageOject openShoppingCartPage(WebDriver driver) {
		waitforElementClickable( driver, BasePageUI.SHOPPING_CART_LINK);
		clickToElement(driver, BasePageUI.SHOPPING_CART_LINK);
		return PageGeneratorManager.getShoppingCartPageOject(driver);
	}
	
	public AboutUsPageOject openAboutUsPage(WebDriver driver) {
		waitforElementClickable( driver, BasePageUI.ABOUT_US);
		clickToElement( driver, BasePageUI.ABOUT_US);
		return PageGeneratorManager.getAboutUsPageOject( driver);
	}
	
	public NewsPageOject openNewsPage(WebDriver driver) {
		waitforElementClickable( driver, BasePageUI.NEWS_LINK);
		clickToElement( driver, BasePageUI.NEWS_LINK);
		return PageGeneratorManager.getNewsPageOject( driver);
	}
	
	/* Dynamic Locator - Cach 1: Page it */
	public BasePage openFooterPageByName(WebDriver driver, String pageName) {
		waitforElementClickable(driver, BasePageUI.FOOTER_PAGE_LINK_BY_NAME, pageName);
		clickToElement(driver, BasePageUI.FOOTER_PAGE_LINK_BY_NAME, pageName);	
		
		if(pageName.equals("Shopping cart")) {	
			return PageGeneratorManager.getShoppingCartPageOject(driver);
		}else if(pageName.equals("About us")) {
			return PageGeneratorManager.getAboutUsPageOject(driver);
			
		}else if(pageName.equals("Sitemap")){
			return PageGeneratorManager.getSiteMapPageOject(driver);
			
		}else if(pageName.equals("News")){
			return PageGeneratorManager.getNewsPageOject(driver);
			
		}else {
			throw new RuntimeException("Please input the correct page name!");
		}
	}
	
	/* Dynamic Locator - Cach 2: Page nhieu */

	public void openFooterPageName(WebDriver driver, String pageName) {
		waitforElementClickable(driver, BasePageUI.FOOTER_PAGE_LINK_BY_NAME, pageName);
		clickToElement(driver, BasePageUI.FOOTER_PAGE_LINK_BY_NAME, pageName);	
	}

	//Patter Object
	public void enterToTextBoxByID(WebDriver driver, String textboxID, String value) {
		waitforElementVisible(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
	}
	
	public void openHeaderPageName(WebDriver driver, String pageName) {
		waitforElementClickable(driver, BasePageUI.DYNAMIC_PAGE_HEADER, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_HEADER, pageName);	
	}
	
	public void selectDropdownByName(WebDriver driver, String dropdownName, String itemText) {
		selectItemInDropdown(driver, BasePageUI.DYNAMIC_DROPDOWN_BY_NAME, itemText, dropdownName);
	}
	
	public void clickToButtonByText(WebDriver driver, String buttonName) {
		waitforElementClickable(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonName);
		clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonName);	
	}
}




