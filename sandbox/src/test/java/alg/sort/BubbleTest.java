package alg.sort;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.val;

import org.junit.Test;

import com.google.common.collect.Lists;

public class BubbleTest {
	
	private Sort sut = new Bubble();
	private Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}
	};
	
	@Test
	public void sort_0() {
		val list = Collections.<Integer>emptyList();
		val expected = Collections.emptyList();
		
		assertThat( sut.sort(list, comp), is(expected) );
	}
	
	@Test
	public void sort_1() throws Exception {
		val list = Lists.newArrayList(1);
		val expected = Lists.newArrayList(1);
		
		assertThat( sut.sort(list, comp), is(expected) );
	}

	@Test
	public void sort_2() throws Exception {
		val list = Lists.newArrayList(2, 1);
		val expected = Lists.newArrayList(1, 2);
		
		assertThat( sut.sort(list, comp), is(expected) );
	}

	private final int MAX_ELEMENT = 20;
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

	@Test
	public void sort_many() throws Exception {
		val orderd   = createOrderdList();
		val shuffled = shuffle(orderd);

		assertThat( sut.sort(shuffled, comp), is(orderd) );
	}
}
