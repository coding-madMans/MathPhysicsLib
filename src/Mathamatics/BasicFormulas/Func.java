package Mathamatics.BasicFormulas;
import java.lang.Math;

import Mathamatics.Numbers.Double;
import Mathamatics.Numbers.Integer;
import Mathamatics.Numbers.NumberClass;

public class Func {

    public static double factorial(double num){
        if(num==1 || num==0){
            return 1;
        }
        return (num*factorial(num-1));
    }
    public static double Pow(double base,double power){
        int i;
        double ans=1;
        for(i=0;i<power;i++){
            ans = ans*base;
        }
        return ans;
    }
    public static double Sqrt(double number){
        double root = 1;
        int i = 0;
        while (true)
        {
            i = i + 1;
            root = (number / root + root) / 2;
            if (i == number + 1) { break; }
        }
        return root;
    }
    public static double Sin(double deg) {

        if (deg == Double.Negative_Infinity || !(deg < Double.Positive_Infinity)) {
            return Double.NaN;
        }

        // If you can't use Math.PI neither,
        // you'll have to create your own PI
        final double PI = 3.14159265358979323846;
        double a = (deg*PI)/180;
        // Fix the domain for a...

        // Sine is a periodic function with period = 2*PI
        a %= 2 * PI;
        // Any negative angle can be brought back
        // to it's equivalent positive angle
        if (a < 0) {
            a = 2 * PI - a;
        }
        // Also sine is an odd function...
        // let's take advantage of it.
        int sign = 1;
        if (a > PI) {
            a -= PI;
            sign = -1;
        }
        // Now a is in range [0, pi].


        // Calculate sin(a)

        // Set precision to fit your needs.
        // Note that 171! > Double.MAX_VALUE, so
        // don't set PRECISION to anything greater
        // than 84 unless you are sure your
        // Factorial.factorial() can handle it
        final int PRECISION = 85;
        double temp = 0;
        for (int i = 0; i <= PRECISION; i++) {
            temp += Math.pow(-1, i) * (Math.pow(a, 2 * i + 1) / factorial(2 * i + 1));
        }

        return (sign * temp);

    }
    public static double Cos(double deg){
        double a = 90-deg;
        return (Sin(a));
    }
    public static double Tan(double deg){
        return(Sin(deg)/Cos(deg));
    }
    public static double Cosec(double deg){
        return(1/Sin(deg));
    }
    public static double Sec(double deg){
        return(1/Cos(deg));
    }
    public static double Cot(double deg){
        return(1/Tan(deg));
    }

    public static void main(String args[]){
        System.out.println(Cosec(90));
        System.out.println(Sec(0));
        System.out.println(Cot(45));
        System.out.println(Sqrt(4));
    }
}
