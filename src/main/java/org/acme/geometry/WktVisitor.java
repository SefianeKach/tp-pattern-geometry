package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {

    private StringBuilder buffer;

    public WktVisitor() {
        this.buffer = new StringBuilder();
    }

    public String getResult() {

        return buffer.toString();
    }

    @Override
    public void visit(Point point) {

        if (point.isEmpty()) {
            this.buffer.append("POINT EMPTY");
        } else {
            double x = point.getCoordinate().getX();
            double y = point.getCoordinate().getY();
            this.buffer.append("POINT(" + x + " " + y + ")");
        }
    }

    @Override
    public void visit(LineString LineString) {

        if (LineString.isEmpty()) {
            this.buffer.append("LINESTRING EMPTY");
        } else {
            String linestringStr = "LINESTRING(";
            for(int i=0; i < LineString.getNumPoints(); ++i) {
    
                double x = LineString.getPointN(i).getCoordinate().getX();
                double y = LineString.getPointN(i).getCoordinate().getY();
                linestringStr += + x + " " + y + ","; 
            }
            // supprimer la virgule, dernier elt de la chaine de caractère
            linestringStr = linestringStr.substring(0, linestringStr.length()-1);
            this.buffer.append(linestringStr += ")");
        }
    }
}
