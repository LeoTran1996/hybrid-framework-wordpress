package javaBasic;

public class Topic03_Parameter {
	
	public static String fullName = "Tran Van Anh";
	public static boolean marriedStatus = true;

	public static void main(String[] args) {
		
		setFullName("Tran Van Anh B");
		System.out.println(fullName);
		
		getMarriedStatus();

	}
	
	public static void setFullName(String newFullName) {
		fullName = newFullName;
	}
	
	public static String getFullName() {
		return fullName;
	}
	
	public static boolean getMarriedStatus() {
		marriedStatus = false;
		if(marriedStatus) {
			System.out.println("Da co gia dinh");
		} else {
			System.out.println("Chua co gia dinh");
		}		
		return marriedStatus;
	}
}
