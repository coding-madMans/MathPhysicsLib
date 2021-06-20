package Mathamatics.BasicFormulas;
import java.lang.Math;
import Mathamatics.Numbers.Double;


public class Func {

    //BY VISHAL
    static double PI =  3.14159265358979323846;
    static double e = 2.7182818284590452353602;

    public static double factorial(double num){
        if(num==1 || num==0){
            return 1;
        }
        return (num*factorial(num-1));
    }

    public static double Abs(double num)
    {
        if(num >= 0){
            return num;
        }
        return -num;
    }

    public static double Pow(double base,double power){
        double ans=1;
        for (int i = 0; i < Abs(power); i++) {
                ans = ans * base;
        }
        if(power >= 0.0) {
        return ans;
        }
        return (1/ans);

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
        return(Cos(deg)/Sin(deg));
    }

    // BY SUPRITH

    public static double Exp(double num)
    {
        return Pow(e,num);
    }

    public static double Sinh(double deg)
    {
        return ((Exp(deg)-(Exp(-deg)))/2);
    }

    public static double Cosh(double deg)
    {
        return ((Exp(deg)+Exp(-deg))/2);
    }

    public static double Tanh(double deg)
    {
        return (Sinh(deg)/Cosh(deg));
    }

    public static double Cosech(double deg)
    {
        return (1/(Sinh(deg)));
    }

    public static double Sech(double deg)
    {
        return (1/(Cosh(deg)));
    }

    public static double Coth(double deg)
    {
        return (Cosh(deg)/Sinh(deg));
    }

    public static void main(String args[]){
        System.out.println(Pow(2,-2));
        System.out.println(Exp(-5));
        System.out.println(Sinh(1));
        System.out.println(Cosh(1));
        System.out.println(Tanh(1));
        System.out.println(Cosech(1));
        System.out.println(Sech(1));
        System.out.println(Coth(1));
    }


}














































































