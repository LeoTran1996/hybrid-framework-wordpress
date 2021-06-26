package javaBasic;

public class Topic_05_Dynamic_Locator {
	// 1 - Click vao duong link co ten Abous Us
	public static final String ABOUT_US_LINK = "//a[text()='About us']"; 
	public static final String NEW_PRODUCT_LINK = "//a[text()='New Product']"; 
	
	// 2 - Khong can phai dinh nghia nhieu bien cho cac Locator cung loai
	public static final String DYNAMIC_FOOTER_LINK = "//a[text()='%s']";
	
	// 3 - Dung 1 loai locator dai dien cho header/footer
	public static final String DYNAMIC_LINK = "//div[@class='%s']//a[text()='%s']";
	
	// 4 - Dung 1 loai locator dai dien cho tat ca cac nuoc
	public static final String DYNAMIC_COUNTRY = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	
	public static void main(String[] args) {
		//Click to Element
		
//		clickToElement(ABOUT_US_LINK);
//		clickToElement(NEW_PRODUCT_LINK);
		
		clickToElement(DYNAMIC_FOOTER_LINK, "About us");
		clickToElement(DYNAMIC_FOOTER_LINK, "Shopping cart");
		clickToElement(DYNAMIC_FOOTER_LINK, "New Product");
		
		clickToElement(DYNAMIC_LINK, "footer","About us");
		clickToElement(DYNAMIC_LINK, "footer","Sitemap");
		
		clickToElement(DYNAMIC_LINK, "header","Register");
		clickToElement(DYNAMIC_LINK, "header","Log in");
		
		clickToElement(DYNAMIC_COUNTRY, "384187", "Afghanistan", "407124", "791312");
	}
	
	//Abstract page
	public static void clickToElement(String locator) {
		System.out.println(locator);
	}
	
	
//	public static void clickToElement(String locator, String pageName) {
//		System.out.println(String.format(locator, pageName));
//	}
//	
//	//Co 2 tham so dong
//	public static void clickToElement(String locator, String panel, String pageName) {
//		System.out.println(String.format(locator, panel, pageName));
//	}
//	
//	//Co 4 tham so dong
//	public static void clickToElement(String locator, String females, String country,String males, String total) {
//		System.out.println(String.format(locator, females, country, males, total));
//	}
//	
	//Co the dung duoc voi n tham so
	//Tham so nay phai dung o cuoi cung
	//Phai cung kieu du lieu
	public static void clickToElement(String locator, String...values ) {
		System.out.println(String.format(locator, (Object[]) values));
	}
	
	
}
