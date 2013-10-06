import static org.junit.Assert.*;

import org.junit.Test;


public class VectorTest {

	Vector v;
	
	@Test
	public void testSetAndGet() {
		v = new Vector(2);
		assertEquals("FindEmpty should return 0", v.findEmpty(), 0);
		assertEquals("Num Elements should be 0", 0, v.getNumElements());
		v.set(0, "0");
		assertEquals("Num Elements should be 1", 1, v.getNumElements());
		v.set(1, "1");
		assertEquals("Num Elements should be 2", 2, v.getNumElements());
		assertEquals("0th element should be \"0\"", v.get(0), "0" );
		assertEquals("1th element should be \"1\"", v.get(1), "1");
		assertEquals("Size should be 2", v.size(),2);
		assertEquals("FindEmpty should return -1", v.findEmpty(), -1);
		// resize of 1 double
		v.set(2, "2");
		assertEquals("2th element should be \"2\"", v.get(2), "2");
		assertEquals("Size should be 4", v.size(),4);
		assertEquals("FindEmpty should return 3", v.findEmpty(), 3);
		assertEquals("Num Elements should be 3", 3, v.getNumElements());
		
		// set to null
		v.set(2, null);
		assertEquals("2th element should be null", v.get(2), null);
		assertEquals("Size should be 4", v.size(),4);
		assertEquals("FindEmpty should return 2", v.findEmpty(), 2);
		assertEquals("Num Elements should be 2", 2, v.getNumElements());
		
		// resize of 2 doubles
		v.set(16, "16");
		assertEquals("16th element should be \"16\"", v.get(16), "16");
		assertEquals("Size should be 32", v.size(), 32);
		assertEquals("Num Elements should be 3", 3, v.getNumElements());
				
	}

}
