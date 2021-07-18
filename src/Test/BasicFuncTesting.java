package Test;

import Mathamatics.MathematicalConstants;
import Mathamatics.NumberArray;
import Mathamatics.Numbers.Double;
import Mathamatics.Numbers.Integer;
import Mathamatics.Numbers.NumberClass;
import Mathamatics.Numbers.RealNumbers;
import utility.MathError;

import java.util.Arrays;
import java.util.Random;

import static Mathamatics.BasicFormulas.Func.*;
import static Mathamatics.NumberArray.Sort;

public class BasicFuncTesting {
    public static void main(String[] args) throws MathError {
        //Double number = new Double(0);
        System.out.println(Pow(new Double(-2),new Double (-3)).repr());
        System.out.println(Exp(new Double(5)).repr());
        System.out.println(Sinh(new Double(10)).repr());
        System.out.println(Cosh(new Double(10)).repr());
        System.out.println(Tanh(new Double(10)).repr());
       //System.out.println(Cot(new Double(0.7853982)).repr());
        System.out.println(factorial(new Integer(5)).repr());
        System.out.println(Cbrt(new Double(27)).repr());
        System.out.println(Sqrt(new Double(16)).repr());
        NumberArray<Double> array = new NumberArray<>(70);
        Random rand = new Random();
        for(int i = 0; i < array.getLength(); i++){
            array.push(i, new Double(rand.nextDouble() * 100));
        }
        System.out.println(array.repr());
        System.out.println(Sort(array, 0, 69).repr());
        RealNumbers data = fib(new Integer(2));

        NumberClass[] a = array.minMax();
        for(int i=0;i<2;i++)
        {
            System.out.println(a[i].repr());
        }
        System.out.println(NpR(new Integer(8),new Integer(2)).repr());
        System.out.println(NcR(new Integer(8),new Integer(2)).repr());
    }
}
