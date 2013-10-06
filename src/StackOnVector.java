
public class StackOnVector {
	private Vector v = new Vector();
	public StackOnVector() {
		
	}
	
	public void push(Object o) {
		v.set(v.getNumElements(), o);
	}
	
	public Object pop() {
		int lastElemPos = v.getNumElements();
		if(lastElemPos == 0) {
			return null;
		}
		lastElemPos--;
		Object o = v.get(lastElemPos);
		v.set(lastElemPos, null);
		return o;
	}
}
