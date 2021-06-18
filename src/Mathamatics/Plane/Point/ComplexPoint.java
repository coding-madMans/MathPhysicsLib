
/*
 * written by Vasu.Subbannavar
 * data : 17/06/2021
 */

package Mathamatics.Plane.Point;

import Mathamatics.Numbers.ComplexNumber;
import Mathamatics.Numbers.NumberClass;

public class ComplexPoint implements Point{

    private ComplexNumber cmpPoint;

    public ComplexPoint(){
        this.cmpPoint = new ComplexNumber();
    }

    public ComplexPoint(ComplexNumber cmpPoint){
        this.cmpPoint = cmpPoint;
    }

    @Override
    public NumberClass[] getPointPosition() {
        return null; // will be updated soon
    }

    @Override
    public NumberClass getDistanceToPoint() {
        return null; // will be updated soon
    }
}
