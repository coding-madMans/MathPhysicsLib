package Test;

import Mathamatics.MathematicalConstants;
import Mathamatics.Numbers.Double;
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
    }
}
