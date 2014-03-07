package iterator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
	
	private static <T> long measureTime(List<T> list) {
		long start = System.currentTimeMillis();
		for ( final T e : list ) {
		}
		long end = System.currentTimeMillis();
		
		return end - start;
	}
	

	private static void run(final int size) {
		
		System.out.print("a/l(ms):");
		List<Integer> array = new ArrayList<>(size);
		for ( int i = 0; i < size; i++ ) {
			array.add(i);
		}
		System.out.print( measureTime(array) );
		array = null;

		List<Integer> linked = new LinkedList<>();
		for ( int i = 0; i < size; i++ ) {
			linked.add(i);
		}
		System.out.println( "/" + measureTime(linked) + ", size=" + size);
		linked = null;
	}
		
	public static void main(String[] args) {
		final int MAX_SIZE = 0x00ffffff;

		for ( int size = 1; size < MAX_SIZE; size = size * 2 ) {
			run(size);
		}
	}
}
