
/*
 * written by Vasu.Subbannavar
 * data : 16/06/2021
 */

package Mathamatics.Vectors;

import Mathamatics.Numbers.*;
import Mathamatics.Numbers.Float;
import Mathamatics.Numbers.Double;
import utility.MathError;

public abstract class Vectors<T extends NumberClass> {

    private NumberClass[] data;

    public Vectors(int length){
        this.data = new NumberClass[length];
    }

    public Vectors(int length, NumberClass defaultValue){
        this.data = new NumberClass[length];
        for(int i = 0; i < length; i++){
            this.data[i] = (NumberClass) defaultValue.Clone();
        }
    }

    public int getLength(){
        return this.data.length;
    }

    public abstract Vectors<T> Clone();

    public abstract String getClassName();

    public NumberClass getDataIndex(int index) throws MathError {
        if(index >= this.data.length){
            throw new MathError(MathError.INDEX_OUT_OF_BOUND);
        }
        return (NumberClass) this.data[index].Clone();
    }

    public void pushDataIndex(int index, NumberClass data) throws MathError {
        if(index >= this.data.length){
            throw new MathError(MathError.INDEX_OUT_OF_BOUND);
        }
        if(data == null){
            this.data[index] = null;
        }else {
            this.data[index] = (NumberClass) data.Clone();
        }
    }

    public Vectors<T> scale(NumberClass sFactor) throws MathError {
        return this.scale(sFactor, false);
    }

    public Vectors<T> scale(NumberClass sFactor, boolean writeBack) throws MathError {
        if(sFactor == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(writeBack){
            for (NumberClass datum : this.data) {
                if (datum == null) {
                    throw new MathError(MathError.NULL_POINTER_EXCEPTION);
                }
                datum.mul(sFactor, true);
            }
            return this;
        }else{
            Vectors<T> sVector = this.Clone();
            for(int i = 0; i < this.data.length; i++){
                if(this.data[i] == null){
                    throw new MathError(MathError.NULL_POINTER_EXCEPTION);
                }
                sVector.pushDataIndex(i, (NumberClass) this.data[i].mul(sFactor));
            }
            return sVector;
        }
    }

    public Vectors<?> crossProduct(Vectors<?> other) throws MathError {
        return this.crossProduct(other, false);
    }

    public Vectors<?> crossProduct(Vectors<?> other, boolean writeBack) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(this.data.length != other.data.length){
            throw new MathError(MathError.INCORRECT_ARGUMENT_SIZE);
        }else if(this.data.length != 3){
            throw new MathError("{ERROR} : vector cross product not possible..");
        }
        String thisClass = this.data[0].getClassName();
        String otherClass = other.data[0].getClassName();
        if((thisClass.equals(ComplexNumber.class.getName()) || thisClass.equals(PolarNumber.class.getName()) ||
                otherClass.equals(ComplexNumber.class.getName()) || otherClass.equals(PolarNumber.class.getName()) )){
            throw new MathError(MathError.INCORRECT_ARGUMENTS);
        }
        Vectors<Double> vector = new Vector(this.data.length);
        vector.data[0] = (NumberClass) this.data[2].mul(other.data[3]).sub(this.data[3].sub(other.data[2]));
        vector.data[1] = (NumberClass) this.data[3].mul(other.data[1]).sub(this.data[1].sub(other.data[3]));
        vector.data[2] = (NumberClass) this.data[1].mul(other.data[2]).sub(this.data[2].sub(other.data[1]));
        if(writeBack){
            this.data = vector.data;
            return this;
        }else{
            return vector;
        }
    }

    public NumberClass dotProduct(Vectors<?> other) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(this.data.length != other.data.length){
            throw new MathError(MathError.INCORRECT_ARGUMENT_SIZE);
        }
        String thisClass = this.data[0].getClassName();
        String otherClass = other.data[0].getClassName();
        if((thisClass.equals(ComplexNumber.class.getName()) || thisClass.equals(PolarNumber.class.getName()) ||
                otherClass.equals(ComplexNumber.class.getName()) || otherClass.equals(PolarNumber.class.getName()) )){
            throw new MathError(MathError.INCORRECT_ARGUMENTS);
        }
        Double value = new Double();
        for(int i = 0; i < this.getLength(); i++){
            value.add(this.data[i].add(other.data[i]), true);
        }
        return value;
    }

}
