package queen;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import lombok.val;

public class Solver {
	
	public List<Chessboad> execute(int size) {
		return execute( new Chessboad(size), 0 );
	}
	
	private List<Chessboad> execute(Chessboad boad, int x) {
		if ( x >= boad.getWidth() ) {
			return Collections.singletonList( boad );
		}
		
		val answer = new LinkedList<Chessboad>(); 
		for ( int iy = 0; iy < boad.getHeight(); iy++ ) {
			if ( boad.threatensOtherQueen(x, iy) ) {
				continue;
			}
			
			val newBoad = boad.copy();
			newBoad.putQueen(x, iy);

			answer.addAll( execute(newBoad, x + 1) );
		}
		
		return answer;
	}
	
}
