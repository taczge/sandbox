package alg.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.val;

public class Bubble implements Sort {
	
	@Override
	public <T> List<T> sort(List<T> list, Comparator<? super T> c) {
		val l = new ArrayList<T>( list );

		for ( int i = 0; i < list.size() - 1; i++ ) {
			for ( int j = i + 1; j < list.size(); j++ ) {
				val ith = l.get(i);
				val jth = l.get(j);

				if ( c.compare(ith, jth) > 0 ) {
					Collections.swap(l, i, j);
				}
			}
		}
		
		return l;
	}

	
}
