
public class StackOnLinkedList {

	private LinkedList list = new LinkedList();
	public StackOnLinkedList() {
		
	}
	
	public void push(Object o) {
		list.add(o);
	}
	
	public Object pop() {
		Object o = list.getLast();
		list.removeLast();
		return o;
	}
}
