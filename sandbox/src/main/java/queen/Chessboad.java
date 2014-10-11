package queen;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.val;

@EqualsAndHashCode
public class Chessboad {
	
	@Getter private final int width;
	@Getter private final int height;
	private final boolean[][] boad;

	public Chessboad(int size) {
		this.width  = size;
		this.height = size;
		this.boad   = new boolean[width][height];
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
		for ( int y = 0; y < width; y++ ) {
			writeYCordinate(builder, y);
			for ( int x = 0; x < height; x++ ) {
				writeCell(builder, x, y);
			}
			writeNewline(builder);
		}
		
		return builder.toString();
	}
	
	private void writeXAxes(StringBuilder builder) {
		builder.append(" ");
		for ( int i = 0; i < width; i++ ) {
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
		for ( int y = 0; y < height; y++ ) {
			if ( existsQueen(x, y) ) {
				return true;
			}
		}

		return false;
	}
	
	private boolean existsQueenHorizontally(int y) {
		for ( int x = 0; x < height; x++ ) {
			if ( existsQueen(x, y) ) {
				return true;
			}
		}

		return false;
	}

	private boolean isOnBoad(int x, int y) {
		return (0 <= x && x < width) && (0 <= y && y < height);   
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
		val other = new Chessboad( this.height );
		
		for ( int ix = 0; ix < this.width; ix++ ) {
			for ( int iy = 0; iy < this.height; iy++ ) {
				if ( this.existsQueen(ix, iy) ) {
					other.putQueen(ix, iy);
				}
			}
		}
		
		return other;
	}
	
}
