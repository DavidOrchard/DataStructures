import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class HeapArrayGeneric<T extends Comparable<T>> {
	List<T> array;
	
	public HeapArrayGeneric(List<T> a) {
		array = new ArrayList<T>(a.size());
		Collections.copy(array, a);
		heapify();
	}
	
	private void siftUp(int start, int end ) {
		int child = end;
		while (child > start) {
			int parent = (int) Math.floor((child-1)/2);
			if(array.get(parent).compareTo(array.get(child)) > 0 ) {
				return;
			}
			T t = array.get(parent);
			array.set(parent, array.get(child));
			array.set(child, t);
		}
	}
	private void heapify() {
		for(int i = 1; i < array.size(); i++) {
			siftUp(0,i);
		}
		
	}
	
	public static void main(String[] args) {
		List<Integer> l = Arrays.asList( 6, 5, 3, 1, 8, 7, 2, 4 );
		HeapArrayGeneric<Integer> h = new HeapArrayGeneric<Integer>(l);
		System.out.println(h.toString());
	}

}
