package Test;

import Mathamatics.Equation.Equation;
import Mathamatics.Numbers.Double;
import Mathamatics.Numbers.Float;
import Mathamatics.Numbers.Integer;
import utility.MathError;

public class EquationTesting {

    public static void main(String[] args) throws MathError {
        Equation<Float, Integer> equation = new Equation<>(new char[]{'x', 'y', 'z'}, 1);
        System.out.println("equation : " + equation.repr());
        equation.insertTerm(new Float(3.54), new Integer[]{
                new Integer(-11), new Integer(3), new Integer(2)
        });
        System.out.println("equation : " + equation.repr());
        equation.insertTerm(new Float(4.765), new Integer[]{
                new Integer(4), new Integer(-11), new Integer(6)
        });
        equation.insertTerm(new Float(7.543), new Integer[]{
                new Integer(1), new Integer(2), new Integer(-11)
        });
        System.out.println("equation : " + equation.repr());
        Double ans = (Double) equation.solve(new Double[][]{
                {new Double(3.45), new Double(4.53), new Double(8.93)},
                {new Double(6.54), new Double(3.23), new Double(8.22)},
                {new Double(9.05), new Double(5.67), new Double(1.46)}
        });
        System.out.println("ans : " + ans.repr());
    }

}
