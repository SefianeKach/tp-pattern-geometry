package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor {

    private PrintStream out;

    public LogGeometryVisitor(PrintStream out) {
        this.out = out;
    }

    @Override
    public void visit(Point point) {
        String strPoint = "Point with : x=";
        strPoint += point.getCoordinate().getX();
        strPoint += " & y=" + point.getCoordinate().getY();
        out.println(strPoint);
    }

    @Override
    public void visit(LineString LineString) {
        String strPolyligne = "Polygon defined by ";
        strPolyligne += LineString.getNumPoints() + " Point";
        out.println(strPolyligne);
    }

}