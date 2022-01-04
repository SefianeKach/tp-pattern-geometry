package org.acme.geometry;

interface Geometry { 
    public String getType(); 
    public boolean isEmpty();

    public void translate(double dx, double dy);
}
