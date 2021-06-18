
/*
 * written by Vasu.Subbannavar
 * data : 17/06/2021
 */

package Mathamatics.Plane.Point;

import Mathamatics.Numbers.NumberClass;
import Mathamatics.Numbers.PolarNumber;

public class PolarPoint implements Point {

    private PolarNumber polarPoint;

    public PolarPoint(){
        this.polarPoint = new PolarNumber();
    }

    public PolarPoint(PolarNumber polarPoint){
        this.polarPoint = polarPoint;
    }

    @Override
    public NumberClass[] getPointPosition() {
        return null;
    }

    @Override
    public NumberClass getDistanceToPoint() {
        return null;
    }
}
