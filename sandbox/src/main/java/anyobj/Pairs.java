package anyobj;

import java.util.HashSet;
import java.util.Set;

public class Pairs {
	
	private Set<Pair> pairs;
	
	public Pairs(Set<Pair> pairs) {
		this.pairs = pairs;
	}
	
	public Pairs(int capacity) {
		this(new HashSet<Pair>(capacity));
	}
	
	public Pairs() {
		this(new HashSet<Pair>());
	}
	
	public void add(Pair p) {
		pairs.add(p);
	}
	
	public Pairs list(Pair query) {
		Pairs ps = new Pairs();
		
		for (final Pair p: pairs) {
			if (query.equals(p)) {
				ps.add(p);
			}
		}
		
		return ps;
	}
	
	public Pairs list(Name x, Name y) {
		return list(new Pair(x, y));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pairs == null) ? 0 : pairs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pairs other = (Pairs) obj;
		if (pairs == null) {
			if (other.pairs != null)
				return false;
		} else if (!pairs.equals(other.pairs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pairs [pairs=" + pairs + "]";
	}

}
