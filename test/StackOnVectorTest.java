import static org.junit.Assert.*;

import org.junit.Test;


public class StackOnVectorTest {

	@Test
	public void test() {
		StackOnVector stack = new StackOnVector();
		String s = (String)stack.pop();
		assertEquals("Top item is null", s, null);
		stack.push("0");
		s = (String)stack.pop();
		assertEquals("Top item is 0", s, "0");
		stack.push("0");
		stack.push("1");
		s = (String)stack.pop();
		assertEquals("Top item is 1", s, "1");
		s = (String)stack.pop();
		assertEquals("Top item is 0", s, "0");
		s = (String)stack.pop();
		assertEquals("Top item is null", s, null);
	}

}
