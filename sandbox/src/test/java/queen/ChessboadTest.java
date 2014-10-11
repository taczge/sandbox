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
				assertThat( sut.existsQueen(i, j), is(false) );
			}
		}
	}

	@Test
	public void existsQueenAt_77() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		
		sut.putQueen(7, 7);
		
		assertThat( sut.existsQueen(7, 7), is(true) );
	}

	@Test
	public void existsQueenAt_35() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		val x = 3;
		val y = 5;
		sut.putQueen(x, y);

		assertThat( sut.existsQueen(x, y), is(true) );
	}
	
	@Test
	public void threatensOtherQueen_upper() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		sut.putQueen(3, 3);

		assertThat( sut.threatensOtherQueen(3, 0), is(true) );
	}

	@Test
	public void threatensOtherQueen_lower() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		sut.putQueen(3, 3);

		assertThat( sut.threatensOtherQueen(3, 7), is(true) );
	}

	@Test
	public void threatensOtherQueen_left() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		sut.putQueen(3, 3);

		assertThat( sut.threatensOtherQueen(0, 3), is(true) );
	}

	@Test
	public void threatensOtherQueen_right() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		sut.putQueen(3, 3);

		assertThat( sut.threatensOtherQueen(7, 3), is(true) );
	}

	@Test
	public void threatensOtherQueen_upperLeft() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		sut.putQueen(3, 5);

		assertThat( sut.threatensOtherQueen(2, 4), is(true) );
		assertThat( sut.threatensOtherQueen(1, 3), is(true) );
		assertThat( sut.threatensOtherQueen(0, 2), is(true) );
	}

	@Test
	public void threatensOtherQueen_lowerLeft() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		sut.putQueen(3, 5);

		assertThat( sut.threatensOtherQueen(2, 6), is(true) );
		assertThat( sut.threatensOtherQueen(1, 7), is(true) );
	}

	@Test
	public void threatensOtherQueen_upperRight() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		sut.putQueen(3, 5);

		assertThat( sut.threatensOtherQueen(4, 4), is(true) );
		assertThat( sut.threatensOtherQueen(5, 3), is(true) );
		assertThat( sut.threatensOtherQueen(6, 2), is(true) );
		assertThat( sut.threatensOtherQueen(7, 1), is(true) );
	}

	@Test
	public void threatensOtherQueen_lowerRight() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		sut.putQueen(3, 5);

		assertThat( sut.threatensOtherQueen(4, 6), is(true) );
		assertThat( sut.threatensOtherQueen(5, 7), is(true) );
	}

	@Test
	public void copy_() throws Exception {
		val size = 2;
		val sut = new Chessboad( size );
		sut.putQueen(0, 0);
		
		val expected = new Chessboad( size );
		expected.putQueen(0, 0);
		
		assertThat( sut.copy(), is(expected) );
	}

	@Test
	public void copy_createOtherInstance() throws Exception {
		val sut = new Chessboad( BOAD_SIZE );
		
		assertThat( sut != sut.copy(), is(true) );
	}

	
}
