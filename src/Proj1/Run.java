package Proj1;

import static Mathamatics.BasicFormulas.Func.*;

import Mathamatics.BasicFormulas.Func;
import Mathamatics.NumberArray;
import Mathamatics.Numbers.Double;
import Mathamatics.Numbers.Integer;
import Mathamatics.Numbers.NumberSystem;
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
        System.out.println("Time taken for sorting ( length : " + findFact.getLength() + "),ms : " + (t/1000000));
        t1 =  System.nanoTime();
        findFact.forEach(ele -> factorial((Integer) ele),false);
        t2 = System.nanoTime();
        t = t2 - t1;
        System.out.println("Finding factorial for each element ( length : " + findFact.getLength() + ")(iterative method),ms : " + (t/1000000));
        t1 = System.nanoTime();
        findFact.factorial();
        t2 = System.nanoTime();
        t = t2 - t1;
        System.out.println("Finding factorial for each element ( length : " + findFact.getLength() + ") (dynamic programming method),ms : " + (t/1000000));
        NumberArray<Integer> findFib = NumberArray.range(200);
        t1 =  System.nanoTime();
        NumberArray<Integer> fibAns = findFact.forEach(Func::fib,false,7);
        t2 = System.nanoTime();
        t = t2 - t1;
        System.out.println("Finding fibonacci for each element ( length : " + findFib.getLength() + ") (iterative method),ms : " + (t/1000000));
        t1 =  System.nanoTime();
        int index = findFib.search(new Integer(75));
        t2 = System.nanoTime();
        if(index == -1)
        {
            System.out.println("Element is not present!");
        }
        else{
            System.out.println("fibonacci of " + 75 + " : " + fibAns.get(index).repr());
        }
        t = t2 - t1;
        System.out.println("Searching element ( length : " + findFib.getLength() + ") (iterative method),ms : " + (t/1000000) + " ns : " + t);


    }
}



