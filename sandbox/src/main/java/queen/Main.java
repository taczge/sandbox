package queen;

import lombok.val;


public class Main {
	
	private Main() {}

	public static void main(String[] args) {
		val answer = new Solver().execute( 8 );
		
		answer.stream().forEach( System.out::println );
		System.out.println( answer.size() + " answers is found.");
	}
}
