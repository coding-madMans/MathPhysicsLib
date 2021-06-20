package Mathamatics.BasicFormulas;

public class Factorial {
    public static double factorial(double num){
        if(num==1 || num==0){
            return 1;
        }
        return (num*factorial(num-1));
    }
}
