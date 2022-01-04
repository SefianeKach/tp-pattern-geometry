package org.acme.geometry;

import java.util.List;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {

	public static final double EPSILON = 1.0e-15;

	public static Point createPointO() {
		return new Point(new Coordinate(0.0, 0.0));
	}

	public static Point createPointA() {
		return new Point(new Coordinate(1.0, 1.0));
	}

	@Test
	public void testDefaultConstructor() {

		LineString l = new LineString();
		Assert.assertEquals(1, l.getNumPoints());
	}

	@Test
	public void testConstructor() {

		List<Point> points = new ArrayList<Point>();
		points.add(createPointA());
		LineString l = new LineString(points);
		Assert.assertEquals(1, l.getNumPoints());
	}

	@Test
	public void getTypeMethod() {

		LineString l = new LineString();
		Assert.assertEquals("LineString", l.getType());
	}

	@Test
	public void getNumPointsMethod() {

		List<Point> points = new ArrayList<Point>();
		points.add(createPointO());
		points.add(createPointA());
		LineString l = new LineString(points);
		Assert.assertEquals(2, l.getNumPoints(), EPSILON);
	}

	@Test
	public void getPointNMethod() {

		List<Point> points = new ArrayList<Point>();
		points.add(createPointO());
		points.add(createPointA());
		LineString l = new LineString(points);
		Assert.assertEquals(0.0, l.getPointN(0).getCoordinate().getX(), EPSILON);
	}

	@Test
	public void isEmptyMethod(){

		LineString l = new LineString();
		Assert.assertTrue(l.isEmpty());
	}

	@Test
	public void translateMethod(){

		List<Point> points = new ArrayList<Point>();
		points.add(createPointO());
		LineString l = new LineString(points);
		l.translate(1.0, 1.0);
		Assert.assertEquals(1.0, l.getPointN(0).getCoordinate().getX(), EPSILON);
	}

	@Test
	public void cloneMethod(){

		List<Point> points = new ArrayList<Point>();
		points.add(createPointO());
		LineString l = new LineString(points);
		Geometry copy = l.clone();
		copy.translate(1.0, 1.0);
		Assert.assertEquals(0.0, l.getPointN(0).getCoordinate().getX(), EPSILON);
	}

	@Test
	public void envelopeMethod(){

		List<Point> points = new ArrayList<Point>();
		points.add(createPointO());
		points.add(createPointA());
		LineString l = new LineString(points);
		Assert.assertEquals(0.0, l.getEnvelope().getXmin(), EPSILON);
	}


	@Test
	public void asTextMethod(){

		List<Point> points = new ArrayList<Point>();
		points.add(createPointO());
		points.add(createPointA());
		LineString l = new LineString(points);
		Assert.assertEquals("LINESTRING(0.0 0.0,1.0 1.0)", l.asText());
	}

}
