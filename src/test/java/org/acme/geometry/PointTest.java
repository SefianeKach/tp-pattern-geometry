package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    public static final double EPSILON = 1.0e-15;

	@Test
	public void testPointConstructor(){
		Coordinate c = new Coordinate(0.8,1.2);
        Point p = new Point(c);
		p.getType();
        Assert.assertEquals(0.8, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(1.2, p.getCoordinate().getY(), EPSILON);
		
	}
}
