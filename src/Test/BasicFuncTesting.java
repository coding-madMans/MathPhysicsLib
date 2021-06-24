package Test;

import Mathamatics.MathematicalConstants;
import Mathamatics.Numbers.Double;
import Mathamatics.Numbers.Integer;

import java.util.Arrays;

import static Mathamatics.BasicFormulas.Func.*;

public class BasicFuncTesting {
    public static void main(String[] args){
        //Double number = new Double(0);
        System.out.println("-inf : " + MathematicalConstants.Negative_Infinity);
        System.out.println("inf : " + MathematicalConstants.Positive_Infinity);
        System.out.println("nan : " + MathematicalConstants.NaN);
        System.out.println(Pow(new Double(-2),new Double (-3)).repr());
        System.out.println(Exp(new Double(5)).repr());
        System.out.println(Sinh(new Double(10)).repr());
        System.out.println(Cosh(new Double(10)).repr());
        System.out.println(Tanh(new Double(10)).repr());
       //System.out.println(Cot(new Double(0.7853982)).repr());
        System.out.println(factorial(new Integer(5)).repr());
        System.out.println(Cbrt(new Double(27)).repr());
        System.out.println(Sqrt(new Double(16)).repr());
        Integer[] array = new Integer[4];
        array = new Integer[]{new Integer(19), new Integer(2), new Integer(31), new Integer(4)};
        System.out.println(Arrays.toString(Sort(array, 0, 3)));
        System.out.println(Min(array,new Integer(4)).repr());

    }
}
