
/*
 * written by Vasu.Subbannavar
 * data : 16/06/2021
 */

package Mathamatics.Vectors;

import Mathamatics.Numbers.NumberClass;
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

    public abstract Vectors<T> Clone();

    public NumberClass getDataIndex(int index) throws MathError {
        if(index >= this.data.length){
            throw new MathError(MathError.INDEX_OUT_OF_BOUND);
        }
        return (NumberClass) this.data[index].Clone();
    }

    public boolean pushDataIndex(int index, NumberClass data) throws MathError {
        if(index >= this.data.length){
            throw new MathError(MathError.INDEX_OUT_OF_BOUND);
        }
        if(data == null){
            this.data[index] = null;
        }else{
            this.data[index] = (NumberClass) data.Clone();
        }
        return true;
    }

    public Vectors<T> scale(NumberClass sFactor) throws MathError {
        if(sFactor == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        Vectors<T> sVector = this.Clone();
        for(int i = 0; i < this.data.length; i++){
            if(this.data[i] == null){
                throw new MathError(MathError.NULL_POINTER_EXCEPTION);
            }
            sVector.pushDataIndex(i, (NumberClass) this.data[i].mul(sFactor));
        }
        return sVector;
    }

    public Vectors<T> scale(NumberClass sFactor, boolean writeBack) throws MathError {
        if(sFactor == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(writeBack){
            for(int i = 0; i < this.data.length; i++){
                if(this.data[i] == null){
                    throw new MathError(MathError.NULL_POINTER_EXCEPTION);
                }
                this.pushDataIndex(i, (NumberClass) this.data[i].mul(sFactor));
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

}
