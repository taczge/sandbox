package alg.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.val;

public class Bubble extends AbstractSort {
	
	@Override
	public <T> List<T> sort(List<T> list, Comparator<? super T> c) {
		val l = createWorkingList( list );

		for ( int i = 0; i < list.size() - 1; i++ ) {
			for ( int j = i + 1; j < list.size(); j++ ) {
				val ith = l.get(i);
				val jth = l.get(j);

				if ( isWrongOrder(ith, jth, c) ) {
					Collections.swap(l, i, j);
				}
			}
		}
		
		return l;
	}

	
}
