import java.util.Arrays;


/* dynamical sized array
 * Not synchronized.
 * 
 */
public class Vector {
	
	private static int INITIAL_SIZE = 100;
	//private int INCREASE_ALGORITHM = 0; // 0 = double, 1 = add INITIAL_SIZE
	private Object[] array;
	private int numElements = 0;
	
	public Vector(int size) {		
		array = new Object[size];
	}	
	public Vector() {
		this(INITIAL_SIZE);
	}
	public Object get(int index) {
		return array[index];
	}
	
	public int size() {
		return array.length;
	}
	
	public int getNumElements() {
		return numElements;
	}

	public int findEmpty() {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == null) {
				return i;
			}
		}
		return -1;
	}

	
	private void resizeArray( int minNewSize) {
		int newSize = array.length;
		while(newSize < minNewSize) {
			newSize *= 2;
		}
		// Could be Arrays.copyOf(array,newSize);
		Object[] newArray = new Object[newSize];
		for(int i = 0; i < array.length; i ++) {
			newArray[i] = array[i];
		}
		array = newArray;
		
	}
	
	// setting unempty to empty, size - 1
	// setting empty to non-empty, size + 1
	// setting empty to empty or unempty to unempty, size no change
	public void set(int index, Object o) {
		if(index + 1 > array.length) {
			resizeArray(index + 1);
		}
		if( array[index] != null && o == null) {
			numElements -= 1;
		} if( array[index] == null && o != null) {
			numElements += 1;
		}
		array[index] = o;		
	}

}
