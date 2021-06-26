package javaBasic;

public class Topic_07_Casting_Type {

	public static void main(String[] args) {
		byte i = 50;
		short j = i;
		int k = j;
		long l = k;
		float m = l;
		double n = m;
		
		double a = 999999999;
		float b = (float) a;
		long c = (long) b;
		
		
				
		
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		System.out.println(l);
		System.out.println(m);
		System.out.println(n);
		
		System.out.println(b);
		System.out.println(c);
		
		String studentNumber = "1996";
		
		int studentInt = Integer.parseInt(studentNumber);
		double studentDouble = Double.parseDouble(studentNumber);
		
		System.out.println(studentInt);
		System.out.println(studentDouble);
		
		
	}

}
