
/*
 * written by Vasu.Subbannavar
 * data : 17/06/2021
 */

package Mathamatics.Plane;

import Mathamatics.Plane.Point.Point;

public interface Plane {

    String getPlaneName();
    Point getPoint(int index);
    Point getLastPoint();

}
