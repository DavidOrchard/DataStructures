import static org.junit.Assert.*;

import org.junit.Test;


public class HashMapTest {

	@Test
	public void test() {
		HashMap hm = new HashMap();
		assertEquals("Should get null for any key", null, hm.get("foo"));
		hm.add("foo", "bar");
		assertEquals("Should get \"bar\" for key \"foo\"", "bar", (String)hm.get("foo"));
		hm.add("foo", "baz");
		assertEquals("Should get \"baz\" for key \"foo\"", "baz", (String)hm.get("foo"));
		hm.add("foo1", "bar1");
		hm.add("foo2", "bar2");
		hm.add("foo3", "bar3");
		assertEquals("Should get \"baz\" for key \"foo\"", "baz", (String)hm.get("foo"));
		assertEquals("Should get \"bar1\" for key \"foo1\"", "bar1", (String)hm.get("foo1"));
		assertEquals("Should get \"bar2\" for key \"foo2\"", "bar2", (String)hm.get("foo2"));
		assertEquals("Should get \"bar3\" for key \"foo3\"", "bar3", (String)hm.get("foo3"));
		hm.remove("foo3");
		assertEquals("Should get null for key \"foo3\"", null, (String)hm.get("foo3"));
		hm.add("foo3", "bar3");
		assertEquals("Should get \"baz\" for key \"foo\"", "baz", (String)hm.get("foo"));
		assertEquals("Should get \"bar1\" for key \"foo1\"", "bar1", (String)hm.get("foo1"));
		assertEquals("Should get \"bar2\" for key \"foo2\"", "bar2", (String)hm.get("foo2"));
		assertEquals("Should get \"bar3\" for key \"foo3\"", "bar3", (String)hm.get("foo3"));		
	}

}
