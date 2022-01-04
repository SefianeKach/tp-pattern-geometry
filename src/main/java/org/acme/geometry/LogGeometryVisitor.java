package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor {

    private PrintStream out;

    public LogGeometryVisitor(PrintStream out) {
        this.out = out;
    }

    @Override
    public void visit(Point point) {
        String strPoint = "Je suis un point avec x=";
        strPoint += point.getCoordinate().getX();
        strPoint += " et y=" + point.getCoordinate().getY();
        out.println(strPoint);
    }

    @Override
    public void visit(LineString LineString) {
        String strPolyligne = "Je suis une polyligne définie par ";
        strPolyligne += LineString.getNumPoints() + " point(s)";
        out.println(strPolyligne);
    }

}