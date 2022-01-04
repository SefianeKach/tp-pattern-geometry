package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){

		Point p = new Point();
		Assert.assertEquals(Double.NaN, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(Double.NaN, p.getCoordinate().getY(), EPSILON);
	}

	@Test
	public void testConstructor(){

		Point p = new Point(new Coordinate(1.0, 1.0));
		Assert.assertEquals(1.0, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(1.0, p.getCoordinate().getY(), EPSILON);
	}

	@Test
	public void getTypeMethod() {

		Point p = new Point();
		Assert.assertEquals("Point", p.getType());
	}

	@Test
	public void isEmptyMethod(){

		Point p = new Point();
		Assert.assertTrue(p.isEmpty());
	}

	@Test
	public void translateMethod(){

		Point p = new Point(new Coordinate(0.0, 0.0));
		p.translate(1.0, 1.0);
		Assert.assertEquals(1.0, p.getCoordinate().getX(), EPSILON);
	}

	@Test
	public void cloneMethod(){

		Point p1 = new Point(new Coordinate(0.0, 0.0));
		Geometry p2 = p1.clone();
		p2.translate(1.0, 1.0);
		Assert.assertEquals(0.0, p1.getCoordinate().getX(), EPSILON);
	}

	@Test
	public void envelopeMethod(){

		Point p = new Point(new Coordinate(0.0, 1.0));
		Assert.assertEquals(0.0, p.getEnvelope().getXmin(), EPSILON);
	}
	
}
