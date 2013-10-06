import static org.junit.Assert.*;

import org.junit.Test;


public class LinkedListTest {

	private LinkedList l;
	@Test
	public void testAdd() {
		l = new LinkedList();
		assertEquals("first should be null", l.getFirst(), null);
		assertEquals("last should be null", l.getLast(), null);
		assertEquals("size should be 0", l.getSize(), 0);
		l.add("0");
		assertEquals("0th element should return 0", l.get(0), "0");
		assertEquals("first should be 0", l.getFirst(), "0");
		assertEquals("last should be 0", l.getLast(), "0");
		assertEquals("size should be 1", l.getSize(), 1);
		l.add("1");
		assertEquals("0th element should return 0", l.get(0), "0");
		assertEquals("1th element should return 1", l.get(1), "1");
		assertEquals("first should be 0", l.getFirst(), "0");
		assertEquals("last should be 1", l.getLast(), "1");
		assertEquals("size should be 2", l.getSize(), 2);
		l.remove(1);
		assertEquals("0th element should return 0", l.get(0), "0");
		assertEquals("size should be 1", l.getSize(), 1);
		l.add("1");
		l.remove(0);
		assertEquals("0th element should return 1", l.get(0), "1");
		assertEquals("size should be 1", l.getSize(), 1);
		l.add("2");
		l.addAfter("3", l.getNode(0));
		assertEquals("0th element should return 1", l.get(0), "1");
		assertEquals("1st element should return 3", l.get(1), "3");
		assertEquals("2nd element should return 2", l.get(2), "2");
		assertEquals("size should be 3", l.getSize(), 3);
		
	}
}
