package Mathamatics;

import Mathamatics.Numbers.Double;
import Mathamatics.Numbers.Float;
import Mathamatics.Numbers.Integer;
import Mathamatics.Numbers.Long;
import Mathamatics.Numbers.NumberClass;
import Mathamatics.Numbers.RealNumbers;
import utility.MathError;

import java.util.ArrayList;
import java.util.List;

public class NumberArray<T extends RealNumbers> {

    public interface Lambda{
        String getLambdaType();
    }

    public interface ForEach extends Lambda{
        RealNumbers run(RealNumbers ele);
        default String getLambdaType(){
            return ForEach.class.getName();
        }
    }

    public interface Map extends Lambda{
        boolean run(RealNumbers self, RealNumbers mapVar);
        default String getLambdaType(){
            return Map.class.getName();
        }
    }

    public interface FuncMap extends Lambda{
        RealNumbers run(RealNumbers self, RealNumbers other);
        default String getLambdaType(){
            return  FuncMap.class.getName();
        }
    }

    private static class LambdaJob implements Runnable{

        private final NumberArray<?> upper;
        public Object[] returnArray;
        private final Lambda func;
        private final Object LOCK = new Object();
        private final Object agrs;
        private int index;
        private final List<Thread> thread;

        public LambdaJob(NumberArray<?> upper, Lambda func, int threadCount, Object args){
            this.upper = upper;
            this.func = func;
            if(func.getLambdaType().equals(ForEach.class.getName()) ||
                    func.getLambdaType().equals(FuncMap.class.getName())){
                this.returnArray = new NumberClass[upper.getLength()];
            }else if(func.getLambdaType().equals(Map.class.getName())){
                this.returnArray = new Boolean[upper.getLength()];
            }
            this.index = 0;
            int threadCount1 = Math.min(threadCount, upper.getLength());
            this.thread = new ArrayList<>();
            this.agrs = args;
            System.out.println("number of threads : " + threadCount1);

            for(int i = 0; i < threadCount1; i++){
                Thread t = new Thread(this);
                t.start();
                this.thread.add(t);
            }

        }

        public int getJob(){
            int i = -1;
            synchronized (LOCK){
                if (index < upper.getLength()){
                    i = index++;
                }
            }
            return i;
        }

        public void submitWork(int index, Object work){
            this.returnArray[index] = work;
        }

        public boolean isDoneWorking(){
            boolean done = false;
            for(Thread t : this.thread){
                done = !(t.isAlive());
            }
            return done;
        }

        @Override
        public void run() {
            int jobIndex = this.getJob();
            if(this.func.getLambdaType().equals(ForEach.class.getName())){
                ForEach function = (ForEach) this.func;
                while(jobIndex != -1){
                    try {
                        this.submitWork(jobIndex, function.run(upper.get(jobIndex)));
                    } catch (MathError mathError) {
                        mathError.printStackTrace();
                        this.submitWork(jobIndex, null);
                    }
                    jobIndex = this.getJob();
                }
            }else if(this.func.getLambdaType().equals(Map.class.getName())){
                Map function = (Map) this.func;
                RealNumbers mapVar = (RealNumbers) this.agrs;
                while(jobIndex != -1){
                    try {
                        this.submitWork(jobIndex, function.run(upper.get(jobIndex), mapVar));
                    } catch (MathError mathError) {
                        mathError.printStackTrace();
                        this.submitWork(jobIndex, null);
                    }
                    jobIndex = this.getJob();
                }
            }else if(func.getLambdaType().equals(FuncMap.class.getName())){
                FuncMap function = (FuncMap) this.func;
                NumberArray<?> other = (NumberArray<?>) agrs;
                while (jobIndex != -1){
                    try{
                        this.submitWork(jobIndex, function.run(upper.get(jobIndex), other.get(jobIndex)));
                    }catch (MathError mathError){
                        mathError.printStackTrace();
                        this.submitWork(jobIndex, null);
                    }
                    jobIndex = this.getJob();
                }
            }
        }
    }

    public interface Init<T>{
        T init(int index);
    }

    private NumberClass[] array;

    public NumberArray(int size){
        this.array = new NumberClass[size];
    }

