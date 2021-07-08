package Test;

import Mathamatics.Matrix;
import Mathamatics.Numbers.Double;
import Mathamatics.Numbers.Float;
import Mathamatics.Numbers.Long;
import utility.MathError;

public class MatrixTesting {
    public static void main(String[] args) throws MathError {
        Matrix<Long> matrix = new Matrix<>(7, 7, new Long(7.2f));
        Matrix<Long> matrix1 = new Matrix<>(Matrix.TRIANGULAR_MATRIX | Matrix.LOWER_TRIANGULAR ,matrix);
        // System.out.println(matrix.repr());
        System.out.println(matrix1.repr());
        // System.out.println(matrix.mul(new Double(3.75)).repr());
        Matrix<Long> mat =  matrix1.mul(new Double(3.75)).forEach(ele -> ele.inv(true));
        System.out.println(matrix1.repr());
        System.out.println(mat.repr());
    }
}
