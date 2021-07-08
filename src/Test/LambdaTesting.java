package Test;

import Mathamatics.NumberArray;
import Mathamatics.Numbers.Double;
import Mathamatics.Numbers.RealNumbers;
import utility.MathError;

import java.util.Arrays;

public class LambdaTesting {
    public static void main(String[] args) throws MathError {
        NumberArray<Double> arr = new NumberArray<>(7);
        for(int i = 0; i < arr.getLength(); i++){
            arr.push(i, new Double(i + (i * i)));
        }
        System.out.println("before for each : " + arr.repr());
        arr.forEach((RealNumbers d) -> {
            d.add(1, true);
        });
        System.out.println("after for each : " + arr.repr());
        boolean[] map = arr.map((RealNumbers ele, RealNumbers mapVar) -> ele.getAsDouble() >= mapVar.getAsDouble()
                , new Double(10));
        System.out.println(Arrays.toString(map));
    }
}
