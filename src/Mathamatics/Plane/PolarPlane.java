
/*
 * written by Vasu.Subbannavar
 * data : 17/06/2021
 */

package Mathamatics.Plane;

import Mathamatics.Plane.Point.Point;
import Mathamatics.Plane.Shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class PolarPlane implements Plane {

    private List<Point> polarPoint;
    private List<Shape> polarShapes; // not yet implemented..

    public PolarPlane(){
        this.polarPoint = new ArrayList<>();
        this.polarShapes = new ArrayList<>();
    }

    @Override
    public String getPlaneName() {
        return PolarPlane.class.getName();
    }

    @Override
    public Point getPoint(int index) {
        return this.polarPoint.get(index);
    }

    @Override
    public Point getLastPoint() {
        return this.polarPoint.get(this.polarPoint.size() - 1);
    }
}
