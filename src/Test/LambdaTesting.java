package Test;

import Mathamatics.BasicFormulas.Func;
import Mathamatics.NumberArray;
import Mathamatics.Numbers.Double;
import Mathamatics.Numbers.Float;
import Mathamatics.Numbers.Integer;
import Mathamatics.Numbers.RealNumbers;
import utility.MathError;

public class LambdaTesting {
    public static void main(String[] args) throws MathError {
        int size = 7000;
        System.out.println("Size : " + size);
        NumberArray<Double> arr = new NumberArray<>(Double::new, size);
        NumberArray<Double> arr2 = new NumberArray<>(index -> new Double((index + 1) * index), size);
        // System.out.println(arr.repr());
        long st, et, t1, t2;
        st = System.nanoTime();
        NumberArray<Double> factArr1 = arr.funcMap(((self, other) -> {
            try {
                Thread.sleep(1);
                return (RealNumbers) self.mul(other);
            } catch (MathError | InterruptedException mathError) {
                mathError.printStackTrace();
            }
            return null;
        }), arr2, false, 2);
        et = System.nanoTime();
        t1 = et - st;
        System.out.println("array optimised time (ms) : " + ((double)t1 / 1000_000));
        NumberArray<Integer> arr1 = new NumberArray<>(Integer::new, size);
        st = System.nanoTime();
        NumberArray<Double> factArr2 = arr.funcMap(((self, other) -> {
            try {
                Thread.sleep(1);
                return (RealNumbers) self.mul(other);
            } catch (MathError | InterruptedException mathError) {
                mathError.printStackTrace();
            }
            return null;
        }), arr2, false);
        et = System.nanoTime();
        t2 = et - st;
        System.out.println("non array optimised : " + ((double)t2 / 1000_000));
    }
}
