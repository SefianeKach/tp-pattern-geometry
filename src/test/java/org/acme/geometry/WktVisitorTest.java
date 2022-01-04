package org.acme.geometry;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {

	public static final double EPSILON = 1.0e-15;

	public static Point createPointO() {
		return new Point(new Coordinate(0.0, 0.0));
	}

	public static Point createPointA() {
		return new Point(new Coordinate(1.0, 1.0));
	}

	@Test
	public void wktvisitPointMethod() throws UnsupportedEncodingException{

		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point(new Coordinate(3.0,4.0));
		geometry.accept(visitor);
		Assert.assertEquals( "POINT(3.0 4.0)", visitor.getResult() );
	}

	@Test
	public void wktvisitLineStringMethod() throws UnsupportedEncodingException{

		WktVisitor visitor = new WktVisitor();
		List<Point> points = new ArrayList<Point>();
		points.add(createPointO());
		points.add(createPointA());
		Geometry geometry = new LineString(points);
		geometry.accept(visitor);
		Assert.assertEquals( "LINESTRING(0.0 0.0,1.0 1.0)", visitor.getResult() );
	}
}