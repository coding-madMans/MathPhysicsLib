package Proj1;

import static Mathamatics.BasicFormulas.Func.*;

import Mathamatics.BasicFormulas.Func;
import Mathamatics.MathematicalConstants;
import Mathamatics.NumberArray;
import Mathamatics.Numbers.Double;
import Mathamatics.Numbers.Integer;
import Mathamatics.Numbers.RealNumbers;
import utility.MathError;

import java.util.Random;

public class Run{
    public static void main(String[] args) throws MathError {
        Random rand = new Random();
        NumberArray<Integer> findFact = new NumberArray<> (20000);
        for(int i = 0; i < findFact.getLength(); i++){
            findFact.push(i, new Integer(rand.nextDouble() * 10000));
        }
        long t1,t2,t;
        t1 =  System.nanoTime();
        findFact.sort(true);
        t2 = System.nanoTime();
        t = t2 - t1;
        System.out.println("Time taken for sorting ( length : " + findFact.getLength() + ") : " + (t/1000000) + "ms");
        t1 =  System.nanoTime();
        findFact.forEach(ele -> factorial((Integer) ele),false);
        t2 = System.nanoTime();
        t = t2 - t1;
        System.out.println("Finding factorial for each element ( length : " + findFact.getLength() + ")(iterative method) : " + (t/1000000) + "ms");
        t1 = System.nanoTime();
        findFact.factorial();
        t2 = System.nanoTime();
        t = t2 - t1;
        System.out.println("Finding factorial for each element ( length : " + findFact.getLength() + ") (dynamic programming method) : " + (t/1000000) + "ms");
        NumberArray<Integer> findFib = NumberArray.range(40);
        t1 =  System.nanoTime();
        NumberArray<Integer> fibAns = findFib.forEach(ele -> {
            try {
                return slowFib(ele);
            } catch (MathError mathError) {
                mathError.printStackTrace();
            }
            return new Double(MathematicalConstants.NaN);
        },false);
        t2 = System.nanoTime();
        t = t2 - t1;
        System.out.println("Finding fibonacci for each element ( length : " + fibAns.getLength() + ") (slow method),ms : " + (t/1000000));
        findFib = NumberArray.range(200);
        t1 =  System.nanoTime();
        fibAns = findFib.forEach(Func::fib,false);
        t2 = System.nanoTime();
        t = t2 - t1;
        System.out.println("Finding fibonacci for each element ( length : " + fibAns.getLength() + ") (fast method) : " + (t/1000000) + "ms ");
        t1 =  System.nanoTime();
        int index = findFib.search(new Integer(75));
        t2 = System.nanoTime();
        if(index == -1)
        {
            System.out.println("Element is not present!");
        }
        else{
            System.out.println("fibonacci of " + 75 + " : " + fibAns.get(index).getAsLong());
        }
        t = t2 - t1;
        System.out.println("Searching element ( length : " + findFib.getLength() + ") (fast method) : " + (t/1000000) + "ms, " + t + "ns");
        // System.out.println(fibAns.repr() + ", \n" + fibAns.getLength());
        t1 = System.nanoTime();
        System.out.println("slow method fib of 40 : " + slowFib(new Double(40)).getAsLong());
        t2 = System.nanoTime();
        t = t2 - t1;
        System.out.println("time taken : " + (t/100000) + "ms");
        t1 = System.nanoTime();
        System.out.println("fast method fib of 40 : " + fib(new Double(40)).getAsLong());
        t2 = System.nanoTime();
        t = t2 - t1;
        System.out.println("time taken : " + (t/100000) + "ms");
    }

    public static Double slowFib(RealNumbers num) throws MathError {
        if(num == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(num.getAsLong() == 0){
            return new Double(0);
        }
        if(num.getAsLong() == 1){
            return new Double(1);
        }
        return (Double) slowFib(num.sub(2)).add(slowFib(num.sub(1)));
    }
}
