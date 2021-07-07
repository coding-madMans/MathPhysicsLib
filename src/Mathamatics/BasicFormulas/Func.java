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
        double num = a.getAsDouble();

        if ((num < MathematicalConstants.Negative_Infinity) || (num > MathematicalConstants.Positive_Infinity)) {
            return new Double(MathematicalConstants.NaN);
        }

        // If you can't use Math.PI neither,
        // you'll have to create your own PI
        //double num = (deg*MathematicalConstants.PI)/180;
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
        final int PRECISION = 100;
        double temp = 0, temp2 = temp;
        Integer i = new Integer(0);
        while((temp != MathematicalConstants.Negative_Infinity) && (i.getAsInt() < PRECISION)){
            temp2 = temp;
            temp += (Pow(new Integer(-1), i)).getAsDouble() * (Pow(new Double(num), new Integer(2 * i.getAsInt() + 1))).getAsDouble()/(factorial(new Integer(2 * i.getAsInt() + 1))).getAsDouble();
            i = new Integer(i.getAsInt()+ 1);
        }

        return new Double(sign * temp2);

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
        Double cosValue = new Double(Cos(deg).getAsDouble());
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
        return Pow(new Double(MathematicalConstants.e),num);
    }

    public static RealNumbers Sinh(RealNumbers deg)
    {
        //Double Value1 = new Double(Exp(deg).getAsDouble());
        //Double Value2 = new Double(Exp(new Double(deg.inv())).getAsDouble());
        return new Double((Exp(deg).getAsDouble()-(Exp(new Double(-deg.getAsDouble()))).getAsDouble())/2);
    }

    public static RealNumbers Cosh(RealNumbers deg)
    {
        return new Double((Exp(deg).getAsDouble()+(Exp(new Double(-deg.getAsDouble()))).getAsDouble())/2);
    }

    public static RealNumbers Tanh(RealNumbers deg)
    {
        Double sinValue = new Double(Sinh(deg).getAsDouble());
        Double cosValue = new Double(Cosh(deg).getAsDouble());
        if(Cosh(deg).getAsDouble() == 0)
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

    public static RealNumbers Cosech(RealNumbers deg)
    {
        Double sinhValue = new Double(Sinh(deg).getAsDouble());
        if (sinhValue.getAsDouble() == 0){
            return new Double(MathematicalConstants.Positive_Infinity);
        }
        return new Double(1/sinhValue.getAsDouble());
    }

    public static RealNumbers Sech(RealNumbers deg)
    {
        Double coshValue = new Double(Cosh(deg).getAsDouble());
        if (coshValue.getAsDouble() == 0){
            return new Double(MathematicalConstants.Positive_Infinity);
        }
        return new Double(1/coshValue.getAsDouble());
    }

    public static RealNumbers Coth(RealNumbers deg)
    {
        Double sinValue = new Double(Sinh(deg).getAsDouble());
        Double cosValue = new Double(Cosh(deg).getAsDouble());
        if(Sinh(deg).getAsDouble() == 0)
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

    public static RealNumbers Min(RealNumbers arr[],Integer n)
    {

        RealNumbers min = new Integer(arr[0].getAsInt());

        for(int i=1;i< n.getAsInt();i++)
        {
            if(arr[i].getAsInt() < min.getAsInt() )
            {
                min = arr[i];
            }
        }
        return min;
    }

    public static RealNumbers Max(RealNumbers arr[],Integer n)
    {

        RealNumbers max = new Integer(arr[0].getAsInt());

        for(int i=1;i< n.getAsInt();i++)
        {
            if(arr[i].getAsInt() > max.getAsInt() )
            {
                max = arr[i];
            }
        }
        return max;
    }

    //MERGE SORT BEGINS
    public static void merge(NumberArray<?> arr, int l, int m, int r) throws MathError {
        // Find sizes of two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        NumberArray<?> L = new NumberArray<>(n1);
        NumberArray<?> R = new NumberArray<>(n2);


        for (int i = 0; i < n1; ++i)
            L.push(i, arr.get(l + i));
        for (int j = 0; j < n2; ++j)
            R.push(j, arr.get(m + 1 + j));

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L.get(i).getAsDouble() <= R.get(j).getAsDouble()) {
                arr.push(k, L.get(i));
                i++;
            } else {
                arr.push(k, R.get(j));
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr.push(k, L.get(i));
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr.push(k, R.get(j));
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static NumberArray<?> Sort(NumberArray<?> arr, int l, int r) throws MathError {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            Sort(arr, l, m);
            Sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
     return arr;
    }
    //MERGE SORT END

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
            return (RealNumbers) factorial(n).div(factorial(r));
        } catch (MathError mathError) {
            mathError.printStackTrace();
            return new Double(MathematicalConstants.NaN);
        }
    }
}
