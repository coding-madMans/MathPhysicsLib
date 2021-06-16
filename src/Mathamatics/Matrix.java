
/*
 * written by Vasu.Subbannavar
 * data : 16/06/2021
 */

package Mathamatics;

import Mathamatics.Numbers.NumberClass;
import utility.MathError;

import static java.lang.Math.*;

public class Matrix<T extends NumberClass>{

    public static final int DIAGONAL_MATRIX = 1;
    public static final int TRIANGULAR_MATRIX = 2;
    public static final int LOWER_TRIANGULAR = 4;
    public static final int TRANSPOSE_MATRIX = 8;

    private NumberClass[][] matrix;

    public Matrix(int rows, int cols, NumberClass defaultValue){
        this.matrix = new NumberClass[rows][cols];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                this.matrix[r][c] = (NumberClass) defaultValue.Clone();
            }
        }
    }

    public Matrix(int rows, int cols, int type, NumberClass defaultValue) throws MathError {
        if((type & Matrix.TRANSPOSE_MATRIX) == Matrix.TRANSPOSE_MATRIX){
            throw new MathError(MathError.INCORRECT_ARGUMENTS);
        }else if((type & Matrix.TRIANGULAR_MATRIX) == Matrix.TRIANGULAR_MATRIX){
            if(rows != cols){
                throw new MathError(MathError.INCORRECT_ARGUMENTS);
            }
        }
        this.matrix = new NumberClass[rows][cols];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                this.matrix[r][c] = (NumberClass) defaultValue.getZeroValue();
            }
        }
        if((type & Matrix.DIAGONAL_MATRIX) == Matrix.DIAGONAL_MATRIX){
            int min = min(rows, cols);
            for(int i = 0; i < min; i++){
                this.matrix[i][i] = (NumberClass) defaultValue.Clone();
            }
        }else if((type & Matrix.TRIANGULAR_MATRIX) == Matrix.TRIANGULAR_MATRIX){
            if((type & Matrix.LOWER_TRIANGULAR) == Matrix.LOWER_TRIANGULAR){
                for(int r = 0; r < rows; r++){
                    for(int c = 0; c < cols; c++){
                        if(c <= r){
                            this.matrix[r][c] = (NumberClass) defaultValue.Clone();
                        }
                    }
                }
            }else{
                for(int r = 0; r < rows; r++){
                    for(int c = 0; c < cols; c++){
                        if(c >= r){
                            this.matrix[r][c] = (NumberClass) defaultValue.Clone();
                        }
                    }
                }
            }
        }
    }

}
