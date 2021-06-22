package Mathamatics.Vectors;

import Mathamatics.Numbers.NumberClass;
import utility.MathError;

public class PolarVector extends Vectors{
    public PolarVector(int length) {
        super(length);
    }

    public PolarVector(int length, NumberClass defaultValue){
        super(length, defaultValue);
    }

    @Override
    public Vectors Clone() throws MathError {
        PolarVector polarVector =  new PolarVector(this.getLength());
        for(int i = 0; i < this.getLength(); i++){
            polarVector.pushDataIndex(i, (NumberClass) this.getDataIndex(i).Clone());
        }
        return polarVector;
    }

    @Override
    public String getClassName() {
        return ComplexVector.class.getName();
    }
}
