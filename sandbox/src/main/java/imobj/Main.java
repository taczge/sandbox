package imobj;


import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static final int LOOP_MAX = 100000;
	private static final int TRIAL_MAX = 10000;
	
	private static long testToString(Person p) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < LOOP_MAX; i++) {
			p.toString();
		}
		long end = System.currentTimeMillis();
		
		return end - start;
	}

	private static long testHashCode(Person p) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < LOOP_MAX; i++) {
			p.hashCode();
		}
		long end = System.currentTimeMillis();
		
		return end - start;
	}
	
	private static int sum(List<Long> l) {
		int sum = 0;
		
		for (final Long n : l) {
			sum += n;
		}
		
		return sum;
	}
   
	private static void a() {
		List<Long> fast = new ArrayList<>();
		List<Long> slow = new ArrayList<>();
	   
		for (int i = 0; i < TRIAL_MAX; i++) {
			fast.add(testToString(new FastPerson("Tom")));
			slow.add(testToString(new SlowPerson("Tom")));
		}
	   
		System.out.println("toString * " + TRIAL_MAX);
		System.out.println("   fast: " + sum(fast) + "ms");
		System.out.println("   slow: " + sum(slow) + "ms");
	}
	
	private static void b() {
		List<Long> fast = new ArrayList<>();
		List<Long> slow = new ArrayList<>();
	   
		for (int i = 0; i < TRIAL_MAX; i++) {
			fast.add(testHashCode(new FastPerson("Tom")));
			slow.add(testHashCode(new SlowPerson("Tom")));
		}
	   
		System.out.println("hashCode*" + TRIAL_MAX);
		System.out.println("   fast: " + sum(fast) + "ms");
		System.out.println("   slow: " + sum(slow) + "ms");
	}
	   
	public static void main(final String[] args) {
		a();
		b();
    }

}
