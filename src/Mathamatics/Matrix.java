
/*
 * written by Vasu.Subbannavar
 * data : 16/06/2021
 */

package Mathamatics;

import Mathamatics.Numbers.NumberClass;
import Mathamatics.Numbers.RealNumbers;
import utility.MathError;

import static java.lang.Math.*;

public class Matrix<T extends NumberClass>{

    public static final int NO_OPERATIONS = 0;
    public static final int DIAGONAL_MATRIX = 1;
    public static final int TRIANGULAR_MATRIX = 2;
    public static final int LOWER_TRIANGULAR = 4;
    public static final int TRANSPOSE_MATRIX = 8;
    public static final int CLONE = 16;
    public static final int ZERO_VALUE_MATRIX = 32;
    public static final int UNIT_VALUE_MATRIX = 64;

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
        if( ((type & Matrix.TRANSPOSE_MATRIX) == Matrix.TRANSPOSE_MATRIX) || ((type & Matrix.CLONE) == Matrix.CLONE) ){
            throw new MathError(MathError.INCORRECT_ARGUMENTS);
        }
        if((type & Matrix.TRIANGULAR_MATRIX) == Matrix.TRIANGULAR_MATRIX){
            if(rows != cols){
                throw new MathError(MathError.INCORRECT_ARGUMENTS);
            }
        }

        this.matrix = new NumberClass[rows][cols];
        if((type & Matrix.UNIT_VALUE_MATRIX) == Matrix.UNIT_VALUE_MATRIX){
            for(int r = 0; r < rows; r++){
                for(int c = 0; c < cols; c++){
                    this.matrix[r][c] = (NumberClass) defaultValue.getUnitValue();
                }
            }
        }else{
            for(int r = 0; r < rows; r++){
                for(int c = 0; c < cols; c++){
                    this.matrix[r][c] = (NumberClass) defaultValue.getZeroValue();
                }
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

    public Matrix(int type, Matrix<T> other) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if((type & Matrix.TRANSPOSE_MATRIX) == Matrix.TRANSPOSE_MATRIX){
            int rows = other.getColumnCount();
            int cols = other.getRowCount();
            this.matrix = new NumberClass[rows][cols];
            for(int r = 0; r < rows; r++){
                for(int c = 0; c < cols; c++){
                    this.matrix[r][c] = (NumberClass) other.matrix[c][r].Clone();
                }
            }
            return;
        }
        int rows = other.getRowCount();
        int cols = other.getColumnCount();
        if((type & Matrix.TRIANGULAR_MATRIX) == Matrix.TRIANGULAR_MATRIX){
            if(rows != cols){
                throw new MathError(MathError.INCORRECT_ARGUMENT_SIZE);
            }
        }
        this.matrix = new NumberClass[rows][cols];
        if((type & Matrix.CLONE) == Matrix.CLONE){
            for(int r = 0; r < rows; r++){
                for(int c = 0; c < cols; c++){
                    this.matrix[r][c] = (NumberClass) other.matrix[r][c].getZeroValue();
                }
            }
        }else if((type & Matrix.DIAGONAL_MATRIX) == Matrix.DIAGONAL_MATRIX){
            int min = min(rows, cols);
            for(int r = 0; r < rows; r++){
                for(int c = 0; c < cols; c++){
                    if((r == c) && (r < min)){ // don't mind about this warning... <3
                        this.matrix[r][r] = (NumberClass) other.matrix[r][r].Clone();
                    }else{
                        this.matrix[r][c] = (NumberClass) other.matrix[r][c].getZeroValue();
                    }
                }
            }
        }else if((type & Matrix.TRIANGULAR_MATRIX) == Matrix.TRIANGULAR_MATRIX){
            if((type & Matrix.LOWER_TRIANGULAR) == Matrix.LOWER_TRIANGULAR){
                for(int r = 0; r < rows; r++){
                    for(int c = 0; c < cols; c++){
                        if(c <= r){
                            this.matrix[r][c] = (NumberClass) other.matrix[r][c].Clone();
                        }else{
                            this.matrix[r][c] = (NumberClass) other.matrix[r][c].getZeroValue();
                        }
                    }
                }
            }else{
                for(int r = 0; r < rows; r++){
                    for(int c = 0; c < cols; c++){
                        if(c >= r){
                            this.matrix[r][c] = (NumberClass) other.matrix[r][c].Clone();
                        }else{
                            this.matrix[r][c] = (NumberClass) other.matrix[r][c].getZeroValue();
                        }
                    }
                }
            }
        }
    }

    public String getClassName(){
        return this.matrix[0][0].getClassName();
    }

    public int getRowCount(){
        return this.matrix.length;
    }

    public int getColumnCount(){
        return this.matrix[0].length;
    }

    public void pushData(int row, int col, NumberClass data) throws MathError {
        if((row >= this.getRowCount()) || (col >= this.getColumnCount()) || (row < 0) || (col < 0)){
            throw new MathError(MathError.WRONG_PARAMETERS + " the given row | col in out of bound");
        }
        if(!this.getClassName().equals(data.getClassName())){
            throw new MathError(MathError.INCORRECT_ARGUMENTS);
        }
        this.matrix[row][col] = (NumberClass) data.Clone();
    }

    public Matrix<T> mul(RealNumbers sFactor, boolean writeBack) throws MathError {
        int rows = this.getRowCount();
        int cols = this.getColumnCount();
        if(writeBack){
            for(int r = 0; r < rows; r++){
                for(int c = 0; c < cols; c++){
                    this.matrix[r][c].mul(sFactor);
                }
            }
            return this;
        }else{
            Matrix<T> ans = new Matrix<>(rows, cols, Matrix.NO_OPERATIONS, this.matrix[0][0]);
            for(int r = 0; r < rows; r++){
                for(int c = 0; c < cols; c++){
                    ans.matrix[r][c] = (NumberClass) this.matrix[r][c].mul(sFactor);
                }
            }
            return ans;
        }
    }

}
