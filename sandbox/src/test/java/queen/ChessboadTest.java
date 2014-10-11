package queen;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
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
	
	@Test
	public void threatensOtherQueen_upper() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		sut.putQueenAt(3, 3);

		assertThat( sut.threatensOtherQueen(3, 0), is(true) );
	}

	@Test
	public void threatensOtherQueen_lower() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		sut.putQueenAt(3, 3);

		assertThat( sut.threatensOtherQueen(3, 7), is(true) );
	}

	@Test
	public void threatensOtherQueen_left() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		sut.putQueenAt(3, 3);

		assertThat( sut.threatensOtherQueen(0, 3), is(true) );
	}

	@Test
	public void threatensOtherQueen_right() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		sut.putQueenAt(3, 3);

		assertThat( sut.threatensOtherQueen(7, 3), is(true) );
	}

	@Test
	public void threatensOtherQueen_upperLeft() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		sut.putQueenAt(3, 5);

		assertThat( sut.threatensOtherQueen(2, 4), is(true) );
		assertThat( sut.threatensOtherQueen(1, 3), is(true) );
		assertThat( sut.threatensOtherQueen(0, 2), is(true) );
	}

	@Test
	public void threatensOtherQueen_lowerLeft() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		sut.putQueenAt(3, 5);

		assertThat( sut.threatensOtherQueen(2, 6), is(true) );
		assertThat( sut.threatensOtherQueen(1, 7), is(true) );
	}

	@Test
	public void threatensOtherQueen_upperRight() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		sut.putQueenAt(3, 5);

		assertThat( sut.threatensOtherQueen(4, 4), is(true) );
		assertThat( sut.threatensOtherQueen(5, 3), is(true) );
		assertThat( sut.threatensOtherQueen(6, 2), is(true) );
		assertThat( sut.threatensOtherQueen(7, 1), is(true) );
	}

	@Test
	public void threatensOtherQueen_lowerRight() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		sut.putQueenAt(3, 5);

		assertThat( sut.threatensOtherQueen(4, 6), is(true) );
		assertThat( sut.threatensOtherQueen(5, 7), is(true) );
	}

	
}
