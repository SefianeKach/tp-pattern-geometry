package org.acme.geometry;

import java.util.List;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class WktWriterTest {

	public static final double EPSILON = 1.0e-15;

	public static Point createPointA() {
		return new Point(new Coordinate(1.0, 1.0));
	}

	@Test
	public void writePointMethod(){

		Geometry p = new Point(new Coordinate(1.0, 1.0));
		WktWriter w = new WktWriter();
		String geomWkt = w.write(p);
		Assert.assertEquals("POINT(1.0 1.0)", geomWkt);
	}

	@Test
	public void writeLineStringMethod(){

		List<Point> points = new ArrayList<Point>();
		points.add(createPointA());
		Geometry l = new LineString(points);
		WktWriter w = new WktWriter();
		String geomWkt = w.write(l);
		Assert.assertEquals("LINESTRING(1.0 1.0)", geomWkt);
	}

	@Test
	public void writeEmptyMethod(){

		Geometry p = new Point(new Coordinate());
		WktWriter w = new WktWriter();
		String geomWkt = w.write(p);
		Assert.assertEquals("POINT EMPTY", geomWkt);
	}

}
