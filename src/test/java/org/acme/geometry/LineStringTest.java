package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;



public class LineStringTest {

    public static final double EPSILON = 1.0e-15;

	public static Point createPointO() {
        return new Point(new Coordinate());
    }
        
    public static Point createPointA() {
        return new Point(new Coordinate(0.8, 1.2));
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
        Assert.assertEquals("Point", l.getPointN(0).getType());
    }
    
    
    @Test
	public void isEmptyMethod(){

		LineString l = new LineString();
		Assert.assertTrue(l.isEmpty());
	}
}







