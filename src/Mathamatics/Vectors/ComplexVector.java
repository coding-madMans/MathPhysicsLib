package Mathamatics.Vectors;

import Mathamatics.Numbers.NumberClass;
import utility.MathError;

public class ComplexVector extends Vectors{
    public ComplexVector(int length) {
        super(length);
    }

    public ComplexVector(int length, NumberClass defaultValue){
        super(length, defaultValue);
    }

    @Override
    public Vectors Clone() throws MathError {
        ComplexVector cmpVector =  new ComplexVector(this.getLength());
        for(int i = 0; i < this.getLength(); i++){
            cmpVector.pushDataIndex(i, (NumberClass) this.getDataIndex(i).Clone());
        }
        return cmpVector;
    }

    @Override
    public String getClassName() {
        return ComplexVector.class.getName();
    }
}
