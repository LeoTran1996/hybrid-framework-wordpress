package javaHN;

public class QuanHaiBaTrung {

	public static void main(String[] args) {
		QuanHoanKiem hoankiem = new QuanHoanKiem();
		
		hoankiem.setBridge("Nhat Tan");
		System.out.println(hoankiem.getBridge()); 
		
		hoankiem.setBridge("Chuong Duong");
		System.out.println(hoankiem.getBridge()); 

		hoankiem.bridge = "Cau Xoa No";
		System.out.println(hoankiem.bridge);
		
		hoankiem.setStreet("Nam Ky Khoi Nghia");
		System.out.println(hoankiem.getStreet());
		
	}

}
