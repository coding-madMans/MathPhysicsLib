package Mathamatics.Vectors;

import Mathamatics.Numbers.Double;
import Mathamatics.Numbers.NumberClass;

public class Vector extends Vectors<Double> {

    public Vector(int length) {
        super(length);
    }

    public Vector(int length, NumberClass defaultValue){
        super(length, defaultValue);
    }

    @Override
    public Vectors<Double> Clone() {
        return new Vector(this.getLength());
        // for(int i = ){} complete it Suprith..
    }

    @Override
    public String getClassName() {
        return Double.class.getName();
    }
}
