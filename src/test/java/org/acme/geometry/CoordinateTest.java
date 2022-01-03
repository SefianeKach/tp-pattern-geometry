package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructorBehavior(){
		Coordinate a = new Coordinate();
		Assert.assertEquals(Double.NaN, a.getX(), EPSILON);
		Assert.assertEquals(Double.NaN, a.getY(), EPSILON);	
	}

	@Test
	public void testDefaultConstructor(){
		Coordinate c = new Coordinate(0.8,1.2);
		Assert.assertEquals(0.8, c.getX(), EPSILON);
		Assert.assertEquals(1.2, c.getY(), EPSILON);	
	}

	@Test
	public void isEmptyMethod(){
		Coordinate c = new Coordinate();
		Assert.assertTrue(c.isEmpty());
	}


}
