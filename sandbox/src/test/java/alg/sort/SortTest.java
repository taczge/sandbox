package alg.sort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.val;

import org.junit.Test;

public class SortTest {
	
	private Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}
	};

	private final int MAX_ELEMENT = 10;
	private List<Integer> createOrderdList() {
		val list = new ArrayList<Integer>( MAX_ELEMENT );
		
		for ( int i = 0; i < MAX_ELEMENT; i++ ) {
			list.add(i, i + 1);
		}
		
		return list;
	}
	
	private List<Integer> shuffle(List<Integer> list) {
		val shuffled = new ArrayList<Integer>( list );
		
		Collections.shuffle(shuffled);
		
		return shuffled;
	}
	
	public void test(Sort s) throws Exception {
		val orderd   = createOrderdList();
		val shuffled = shuffle(orderd);

		assertThat( s.sort(shuffled, comp), is(orderd) );
	}

	@Test
	public void bubble() throws Exception {
		test( new Bubble() );
	}
	
}
