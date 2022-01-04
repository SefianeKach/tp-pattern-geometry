package org.acme.geometry;

public class WktWriter {

    public WktWriter() {
    }

    public String write(Geometry geometry) {

        if (geometry.isEmpty()) {
            return geometry.getType().toUpperCase() + " EMPTY";
        }

        if ( geometry instanceof Point ) {

            Point point = (Point)geometry;
            // traiter le cas Point
            double x = point.getCoordinate().getX();
            double y = point.getCoordinate().getY();
            return "POINT(" + x + " " + y + ")";

        }else if ( geometry instanceof LineString ){

            LineString lineString = (LineString)geometry;
            // traiter le cas LineString
            String linestringStr = "LINESTRING(";
            for(int i=0; i < lineString.getNumPoints(); ++i) {

                double x = lineString.getPointN(i).getCoordinate().getX();
                double y = lineString.getPointN(i).getCoordinate().getY();
                linestringStr += + x + " " + y + ","; 
            }
            // supprimer la virgule, dernier elt de la chaine de caractère
            linestringStr = linestringStr.substring(0, linestringStr.length()-1);
            return linestringStr += ")";
        }else{
            throw new RuntimeException("geometry type not supported");
        }
    }
}
