package org.acme.geometry;

public class Envelope {

    private Coordinate bottomLeft;
    private Coordinate topRight;

    public Envelope() {
        this.bottomLeft = new Coordinate();
        this.topRight = new Coordinate();
    }

    public Envelope(Coordinate bottomLeft, Coordinate topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public double getXmin() {
        
        if (bottomLeft.getX() <= topRight.getX()) {
            return bottomLeft.getX();
        } else {
            return topRight.getX();
        }
    }

    public double getYmin() {
        
        if (bottomLeft.getY() <= topRight.getY()) {
            return bottomLeft.getY();
        } else {
            return topRight.getY();
        }
    }

    public double getXmax() {
        
        if (bottomLeft.getX() >= topRight.getX()) {
            return bottomLeft.getX();
        } else {
            return topRight.getX();
        }
    }

    public double getYmax() {
        
        if (bottomLeft.getY() >= topRight.getY()) {
            return bottomLeft.getY();
        } else {
            return topRight.getY();
        }
    }

    public boolean isEmpty() {

        if (bottomLeft.isEmpty()) {
            return true;
        } else if (topRight.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}