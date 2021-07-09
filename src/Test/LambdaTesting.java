package Test;

import Mathamatics.NumberArray;
import Mathamatics.Numbers.Double;
import Mathamatics.Numbers.RealNumbers;
import utility.MathError;

import java.util.Arrays;
import java.util.Random;

public class LambdaTesting {
    public static void main(String[] args) throws MathError {
        NumberArray<Double> arr = new NumberArray<>(3);
        System.out.println("array size : " + arr.getLength());
        Random rand = new Random(System.nanoTime());
        arr.forEach(ele -> {
            ele =  new Double(rand.nextInt() / 1000);
            return ele;
        }, true);
        boolean[] ans = arr.map((RealNumbers ele, RealNumbers mapVar ) -> ele.getAsDouble() >= mapVar.getAsDouble(), new Double(50), 7);
        System.out.println(arr.repr());
        System.out.println(Arrays.toString(ans));
    }
}
