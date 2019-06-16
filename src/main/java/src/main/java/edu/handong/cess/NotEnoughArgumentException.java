package src.main.java.edu.handong.cess;

public class NotEnoughArgumentException extends Exception {
	public NotEnoughArgumentException() {
		System.out.println("The file path does not exist. Please check your CLI argument!");
		System.exit(0);
	}
	public NotEnoughArgumentException(String message) {
		System.out.println(message);
		System.exit(0);
	}
}
