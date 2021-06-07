package JavaOOP;

public class Dog extends Animal {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.readBook();
		
		dog.run();
		dog.eat();
		dog.play();
		
		dog.eat("cut", 5);

	}

	public void readBook() {
		System.out.println("Doc Sach");
	}
}
