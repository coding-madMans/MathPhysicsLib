package Mathamatics;

import Mathamatics.Numbers.Integer;
import Mathamatics.Numbers.NumberClass;
import Mathamatics.Numbers.RealNumbers;
import utility.MathError;

public class NumberArray<T extends RealNumbers> {

    private NumberClass[] array;

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

    // Vishal sorting algo here vvv
    public void sort(){}

    public NumberArray<T> split(int s, int e){
        return this.split(s, e, false);
    }

    public NumberArray<T> split(int s, int e, boolean writeBack){
        if((s < 0) || (e > this.array.length) || (s < e)){
            return null;
        }
        NumberArray<T> arr = new NumberArray<>(s - e);
        for(int i = 0; i < arr.getLength(); i++){
            arr.array[i] = (NumberClass) this.array[s + i].Clone();
        }
        if(writeBack){
            this.array = arr.array;
            return this;
        }
        return arr;
    }

    public NumberArray<T> merge(NumberArray<T> arr){
        return this.merge(arr, false);
    }

    public NumberArray<T> merge(NumberArray<T> arr, boolean writeBack){
        NumberArray<T> tArr = new NumberArray<>(this.getLength() + arr.getLength());
        int i = 0, t = 0;
        for(;i < this.getLength(); i++){
            tArr.array[i] = (NumberClass) this.array[i].Clone();
        }
        for(i = 0; i < arr.getLength(); i++, t++){
            tArr.array[i + t] = (NumberClass) arr.array[i].Clone();
        }
        if(writeBack){
            this.array = tArr.array;
            return this;
        }
        return tArr;
    }

    public int search(T ele){
        for(int i = 0; i < this.getLength(); i++){
            if(this.array[i].eql(ele)){
                return i;
            }
        }
        return -1;
    }

    public int search(T ele, boolean sorted){
        if(sorted){
            int s = 0, e = this.getLength(), m = ((s + e) / 2);
            while(e > s){
                if(this.array[m].eql(ele)){
                    return m;
                }
                if(this.array[m].grater(ele)){
                    s = m + 1;
                }else{
                    e = m - 1;
                }
            }
            return -1;
        }
        return this.search(ele);
    }

    public interface ForEach{
        void run(RealNumbers ele);
    }

    public void forEach(ForEach func){
        for(NumberClass ele : this.array){
            func.run((RealNumbers) ele);
        }
    }

    public interface Map{
        boolean run(RealNumbers self, RealNumbers mapVar);
    }

    public boolean[] map(Map mapFunc, RealNumbers mapVar){
        boolean[] map = new boolean[this.getLength()];
        for(int i = 0; i < this.getLength(); i++){
            map[i] = mapFunc.run((RealNumbers) this.array[i], mapVar);
        }
        return map;
    }

}
