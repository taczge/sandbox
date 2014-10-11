package alg.sort;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public abstract class AbstractSort implements Sort {

	protected <T> boolean isWrongOrder(T less, T greater, Comparator<T> c) {
		return c.compare(less, greater) > 0;
	}
	
	protected <T> List<T> createWorkingList(List<T> list) {
		return new ArrayList<T>( list );
	}

}
