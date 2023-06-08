package app;

public class Main {

	public static void main(String[] args) {

		StringFactory factory = new StringFactory();
		
		System.out.println(new Solver().getNeedlePosition(factory.getHayStack().toCharArray(),
								  factory.getNeedle().toCharArray()));
	}
}
