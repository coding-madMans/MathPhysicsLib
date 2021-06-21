/*
        * written by Suprith Satish, Vishal V Shetty
        * data : 18/06/2021
*/

package Mathamatics.BasicFormulas;
import java.lang.Math;
import Mathamatics.Numbers.Double;
import Mathamatics.MathematicalConstants;
import Mathamatics.Numbers.RealNumbers;
import utility.MathError;

public class Func {

    //BY VISHAL
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

    public static RealNumbers Sin(RealNumbers a) {
        double num = a.getAsDouble();

        if (num == MathematicalConstants.Negative_Infinity || !(num < MathematicalConstants.Positive_Infinity)) {
            return new Double(MathematicalConstants.NaN);
        }

        // If you can't use Math.PI neither,
        // you'll have to create your own PI
     //   double num = (deg*MathematicalConstants.PI)/180;
        // Fix the domain for a...

        // Sine is a periodic function with period = 2*PI
        num %= 2 * MathematicalConstants.PI;
        // Any negative angle can be brought back
        // to it's equivalent positive angle
        if (num < 0) {
            num = 2 * MathematicalConstants.PI - num;
        }
        // Also sine is an odd function...
        // let's take advantage of it.
        int sign = 1;
        if (num > MathematicalConstants.PI) {
            num -= MathematicalConstants.PI;
            sign = -1;
        }
        // Now a is in range [0, pi].


        // Calculate sin(a)

        // Set precision to fit your needs.
        // Note that 171! > Double.MAX_VALUE, so
        // don't set PRECISION to anything greater
        // than 84 unless you are sure your
        // factorial() can handle it
        final int PRECISION = 85;
        double temp = 0;
        for (int i = 0; i <= PRECISION; i++) {
            temp += Math.pow(-1, i) * (Math.pow(num, 2 * i + 1) / factorial(2 * i + 1));
        }

        return new Double(sign * temp);

    }
    public static RealNumbers Cos(RealNumbers deg){
        return Sin(new Double(1.5708-deg.getAsDouble())); //1.5708 is 90 degrees in radians
    }
    public static RealNumbers Tan(RealNumbers deg) {
        Double sinValue = new Double(Sin(deg).getAsDouble());
        Double cosValue = new Double(Cos(deg).getAsDouble());
        if(cosValue.getAsDouble()==0)
            return new Double(MathematicalConstants.Positive_Infinity);

        try {
            return (RealNumbers) sinValue.div(cosValue);
        } catch (MathError mathError) {
            mathError.printStackTrace();
            return new Double(MathematicalConstants.NaN);
        }
    }
    public static RealNumbers Cosec(RealNumbers deg){
        Double sinValue = new Double(Sin(deg).getAsDouble());
        if (sinValue.getAsDouble() == 0)
            return new Double(MathematicalConstants.Positive_Infinity);

        return new Double(1/sinValue.getAsDouble());
    }
    public static RealNumbers Sec(RealNumbers deg){
        Double cosValue = new Double(Sin(deg).getAsDouble());
        if (cosValue.getAsDouble() == 0)
            return new Double(MathematicalConstants.Positive_Infinity);
        return new Double(1/cosValue.getAsDouble());
    }
    public static RealNumbers Cot(RealNumbers deg){
        Double sinValue = new Double(Sin(deg).getAsDouble());
        Double cosValue = new Double(Cos(deg).getAsDouble());
        if(sinValue.getAsDouble()==0)
            return new Double(MathematicalConstants.Positive_Infinity);

        try {
            return (RealNumbers) cosValue.div(sinValue);
        } catch (MathError mathError) {
            mathError.printStackTrace();
            return new Double(MathematicalConstants.NaN);
        }

    }

    // BY SUPRITH

    public static RealNumbers Exp(RealNumbers num)
    {
        return Pow(MathematicalConstants.e,num);
    }

    public static RealNumbers Sinh(RealNumbers deg)
    {
        return ((Exp(deg)-(Exp(-deg)))/2);
    }

    public static RealNumbers Cosh(RealNumbers deg)
    {
        return ((Exp(deg)+Exp(-deg))/2);
    }

    public static RealNumbers Tanh(RealNumbers deg)
    {
        return (Sinh(deg)/Cosh(deg));
    }

    public static RealNumbers Cosech(RealNumbers deg)
    {
        return (1/(Sinh(deg)));
    }

    public static RealNumbers Sech(RealNumbers deg)
    {
        return (1/(Cosh(deg)));
    }

    public static RealNumbers Coth(RealNumbers deg)
    {
        return (Cosh(deg)/Sinh(deg));
    }

    public static void main(String args[]){
        Double number = new Double(90);
        System.out.print(Sin(number));
    }


}














































































