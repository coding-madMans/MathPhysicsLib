/*
 * written by Vasu.Subbannavar
 * data : 15/06/2021
 */

package Mathamatics.Numbers;

import utility.MathError;

public class ComplexNumber extends NumberClass implements NumberSystem{

    private double real, imaginary;

    public ComplexNumber(){
        this.real = 0.0;
        this.imaginary = 0.0;
    }

    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(float real, float imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(int real, int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(long real, long imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    protected String repr() {
        return this.real + " + i" + this.imaginary + " ";
    }

    @Override
    public NumberSystem add(NumberSystem other) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(!other.getClassName().equals(this.getClassName())){
            throw  new MathError(MathError.NON_INTRACTABLE_INTERACTION);
        }
        ComplexNumber temp = (ComplexNumber) other;
        return new ComplexNumber(this.real + temp.real, this.imaginary + temp.imaginary);
    }

    @Override
    public NumberSystem add(NumberSystem other, boolean writeBack) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(!other.getClassName().equals(this.getClassName())){
            throw  new MathError(MathError.NON_INTRACTABLE_INTERACTION);
        }
        ComplexNumber temp = (ComplexNumber) other;
        if(writeBack){
            this.real += temp.real;
            this.imaginary += temp.imaginary;
            return this;
        }
        return new ComplexNumber(this.real + temp.real, this.imaginary + temp.imaginary);
    }

    @Override
    public NumberSystem sub(NumberSystem other) throws MathError {
        if(!other.getClassName().equals(this.getClassName())){
            throw  new MathError(MathError.NON_INTRACTABLE_INTERACTION);
        }
        ComplexNumber temp = (ComplexNumber) other;
        return new ComplexNumber(this.real - temp.real, this.imaginary - temp.imaginary);
    }

    @Override
    public NumberSystem sub(NumberSystem other, boolean writeBack) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(!other.getClassName().equals(this.getClassName())){
            throw  new MathError(MathError.NON_INTRACTABLE_INTERACTION);
        }
        ComplexNumber temp = (ComplexNumber) other;
        if(writeBack){
            this.real -= temp.real;
            this.imaginary -= temp.imaginary;
            return this;
        }
        return new ComplexNumber(this.real - temp.real, this.imaginary - temp.imaginary);
    }

    @Override
    public NumberSystem mul(NumberSystem other) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(!other.getClassName().equals(this.getClassName())){
            throw  new MathError(MathError.NON_INTRACTABLE_INTERACTION);
            // as of now this part is true..
        }
        ComplexNumber temp = (ComplexNumber) other;
        return new ComplexNumber((this.real * temp.real) - (this.imaginary * temp.imaginary),
                (this.real * temp.imaginary) + (this.imaginary * temp.real));
    }

    @Override
    public NumberSystem mul(NumberSystem other, boolean writeBack) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(!other.getClassName().equals(this.getClassName())){
            throw  new MathError(MathError.NON_INTRACTABLE_INTERACTION);
            // as of now this part is true..
        }
        ComplexNumber temp = (ComplexNumber) other;
        if(writeBack){
            this.real -= ((this.real * temp.real) - (this.imaginary * temp.imaginary));
            this.imaginary += ((this.real * temp.imaginary) + (this.imaginary * temp.real));
            return this;
        }else {
            return new ComplexNumber((this.real * temp.real) - (this.imaginary * temp.imaginary),
                    (this.real * temp.imaginary) + (this.imaginary * temp.real));
        }
    }

    @Override
    public NumberSystem div(NumberSystem other) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(!other.getClassName().equals(this.getClassName())){
            throw  new MathError(MathError.NON_INTRACTABLE_INTERACTION);
        }
        ComplexNumber temp = (ComplexNumber) other;
        double d = (temp.real * temp.real) + (temp.imaginary * temp.imaginary);
        if(d == 0.0){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        return new ComplexNumber((this.real * temp.real) / d, (this.imaginary * temp.imaginary) / d);
    }

    @Override
    public NumberSystem div(NumberSystem other, boolean writeBack) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(!other.getClassName().equals(this.getClassName())){
            throw  new MathError(MathError.NON_INTRACTABLE_INTERACTION);
        }
        ComplexNumber temp = (ComplexNumber) other;
        double d = (temp.real * temp.real) + (temp.imaginary * temp.imaginary);
        if(d == 0.0){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        if(writeBack){
            this.real = ((this.real * temp.real) / d);
            this.imaginary = ((this.imaginary * temp.imaginary) / d);
            return this;
        }else{
            return new ComplexNumber((this.real * temp.real) / d, (this.imaginary * temp.imaginary) / d);
        }
    }

    @Override
    public NumberSystem inv() {
        return new ComplexNumber(this.real * -1.0, this.imaginary * -1.0);
    }

    @Override
    public NumberSystem inv(boolean writeBack) {
        if(writeBack){
            this.real *= -1;
            this.imaginary *= -1;
            return this;
        }else{
            return new ComplexNumber(this.real * -1.0, this.imaginary * -1.0);
        }
    }

    @Override
    public NumberSystem Clone() {
        return new ComplexNumber(this.real, this.imaginary);
    }

    @Override
    public NumberSystem getZeroValue() {
        return new ComplexNumber();
    }

    @Override
    public NumberSystem getUnitValue() {
        return new ComplexNumber(1.0f, 1.0f);
    }

    @Override
    public String getClassName() {
        return ComplexNumber.class.getName();
    }
}
