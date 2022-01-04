package org.acme.geometry;

public class Point extends AbstractGeometry {

    private Coordinate coordinate;

    public Point() {
        this.coordinate = new Coordinate();
    }

    public Point(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        
        return this.coordinate;
    }

    @Override
    public String getType() {
  
        return "Point";
    }

    @Override
    public boolean isEmpty() {
        return coordinate.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {

        this.coordinate = new Coordinate(
            coordinate.getX() + dx,
            coordinate.getY() + dy
         );
    }

    @Override
    public Envelope getEnvelope() {
        
        EnvelopeBuilder builder = new EnvelopeBuilder();
        builder.insert(coordinate);
		Envelope envelope = builder.build();
        return envelope;
    }

    @Override
    public Geometry clone() {

        return new Point(coordinate);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
