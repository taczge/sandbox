package anyobj;

public class Main {

	public static void main(String[] args) {
		final Label a = new Label("a");
		final Label b = new Label("b");
		
		Pairs pairs = new Pairs();
		pairs.add(new Pair(a, a));
		pairs.add(new Pair(a, b));
		pairs.add(new Pair(b, a));
		pairs.add(new Pair(b, b));
		
		System.out.println(pairs.select(Label.ANY, Label.ANY));
		System.out.println(pairs.select(a       , Label.ANY));
		System.out.println(pairs.select(Label.ANY, a       ));
	}
}
