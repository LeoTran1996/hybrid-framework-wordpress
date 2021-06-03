package javaHN;

public class QuanHoanKiem {
	
	//Thuoc Tinh(Bien/Variable)
	private String ward = "Trang Tien";
	
	//Phuong Thuc(Ham/Method) -> Setter(Gan du lieu)
	public void setWard(String newWard) {
		ward = newWard;
		
	}
	
	//Phuong Thuc(Ham/Method) -> Getter(Lay ra du lieu)
	public String getWard() {
		return ward;
	}
	
	String bridge = "Long Bien";
	
	void setBridge(String bridge) {
		this.bridge = bridge;
	}
	
	String getBridge() {
		return this.bridge;
	}
	
	
	protected String street = "Tran Van Du";
	
	protected void setStreet(String newstreet) {
		street = newstreet;
	}
	
	protected String getStreet() {
		return street;
		
	}
	
	public String food = "Pho bo";
	
	public void setFood(String newsFood) {
		street = newsFood;
	}
	
	public String getFood() {
		return street;
		
	}
}


