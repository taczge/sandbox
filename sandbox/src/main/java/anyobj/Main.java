package anyobj;

public class Main {

	public static void main(String[] args) {
		final Name a = new Name("a");
		final Name b = new Name("b");
		
		Pairs pairs = new Pairs();
		pairs.add(new Pair(a, a));
		pairs.add(new Pair(a, b));
		pairs.add(new Pair(b, a));
		pairs.add(new Pair(b, b));
		
		System.out.println(pairs.list(Name.ANY, Name.ANY));
		System.out.println(pairs.list(a       , Name.ANY));
		System.out.println(pairs.list(Name.ANY, a       ));
	}
}
