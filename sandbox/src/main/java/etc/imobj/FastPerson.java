package etc.imobj;

public class FastPerson implements Person {

	private final String name;
	
	private final int hashCode;
	private final String string;

	public FastPerson(String name) {
		super();
		this.name = name;
		
		this.hashCode = hashCodeOnlyOnce();
		this.string   = toStringOnlyOnce();
	}

	private int hashCodeOnlyOnce() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	private String toStringOnlyOnce() {
		return "FastPerson [name=" + name + "]";
	}
	
	@Override
	public int hashCode() {
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FastPerson other = (FastPerson) obj;
		if (hashCode != other.hashCode)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (string == null) {
			if (other.string != null)
				return false;
		} else if (!string.equals(other.string))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return string;
	}

}
