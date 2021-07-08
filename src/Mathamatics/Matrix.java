
/*
 * written by Vasu.Subbannavar
 * data : 16/06/2021
 */

package Mathamatics;

import Mathamatics.Numbers.NumberClass;
import Mathamatics.Numbers.RealNumbers;
import Mathamatics.Vectors.Vectors;
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

    private final NumberClass[][] matrix;

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

    public Matrix<T> mul(RealNumbers sFactor) throws MathError {
        return this.mul(sFactor, false);
    }

    public Matrix<T> mul(RealNumbers sFactor, boolean writeBack) throws MathError {
        int rows = this.getRowCount();
        int cols = this.getColumnCount();
        if(writeBack){
            for(int r = 0; r < rows; r++){
                for(int c = 0; c < cols; c++){
                    this.matrix[r][c].mul(sFactor, true);
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

    public Vectors mul(Vectors vector) throws MathError {
        if(vector == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(this.getColumnCount() != vector.getLength()){
            throw new MathError(MathError.INCORRECT_ARGUMENT_SIZE);
        }
        int row = this.getRowCount();
        int col = this.getColumnCount();
        Vectors ansVector = Vectors.zeros(vector.getClassName(), vector.getLength());
        int ansI = 0;
        NumberClass temp;
        for(int r = 0; r < row; r++){
            temp = ansVector.getDataIndex(ansI);
            for(int c = 0; c < col; c++){
                temp.add(this.matrix[r][c].mul(vector.getDataIndex(c)));
            }
            ansVector.pushDataIndex(ansI, temp);
            ansI += 1;
        }
        return ansVector;
    }

    public String repr(){
        int row = this.getRowCount();
        int col = this.getColumnCount();
        StringBuilder info = new StringBuilder("[");
        for(int r = 0; r < row; r++){
            if(r != 0){
                info.append(" ");
            }
            info.append("[");
            for(int c = 0; c < col; c++){
                info.append(this.matrix[r][c].repr());
                if((c + 1) != col){
                    info.append(", ");
                }
            }
            if((r + 1) != row){
                info.append("]\n");
            }else{
                info.append("]]\n");
            }
        }
        return info.toString();
    }

    public interface ForEach{
        void run(NumberClass ele);
    }

    public Matrix<T> forEach(ForEach func){
        for(NumberClass[] arr : this.matrix){
            for(NumberClass ele : arr){
                func.run(ele);
            }
        }
        return this;
    }

    public interface Map{
        boolean run(NumberClass self, NumberClass mapVar);
    }

    public boolean[][] map(Map mapFunc, NumberClass mapVar){
        boolean[][] map = new boolean[this.getRowCount()][this.getColumnCount()];
        for(int r = 0; r < this.getRowCount(); r++){
            for(int c = 0; c < this.getColumnCount(); c++){
                map[r][c] = mapFunc.run(this.matrix[r][c], mapVar);
            }
        }
        return map;
    }

}
