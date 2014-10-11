package queen;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import lombok.val;

import org.junit.Test;

public class ChessboadTest {
	
	private final int BOAD_SIZE = 8;

	@Test
	public void new_() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		
		for ( int i = 0; i < BOAD_SIZE; i++ ) {
			for ( int j = 0; j < BOAD_SIZE; j++ ) {
				assertThat( sut.existsQueenAt(i, j), is(false) );
			}
		}
	}

	@Test
	public void existsQueenAt_77() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		
		sut.putQueenAt(7, 7);
		
		assertThat( sut.existsQueenAt(7, 7), is(true) );
	}

	@Test
	public void existsQueenAt_35() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		val x = 3;
		val y = 5;
		sut.putQueenAt(x, y);

		assertThat( sut.existsQueenAt(x, y), is(true) );
	}

}
