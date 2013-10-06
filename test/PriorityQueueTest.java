import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueTest {

	@Test
	public void test() {
		PriorityQueue pq = new PriorityQueue();
		PriorityQueue.PriorityItem p = (PriorityQueue.PriorityItem)pq.pop();
		assertEquals("Top item is null", p, null);
		pq.push(pq.new PriorityItem(0, "0"));
		String s = (String)(pq.pop().o);
		assertEquals("Top item is 0", s, "0");
		pq.push(pq.new PriorityItem(0, "1"));
		pq.push(pq.new PriorityItem(1, "0"));
		s = (String)pq.pop().o;
		assertEquals("Top item is 1", s, "1");
		s = (String)pq.pop().o;
		assertEquals("Top item is 0", s, "0");
		Object o = pq.pop();
		assertEquals("Top item is null", o, null);			
	}

}
