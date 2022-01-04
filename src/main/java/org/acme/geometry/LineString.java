package org.acme.geometry;

import java.util.List;
import java.util.ArrayList;

public class LineString extends AbstractGeometry {

    private List<Point> points;

    public LineString() {
        this.points = new ArrayList<Point>();
        this.points.add(new Point());
    }

    public LineString(List<Point> points) {
        this.points = points;
    }

    public int getNumPoints() {
        return points.size();
    }

    public Point getPointN(int n) {
        return points.get(n);
    }

    @Override
    public String getType() {

        return "LineString";
    }

    @Override
    public boolean isEmpty() {

        for(Point p : points) {
            if (p.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void translate(double dx, double dy) {

        for(Point p : points) {
            p.translate(dx, dy);
        }
    }

    @Override
    public Envelope getEnvelope() {
        
        EnvelopeBuilder builder = new EnvelopeBuilder();

        for(Point p : points) {
            builder.insert(p.getCoordinate());
        }
		Envelope envelope = builder.build();
        return envelope;
    }

    @Override
    public Geometry clone() {

        LineString newPoints = new LineString();
        for(Point p : points) {
            newPoints.points.add((Point) p.clone());
        }
        return newPoints;
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
