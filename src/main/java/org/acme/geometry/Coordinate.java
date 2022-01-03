package org.acme.geometry;

public class Coordinate {
    
    private double x ;
    private double y ;

    public Coordinate() {
        this.x = Double.NaN;
        this.y = Double.NaN;
    }
    
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEmpty() {

        if (Double.isNaN(x)) {
            return true;
        }
        if (Double.isNaN(y)) {
            return true;
        }
        return false;
    }

    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
}




