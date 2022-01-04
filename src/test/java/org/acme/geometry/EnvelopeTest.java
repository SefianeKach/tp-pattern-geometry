package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){

		Envelope e = new Envelope();
		Assert.assertTrue(e.isEmpty());
	}

	@Test
	public void testConstructor(){

		Envelope e = new Envelope(new Coordinate(1.0, 1.0), new Coordinate(2.0, 2.0));
		Assert.assertFalse(e.isEmpty());
	}

	@Test
	public void getXminMethod(){

		Envelope e = new Envelope(new Coordinate(1.0, 0.0), new Coordinate(2.0, 3.0));
		Assert.assertEquals(1.0, e.getXmin(), EPSILON);
	}

	@Test
	public void getYminMethod(){

		Envelope e = new Envelope(new Coordinate(1.0, 0.0), new Coordinate(2.0, 3.0));
		Assert.assertEquals(0.0, e.getYmin(), EPSILON);
	}

	@Test
	public void getXmaxMethod(){

		Envelope e = new Envelope(new Coordinate(1.0, 0.0), new Coordinate(2.0, 3.0));
		Assert.assertEquals(2.0, e.getXmax(), EPSILON);
	}

	@Test
	public void getYmaxMethod(){

		Envelope e = new Envelope(new Coordinate(1.0, 0.0), new Coordinate(2.0, 3.0));
		Assert.assertEquals(3.0, e.getYmax(), EPSILON);
	}
}