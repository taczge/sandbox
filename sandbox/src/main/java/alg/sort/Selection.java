package alg.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.val;

public class Selection extends AbstractSort {

	@Override
	public <T> List<T> sort(List<T> list, Comparator<? super T> c) {
		val l = createWorkingList( list );
		
		for ( int i = 0; i < l.size() - 1; i++ ) {
			int minIndex = i;
			
			for ( int j = i + 1; j < l.size(); j++ ) {
				val min = l.get(minIndex);
				val jth = l.get(j);

				if ( isWrongOrder(min, jth, c) ) {
					minIndex = j;
				}
			}
			
			Collections.swap(l, i, minIndex);
		}
		
		return l;
	}

}
