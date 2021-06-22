package Mathamatics.Vectors;

import Mathamatics.Numbers.Double;
import Mathamatics.Numbers.NumberClass;
import utility.MathError;

public class Vector extends Vectors {

    public Vector(int length) {
        super(length);
    }

    public Vector(int length, NumberClass defaultValue){
        super(length, defaultValue);
    }

    @Override
    public Vectors Clone() throws MathError {
        Vector vector =  new Vector(this.getLength());
        for(int i = 0; i < this.getLength(); i++){
            vector.pushDataIndex(i, (NumberClass) this.getDataIndex(i).Clone());
        }
        return vector;
    }

    @Override
    public String getClassName() {
        return Double.class.getName();
    }
}
