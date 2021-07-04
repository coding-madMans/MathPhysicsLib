package Mathamatics;

import Mathamatics.Numbers.Integer;
import Mathamatics.Numbers.NumberClass;
import Mathamatics.Numbers.RealNumbers;
import utility.MathError;

public class NumberArray<T extends RealNumbers> {

    private final NumberClass[] array;

    public NumberArray(int size){
        this.array = new NumberClass[size];
    }

    public NumberArray(RealNumbers num, int range) throws MathError {
        if(num == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(range < 0){
            throw new MathError(MathError.INCORRECT_ARGUMENTS);
        }
        this.array = new NumberClass[range];
        for(int i = 0; i < this.array.length; i++){
            this.array[i] = (NumberClass) num.getUnitValue().mul(new Integer(i), true);
        }
    }

    public void push(int index, RealNumbers data) throws MathError {
        if((index < 0) || (index >= this.array.length)){
            throw new MathError(MathError.INDEX_OUT_OF_BOUND);
        }
        this.array[index] = (NumberClass) data.Clone();
    }

    public RealNumbers get(int index) throws MathError {
        if((index < 0) || (index >= this.array.length)){
            throw new MathError(MathError.INDEX_OUT_OF_BOUND);
        }
        return (RealNumbers) this.array[index];
    }

    public int getLength(){
        return this.array.length;
    }

    public String repr(){
        StringBuilder info = new StringBuilder("[");
        for(int i = 0; i < this.array.length; i++){
            if (this.array[i] == null) {
                info.append("null");
            } else {
                info.append(this.array[i].repr());
            }
            if(i + 1 < this.array.length){
                info.append(", ");
            }
        }
        return info.append("]").toString();
    }

    public void sort(){}

    public int search(T ele){
        return 0;
    }

}
