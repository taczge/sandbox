package queen;

import lombok.val;


public class Main {
	
	private Main() {}

	public static void main(String[] args) {
		for ( int i = 1; i <= 15; i++ ) {
			val answer = new Solver().execute( i );
			val msg = String.format("%2d-Queen: %d", i, answer.size());

			System.out.println( msg );
		}
	}
}
