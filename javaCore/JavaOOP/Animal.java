package JavaOOP;

public class Animal {
	protected void run() {
		System.out.println("Chay");
	}
	
	protected void eat() {
		System.out.println("An");
	}
	
	protected void play() {
		System.out.println("Choi");
	}
	
	protected void eat( String foodName, int foodSize) {
		System.out.println("An" + foodName);
		
		System.out.println("An " + foodName + " So luong " + foodSize);
	}	
	
	
}

