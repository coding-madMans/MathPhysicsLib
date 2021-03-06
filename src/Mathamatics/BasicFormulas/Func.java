/*
        * written by Suprith Satish, Vishal V Shetty
        * data : 18/06/2021
*/


package Mathamatics.BasicFormulas;
import Mathamatics.NumberArray;
import Mathamatics.Numbers.Double;
import Mathamatics.MathematicalConstants;
import Mathamatics.Numbers.RealNumbers;
import utility.MathError;
import Mathamatics.Numbers.Integer;

public class Func {

    //BY VISHAL
    public static Integer factorial(Integer num){
        if(num.getAsInt()==1 || num.getAsInt()==0){
            return new Integer(1);
        }
        return new Integer(num.getAsInt()*(factorial(new Integer(num.getAsInt()-1)).getAsInt()));
    }

    public static double Abs(double num)
    {
        if(num >= 0){
            return num;
        }
        return -num;
    }

    public static RealNumbers Pow(RealNumbers base,RealNumbers power){
        double ans=1.0;
        for (int i = 0; i < Abs(power.getAsInt()); i++) {
                ans = ans * base.getAsDouble();
        }

        if( power.getAsInt() < 0)
        {
            return new Double(1/ans);
        }
        return new Double(ans);
    }

    public static RealNumbers Sqrt(RealNumbers number){
        double root = 1;
        int i = 0;
        while (true)
        {
            i = i + 1;
            root = (number.getAsDouble() / root + root) / 2;
            if (i == number.getAsDouble() + 1) { break; }
        }
        return new Double(root);
    }
    public static RealNumbers Cbrt(RealNumbers num){
        double i, precision = 0.000001;

        for(i = 1; (i*i*i) <= num.getAsInt(); ++i);         //Integer part

        for(--i; (i*i*i) < num.getAsInt(); i += precision);  //Fractional part

        return new Integer(i);
    }

    public static RealNumbers Sin(RealNumbers a) {
        double num = (a.getAsDouble()*MathematicalConstants.PI)/180;

        if ((num < MathematicalConstants.Negative_Infinity) || (num > MathematicalConstants.Positive_Infinity)) {
            return new Double(MathematicalConstants.NaN);
        }
        num %= 2 * MathematicalConstants.PI;
        if (num < 0) {
            num = 2 * MathematicalConstants.PI - num;
        }
        int sign = 1;
        if (num > MathematicalConstants.PI) {
            num -= MathematicalConstants.PI;
            sign = -1;
        }
        final int PRECISION = 84;
        double temp = 0, temp2 = temp;
        Integer i = new Integer(0);
        while((temp != MathematicalConstants.Negative_Infinity) && (i.getAsInt() < PRECISION)){
            temp2 = temp;
            temp += (Pow(new Integer(-1), i)).getAsDouble() * (Pow(new Double(num), new Integer(2 * i.getAsInt() + 1))).getAsDouble()/(factorial(new Integer(2 * i.getAsInt() + 1))).getAsDouble();
            i = new Integer(i.getAsInt()+ 1);
        }

        return new Double(sign * temp2);

    }
    public static RealNumbers Cos(RealNumbers radian){
        return Sin(new Double(90-radian.getAsDouble()));
    }
    public static RealNumbers Tan(RealNumbers radian) {
        Double sinValue = new Double(Sin(radian).getAsDouble());
        Double cosValue = new Double(Cos(radian).getAsDouble());
        if(cosValue.getAsDouble()==0)
            return new Double(MathematicalConstants.Positive_Infinity);

        try {
            return (RealNumbers) sinValue.div(cosValue);
        } catch (MathError mathError) {
            mathError.printStackTrace();
            return new Double(MathematicalConstants.NaN);
        }
    }
    public static RealNumbers Cosec(RealNumbers radian){
        Double sinValue = new Double(Sin(radian).getAsDouble());
        if (sinValue.getAsDouble() == 0)
            return new Double(MathematicalConstants.Positive_Infinity);

        return new Double(1/sinValue.getAsDouble());
    }
    public static RealNumbers Sec(RealNumbers radian){
        Double cosValue = new Double(Cos(radian).getAsDouble());
        if (cosValue.getAsDouble() == 0)
            return new Double(MathematicalConstants.Positive_Infinity);
        return new Double(1/cosValue.getAsDouble());
    }
    public static RealNumbers Cot(RealNumbers radian){
        Double sinValue = new Double(Sin(radian).getAsDouble());
        Double cosValue = new Double(Cos(radian).getAsDouble());
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
        return Pow(new Double(MathematicalConstants.e),num);
    }

