package misc;

import java.util.LinkedList;
import java.util.List;

import lombok.val;

public class RecursiveCall {
	
	private static int head(List<Integer> list) {
		return list.get(0);
	}
	
	public static List<Integer> tail(List<Integer> list) {
		return list.subList(1, list.size());
	}
	
	public static int sum(List<Integer> list, int acc) {
		if ( list.isEmpty() ) {
			return acc;
		}
		
		return sum(tail(list), acc + head(list));
	}
	
	public static int sum(List<Integer> list) {
		return sum(list, 0);
	}
	
	public static void main(String[] args) {
		val list = new LinkedList<Integer>();
		for ( int i= 1; i <= 10; i++ ) {
			list.add(i);
		}

		System.out.println( list );
		System.out.println( sum(list, 0) );
	}

}
