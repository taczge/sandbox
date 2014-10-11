package queen;

import lombok.val;

public class Chessboad {
	
	private final int width;
	private final int height;
	private final boolean[][] boad;

	public Chessboad(int size) {
		this.width  = size;
		this.height = size;
		this.boad   = new boolean[width][height];
	}
	
	public void putQueenAt(int x, int y) {
		boad[x][y] = true;
	}
	
	public void removeQueenAt(int x, int y) {
		boad[x][y] = false;
	}
	
	public boolean existsQueenAt(int x, int y) {
		return boad[x][y];
	}
	
	@Override
	public String toString() {
		val builder = new StringBuilder();
		
		writeXAxes(builder);
		for ( int i = 0; i < width; i++ ) {
			writeYCordinate(builder, i);
			for ( int j = 0; j < height; j++ ) {
				writeCell(builder, i, j);
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
		if ( existsQueenAt(x, y) ) {
			builder.append( "Q" );
		} else {
			builder.append( "-" );
		}
	}
	
	private void writeNewline(StringBuilder builder) {
		builder.append( System.lineSeparator() );
	}
}