    public static RealNumbers Sinh(RealNumbers radian)
    {
        //Double Value1 = new Double(Exp(radian).getAsDouble());
        //Double Value2 = new Double(Exp(new Double(radian.inv())).getAsDouble());
        return new Double((Exp(radian).getAsDouble()-(Exp(new Double(-radian.getAsDouble()))).getAsDouble())/2);
    }

    public static RealNumbers Cosh(RealNumbers radian)
    {
        return new Double((Exp(radian).getAsDouble()+(Exp(new Double(-radian.getAsDouble()))).getAsDouble())/2);
    }

    public static RealNumbers Tanh(RealNumbers radian)
    {
        Double sinValue = new Double(Sinh(radian).getAsDouble());
        Double cosValue = new Double(Cosh(radian).getAsDouble());
        if(Cosh(radian).getAsDouble() == 0)
        {
            return new Double(MathematicalConstants.Positive_Infinity);
        }
        try {
            return (RealNumbers) sinValue.div(cosValue);
        }
        catch (MathError mathError)
        {
            mathError.printStackTrace();
            return new Double(MathematicalConstants.NaN);
        }
    }

    public static RealNumbers Cosech(RealNumbers radian)
    {
        Double sinhValue = new Double(Sinh(radian).getAsDouble());
        if (sinhValue.getAsDouble() == 0){
            return new Double(MathematicalConstants.Positive_Infinity);
        }
        return new Double(1/sinhValue.getAsDouble());
    }

    public static RealNumbers Sech(RealNumbers radian)
    {
        Double coshValue = new Double(Cosh(radian).getAsDouble());
        if (coshValue.getAsDouble() == 0){
            return new Double(MathematicalConstants.Positive_Infinity);
        }
        return new Double(1/coshValue.getAsDouble());
    }

    public static RealNumbers Coth(RealNumbers radian)
    {
        Double sinValue = new Double(Sinh(radian).getAsDouble());
        Double cosValue = new Double(Cosh(radian).getAsDouble());
        if(Sinh(radian).getAsDouble() == 0)
        {
            return new Double(MathematicalConstants.Positive_Infinity);
        }
        try {
            return (RealNumbers) cosValue.div(sinValue);
        }
        catch (MathError mathError)
        {
            mathError.printStackTrace();
            return new Double(MathematicalConstants.NaN);
        }
    }


    // by vasu
    /**
     * fib this is helper function,
     * which calls the fastFib function, with initial conditions..
     * fastFib is a tail recursive function, which has linear time complexity
     *
     * @param number takes in a {@link RealNumbers}, of which u want to find fib
     * @return returns a {@link RealNumbers}
     */
    public static RealNumbers fib(RealNumbers number){
        if(number == null){
            return new Double(MathematicalConstants.NaN);
        }
        return fastFib(number, new Double(0), new Double(1));
    }

    private static Double fastFib(RealNumbers number, RealNumbers a, RealNumbers b){
        if(number.getAsDouble() == 0.0){
            return (Double) a;
        }
        if(number.getAsDouble() == 1.0){
            return (Double) b;
        }
        try {
            return fastFib(number.sub(1), b, (RealNumbers) a.add(b));
        } catch (MathError mathError) {
            mathError.printStackTrace();
            return null;
        }
    }

    public static RealNumbers NcR(RealNumbers N, RealNumbers R){
        if((N == null) || (R == null)){
            return new Double(MathematicalConstants.NaN);
        }
        if(N.getAsInt() < R.getAsInt()){
            return new Double(MathematicalConstants.NaN);
        }
        try {
            Integer n = (Integer) N, r = (Integer) R, nr = (Integer) N.sub(r);
            return (RealNumbers) factorial(n).div(factorial(r).mul(factorial(nr)));
        } catch (MathError mathError) {
            mathError.printStackTrace();
            return new Double(MathematicalConstants.NaN);
        }
    }

    public static RealNumbers NpR(RealNumbers N, RealNumbers R){
        if((N == null) || (R == null)){
            return new Double(MathematicalConstants.NaN);
        }
        if(N.getAsInt() < R.getAsInt()){
            return new Double(MathematicalConstants.NaN);
        }
        try {
            Integer n = (Integer) N, r = (Integer) R;
            return (RealNumbers) factorial(n).div(factorial(new Integer(n.getAsInt()-r.getAsInt())));
        } catch (MathError mathError) {
            mathError.printStackTrace();
            return new Double(MathematicalConstants.NaN);
        }
    }
}
