/*
        * written by Suprith Satish, Vishal V Shetty
        * data : 18/06/2021
*/

package Mathamatics.BasicFormulas;
import Mathamatics.Numbers.Double;

import Mathamatics.MathematicalConstants;
import Mathamatics.Numbers.Integer;
import Mathamatics.Numbers.RealNumbers;
import utility.MathError;

public class Func {

    //BY VISHAL
    public static Integer factorial(Integer num) {
        if (num.getAsInt() == 1 || num.getAsInt() == 0) {
            return new Integer(1);
        }
        Integer temp = new Integer(num.getAsInt() - 1);
        try {
            return new Integer(num.mul(factorial(temp)));
        } catch (MathError mathError) {
            mathError.printStackTrace();
        }
    }

    public static double Abs(double num) {
        if (num >= 0) {
            return num;
        }
        return -num;
    }

    public static RealNumbers Pow(RealNumbers base, RealNumbers power) {
        double ans = 1.0;
        for (int i = 0; i < Abs(power.getAsInt()); i++) {
            ans = ans * base.getAsDouble();
        }

        if (power.getAsInt() < 0) {
            return new Double(1 / ans);
        }
        return new Double(ans);
    }

    public static RealNumbers Sqrt(RealNumbers number) {
        double root = 1;
        double i = 0;
        while (true) {
            i = i + 1;
            root = (number.getAsDouble() / root + root) / 2;
            if (i == number.getAsDouble() + 1) {
                break;
            }
        }
        return new Double(root);
    }

    public static RealNumbers Cbrt(RealNumbers number) {
        Double power = new Double(1 / 3);
        return Pow(number, power);
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
        //   int i = 0;
        Integer i = new Integer(0);
        while ((temp != MathematicalConstants.Negative_Infinity) && (i < PRECISION)) {
            temp2 = temp;
            temp += Pow(-1, i) * (Math.pow(num, 2 * i + 1) / factorial(2 * i + 1));
            i += 1;
        }

        return new Double(sign * temp2);

    }

    public static RealNumbers Cos(RealNumbers deg) {
        return Sin(new Double(1.5708 - deg.getAsDouble())); //1.5708 is 90 degrees in radians
    }

    public static RealNumbers Tan(RealNumbers deg) {
        Double sinValue = new Double(Sin(deg).getAsDouble());
        Double cosValue = new Double(Cos(deg).getAsDouble());
        if (cosValue.getAsDouble() == 0)
            return new Double(MathematicalConstants.Positive_Infinity);

        try {
            return (RealNumbers) sinValue.div(cosValue);
        } catch (MathError mathError) {
            mathError.printStackTrace();
            return new Double(MathematicalConstants.NaN);
        }
    }

    public static RealNumbers Cosec(RealNumbers deg) {
        Double sinValue = new Double(Sin(deg).getAsDouble());
        if (sinValue.getAsDouble() == 0)
            return new Double(MathematicalConstants.Positive_Infinity);

        return new Double(1 / sinValue.getAsDouble());
    }

    public static RealNumbers Sec(RealNumbers deg) {
        Double cosValue = new Double(Cos(deg).getAsDouble());
        if (cosValue.getAsDouble() == 0)
            return new Double(MathematicalConstants.Positive_Infinity);
        return new Double(1 / cosValue.getAsDouble());
    }

    public static RealNumbers Cot(RealNumbers deg) {
        Double sinValue = new Double(Sin(deg).getAsDouble());
        Double cosValue = new Double(Cos(deg).getAsDouble());
        if (sinValue.getAsDouble() == 0)
            return new Double(MathematicalConstants.Positive_Infinity);

        try {
            return (RealNumbers) cosValue.div(sinValue);
        } catch (MathError mathError) {
            mathError.printStackTrace();
            return new Double(MathematicalConstants.NaN);
        }

    }

    // BY SUPRITH

    public static RealNumbers Exp(RealNumbers num) {
        return Pow(new Double(MathematicalConstants.e), num);
    }

    public static RealNumbers Sinh(RealNumbers deg) {
        //Double Value1 = new Double(Exp(deg).getAsDouble());
        //Double Value2 = new Double(Exp(new Double(deg.inv())).getAsDouble());
        return new Double((Exp(deg).getAsDouble() - (Exp(new Double(-deg.getAsDouble()))).getAsDouble()) / 2);
    }

    public static RealNumbers Cosh(RealNumbers deg) {
        return new Double((Exp(deg).getAsDouble() + (Exp(new Double(-deg.getAsDouble()))).getAsDouble()) / 2);
    }

    public static RealNumbers Tanh(RealNumbers deg) {
        Double sinValue = new Double(Sinh(deg).getAsDouble());
        Double cosValue = new Double(Cosh(deg).getAsDouble());
        if (Cosh(deg).getAsDouble() == 0) {
            return new Double(MathematicalConstants.Positive_Infinity);
        }
        try {
            return (RealNumbers) sinValue.div(cosValue);
        } catch (MathError mathError) {
            mathError.printStackTrace();
            return new Double(MathematicalConstants.NaN);
        }
    }

    public static RealNumbers Cosech(RealNumbers deg) {
        Double sinhValue = new Double(Sinh(deg).getAsDouble());
        if (sinhValue.getAsDouble() == 0) {
            return new Double(MathematicalConstants.Positive_Infinity);
        }
        return new Double(1 / sinhValue.getAsDouble());
    }

    public static RealNumbers Sech(RealNumbers deg) {
        Double coshValue = new Double(Cosh(deg).getAsDouble());
        if (coshValue.getAsDouble() == 0) {
            return new Double(MathematicalConstants.Positive_Infinity);
        }
        return new Double(1 / coshValue.getAsDouble());
    }

    public static RealNumbers Coth(RealNumbers deg) {
        Double sinValue = new Double(Sinh(deg).getAsDouble());
        Double cosValue = new Double(Cosh(deg).getAsDouble());
        if (Sinh(deg).getAsDouble() == 0) {
            return new Double(MathematicalConstants.Positive_Infinity);
        }
        try {
            return (RealNumbers) cosValue.div(sinValue);
        } catch (MathError mathError) {
            mathError.printStackTrace();
            return new Double(MathematicalConstants.NaN);
        }
    }

    //MERGE SORT BEGINS
    public static void merge(RealNumbers arr[], int l, int m, int r) {
        // Find sizes of two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        RealNumbers L[] = new RealNumbers[n1];
        RealNumbers R[] = new RealNumbers[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getAsDouble() <= R[j].getAsDouble()) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static RealNumbers[] Sort(RealNumbers[] arr, int l, int r) {
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
}
