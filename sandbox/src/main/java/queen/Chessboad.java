package queen;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.val;

@EqualsAndHashCode
public class Chessboad {
	
	@Getter private final int size;
	private final boolean[][] boad;

	public Chessboad(int size) {
		this.size = size;
		this.boad   = new boolean[size][size];
	}
		
	public void putQueen(int x, int y) {
		boad[x][y] = true;
	}
	
	public boolean existsQueen(int x, int y) {
		return boad[x][y];
	}
	
	@Override
	public String toString() {
		val builder = new StringBuilder();
		
		writeXAxes(builder);
		for ( int y = 0; y < size; y++ ) {
			writeYCordinate(builder, y);
			for ( int x = 0; x < size; x++ ) {
				writeCell(builder, x, y);
			}
			writeNewline(builder);
		}
		
		return builder.toString();
	}
	
	private void writeXAxes(StringBuilder builder) {
		builder.append(" ");
		for ( int i = 0; i < size; i++ ) {
			builder.append(i);
		}
		builder.append( System.lineSeparator() );
	}
	
	private void writeYCordinate(StringBuilder builder, int y) {
		builder.append(y);
	}
	
	private void writeCell(StringBuilder builder, int x, int y) {
		if ( existsQueen(x, y) ) {
			builder.append( "Q" );
			return;
		} 
		
		if ( threatensOtherQueen(x, y) ) {
			builder.append("*");
			return;
		}
		
		builder.append( "-" );
	}
	
	private void writeNewline(StringBuilder builder) {
		builder.append( System.lineSeparator() );
	}
	
	public boolean threatensOtherQueen(int x, int y) {
		if ( existsQueenVertically(x) ) {
			return true;
		}
		
		if ( existsQueenHorizontally(y) ) {
			return true;
		}
		
		if ( existsQueenUpperLeft(x, y) ) {
			return true;
		}

		if ( existsQueenUpperRight(x, y) ) {
			return true;
		}

		if ( existsQueenLowerLeft(x, y) ) {
			return true;
		}

		if ( existsQueenLowerRight(x, y) ) {
			return true;
		}

		return false;
	}
	
	private boolean existsQueenVertically(int x) {
		for ( int y = 0; y < size; y++ ) {
			if ( existsQueen(x, y) ) {
				return true;
			}
		}

		return false;
	}
	
	private boolean existsQueenHorizontally(int y) {
		for ( int x = 0; x < size; x++ ) {
			if ( existsQueen(x, y) ) {
				return true;
			}
		}

		return false;
	}

	private boolean isOnBoad(int x, int y) {
		return (0 <= x && x < size) && (0 <= y && y < size);   
	}

	private boolean existsQueenUpperLeft(int x, int y) {
		for ( int i = 0; isOnBoad(x - i, y - i); i++ ) {
			if ( existsQueen(x - i, y - i) ) {
				return true;
			}
		}
		
		return false;
	}

	private boolean existsQueenUpperRight(int x, int y) {
		for ( int i = 0; isOnBoad(x + i, y - i); i++ ) {
			if ( existsQueen(x + i, y - i) ) {
				return true;
			}
		}
		
		return false;
	}

	private boolean existsQueenLowerLeft(int x, int y) {
		for ( int i = 0; isOnBoad(x - i, y + i); i++ ) {
			if ( existsQueen(x - i, y + i) ) {
				return true;
			}
		}
		
		return false;
	}

	private boolean existsQueenLowerRight(int x, int y) {
		for ( int i = 0; isOnBoad(x + i, y + i); i++ ) {
			if ( existsQueen(x + i, y + i) ) {
				return true;
			}
		}
		
		return false;
	}

	public Chessboad copy() {
		val other = new Chessboad( this.size );
		
		for ( int ix = 0; ix < size; ix++ ) {
			for ( int iy = 0; iy < size; iy++ ) {
				if ( this.existsQueen(ix, iy) ) {
					other.putQueen(ix, iy);
				}
			}
		}
		
		return other;
	}
	
}
