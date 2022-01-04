package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LogGeometryVisitorTest {

	public static final double EPSILON = 1.0e-15;

	public static Point createPointO() {
		return new Point(new Coordinate(0.0, 0.0));
	}

	public static Point createPointA() {
		return new Point(new Coordinate(1.0, 1.0));
	}

	@Test
	public void visitPointMethod() throws UnsupportedEncodingException{

		Geometry geometry = new Point(new Coordinate(2.0,3.0));

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		geometry.accept(visitor);
		// result contiendra ce qui est écrit dans la console
		String result = os.toString("UTF8");

		Assert.assertEquals("Point with : x=2.0 & y=3.0", result.trim());
	}

	@Test
	public void visitLineStringMethod() throws UnsupportedEncodingException{

		List<Point> points = new ArrayList<Point>();
		points.add(createPointO());
		points.add(createPointA());
		Geometry geometry = new LineString(points);

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		geometry.accept(visitor);
		// result contiendra ce qui est écrit dans la console
		String result = os.toString("UTF8");

		Assert.assertEquals("Polygon defined by 2 Point", result.trim());
	}
}