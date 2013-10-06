

/* 
 * Implementation of LinkedList
 * Operations at the beginning and end of the list are constant time
 */


public class LinkedListOnVector {
	public class Node {
		Object value;
		int next;
		
		public Node(Object o, int i) {
			this.value = o;
			this.next = i;
		}
	}
	
	public class NodeAndPlace {
		Node node;
		int place;
		
		public NodeAndPlace(Node n, int place) {
			this.node = n;
			this.place = place;
		}
	}
	
	private Vector v = new Vector();
	private int first = -1;
	private int last = -1;
	private int size = 0;
	
	public LinkedListOnVector() {
	}
		
	//Add at end
	public void add(Object o) {
		int nodeLoc = v.findEmpty();
		if(nodeLoc == -1) {
			nodeLoc = v.size();
		}
		v.set(nodeLoc, new Node(o, -1));
		if ( last != -1 ) {
			Node lastNode = (Node)v.get(last);
			lastNode.next = nodeLoc;
		}
		last = nodeLoc;

		if ( first == -1) {
			first = nodeLoc;
		}
		size++;
	}
	
	private Node getNode(int index) {
		return ((NodeAndPlace)getNodeAndPlace(index)).node;
	}
	
	private NodeAndPlace getNodeAndPlace(int index) {
		int arrayIndex = first;
		Node node = (Node)v.get(arrayIndex);
		for(int i = 0; i < index ; i++){
			arrayIndex = node.next;
			node = (Node)v.get(arrayIndex);			
		}
		return new NodeAndPlace(node, arrayIndex);

	}

	public Object get(int index) {
		if( index >= size || first == -1 ) {
			return null;
		}
		return getNode(index).value;
	}
	
	// first == last, change first, last to -1, remove the node
	// first - change first pointer to next (will be -1 if first == last), remove the node (decrement size)
	// nth - change n-1th pointer to value of nth pointer, remove the node
	// last - change last pointer to n-1th node, change n-1th pointer to -1, remove the node
	public void remove(int index) {
		if(first == -1 || last == -1 || index > size) {
			return;
		}
		if( first == last) {
			if(first != index ) {
				return; // actually an error
			} else {
				first = -1;
				last = -1;
			}
		} else if( first == index) {
			first = ((Node)v.get(index)).next;
		} else {
			NodeAndPlace nodeAndPlace = (NodeAndPlace)getNodeAndPlace(index - 1);
			Node n = nodeAndPlace.node;
			Node nextNode = (Node)v.get(n.next);
			n.next = nextNode.next;
			if( index == last) {
				last = nodeAndPlace.place;
			}
		}
		size -= 1;
		v.set(index,  null);
		
	}
	
	// unit test routines.
	public int getFirst() {
		return first;
	}
	
	public int getLast() {
		return last;
	}
	
	public int getSize() {
		return size;
	}
	
	public Vector getVector() {
		return v;
	}

}
