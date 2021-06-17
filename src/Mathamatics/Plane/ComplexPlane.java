
/*
 * written by Vasu.Subbannavar
 * data : 17/06/2021
 */

package Mathamatics.Plane;

import Mathamatics.Plane.Point.ComplexPoint;
import Mathamatics.Plane.Point.Point;
import Mathamatics.Plane.Shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class ComplexPlane implements Plane{

    private List<Point> cmpPoints;
    private List<Shape> cmpShapes; // not yet implemented..

    public ComplexPlane(){
        this.cmpPoints = new ArrayList<>();
        this.cmpShapes = new ArrayList<>();
    }

    public void pushPoint(ComplexPoint point){
        this.cmpPoints.add(point);
    }

    @Override
    public Point getLastPoint(){
        return this.cmpPoints.get(this.cmpPoints.size() - 1);
    }

    @Override
    public String getPlaneName() {
        return ComplexPlane.class.getName();
    }

    @Override
    public Point getPoint(int index) {
        return this.cmpPoints.get(index);
    }
}
