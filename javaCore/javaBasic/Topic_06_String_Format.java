package javaBasic;

public class Topic_06_String_Format {
		
	public static void main(String[] args) {
		String fullname = "Xin moi anh/ chi: %s";
		
		String[] khachmoi = {"Tran Van A", "Tran Van B", "Tran Van C", "Tran Van D"};
		
		
		for (String khach : khachmoi) {
			System.out.println(String.format(fullname, khach));
			
		}
		 
//		System.out.println(String.format(fullname, "Tran Van Anh"));
//		System.out.println(String.format(fullname, "Tran Van Em"));
//		System.out.println(String.format(fullname, "Tran Van Chi"));
	}
}
	