    public NumberArray(NumberClass[] arr) throws MathError {
        if(arr == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        this.array = arr;
    }

    public NumberArray(Init<T> init, int size){
        this.array = new NumberClass[size];
        for(int i = 0; i < size; i++){
            this.array[i] = (NumberClass) init.init(i);
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
        return (RealNumbers) this.array[index].Clone();
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

    public NumberArray<T> sort() throws MathError {
        return sort(false);

    }

    public NumberArray<T> sort(boolean writeBack) throws MathError {
        NumberArray<T> temp = new NumberArray<T>(array);
        _sort(temp.array, 0, temp.getLength()-1);
        if(writeBack){
            this.array = temp.array;
            return this;
        }
        return temp;
    }

    private void _sort(NumberClass[] arr, int low, int high){
        if(high<=low){
            return;
        }
        int mid = (low+high)/2;
        _sort(arr, low, mid);
        _sort(arr, mid+1, high);
        _mergeArray(arr,low,mid,high);
    }

    private void _mergeArray(NumberClass[] arr, int low, int mid, int high){
        int n1 = mid - low + 1;
        int n2 = high-mid;
        NumberClass[] arr1 = new NumberClass[n1];
        NumberClass[] arr2 = new NumberClass[n2];
        System.arraycopy(arr, low, arr1, 0, n1);
        for (int j = 0; j < n2; ++j)
            arr2[j] = arr[mid + 1 + j];

        int i=0, j=0;
        int k = low;
        while (i < n1 && j < n2) {
            if (arr1[i].lessEql(arr2[j])) {
                arr[k] = arr1[i];
                i++;
            }
            else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }
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

    public NumberArray<T> forEach(ForEach func, boolean writeBack){
        NumberArray<T> arr = new NumberArray<>(this.getLength());
        for(int i = 0; i < this.getLength(); i++){
            arr.array[i] = (NumberClass) func.run((RealNumbers) this.array[i]);
        }
        if(writeBack){
            this.array = arr.array;
            return this;
        }
        return arr;
    }

    public NumberArray<T> forEach(ForEach func, boolean writeBack, int threadCount) throws MathError {
        LambdaJob job = new LambdaJob(this, func, threadCount, null);
        while(!job.isDoneWorking()){
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(writeBack){
            this.array = (NumberClass[]) job.returnArray;
            return this;
        }
        return new NumberArray<>((NumberClass[]) job.returnArray);
    }

    public boolean[] map(Map func, RealNumbers mapVar){
        boolean[] map = new boolean[this.getLength()];
        for(int i = 0; i < this.getLength(); i++){
            map[i] = func.run((RealNumbers) this.array[i], mapVar);
        }
        return map;
    }

    public boolean[] map(Map func, RealNumbers mapVar, int threadCount){
        LambdaJob job = new LambdaJob(this, func, threadCount, mapVar);
        while(!job.isDoneWorking()){
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        boolean[] map = new boolean[this.getLength()];
        Boolean[] ans = (Boolean[]) job.returnArray;
        for(int i = 0; i < this.getLength(); i++){
            map[i] = ans[i];
        }

        return map;
    }

    public NumberArray<T> funcMap(FuncMap funcMap, NumberArray<?> other, boolean writeBack) throws MathError {
        if(this.getLength() != other.getLength()){
            throw new MathError(MathError.INCORRECT_ARGUMENT_SIZE);
        }
        NumberArray<T> ans = new NumberArray<>(this.getLength());
        for(int i = 0; i < this.getLength(); i++){
            ans.array[i] = (NumberClass) funcMap.run(this.get(i), other.get(i));
        }
        if(writeBack){
            this.array = ans.array;
            return this;
        }
        return ans;
    }

    public NumberArray<T> funcMap(FuncMap funcMap, NumberArray<?> other, boolean writeBack, int threadCount) throws MathError {
        if(this.getLength() != other.getLength()){
            throw new MathError(MathError.INCORRECT_ARGUMENT_SIZE);
        }
        LambdaJob job = new LambdaJob(this, funcMap, threadCount, other);
        while(!job.isDoneWorking()) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(writeBack){
            this.array = (NumberClass[]) job.returnArray;
            return this;
        }
        return new NumberArray<>((NumberClass[])job.returnArray);
    }

    public static NumberArray<Integer> range(int size) throws MathError {
        return NumberArray.range(0, size);
    }

    public static NumberArray<Integer> range(int start, int end) throws MathError {
        if(start > end){
            throw new MathError(MathError.INCORRECT_ARGUMENTS);
        }
        return new NumberArray<>(index -> new Integer(index + start), end - start);
    }

    public static NumberArray<Float> lineSpacing(float start, float end, int freq) throws MathError {
        if((start > end) || (freq < 1)){
            throw new MathError(MathError.INCORRECT_ARGUMENTS);
        }
        return new NumberArray<>(index -> new Float(start + ((float)index / freq)), (int) (((end - start) * freq) + 1));
    }

    public NumberClass[] minMax(){
        Double min = new Double(MathematicalConstants.Positive_Infinity);
        Double max = new Double(MathematicalConstants.Negative_Infinity);
        for(NumberClass ele : this.array){
            if(ele.grater(max)){ // ele > max
                max = (Double) ele.Clone();
            }
            if(ele.less(min)){ // ele < min
                min = (Double) ele.Clone();
            }
        }
        return new Double[]{min, max};
    }

    public NumberArray<?> factorial(){ // the elements in this.array should be sorted...
        int max = ((Integer) this.array[this.getLength() - 1]).getAsInt();
        NumberArray<Double> fact = new NumberArray<>(this.getLength());
        int index = 0;
        double factValue = 1.0;
        for(int i = 0; (i <= max) && (index < this.getLength()); i++){
            if(i != 0){
                factValue *= i;
            }
            while(((Integer)this.array[index]).eql(i)){
                fact.array[index] = new Double(factValue);
                index += 1;
                if(index >= this.getLength()){
                    break;
                }
            }
        }
        return fact;
    }
}
