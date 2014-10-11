package alg.sort;

import java.util.Comparator;
import java.util.List;

public interface Sort {

	public <T> List<T> sort(List<T> list, Comparator<? super T> c);
	
}
