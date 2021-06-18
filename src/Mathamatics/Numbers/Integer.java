package Mathamatics.Numbers;

import utility.MathError;

public class Integer extends NumberClass implements NumberSystem,RealNumbers {
    private int num;

    public Integer(){
        num = 0;
    }
    public Integer(int num){
        this.num = num;
    }
    public Integer(float num){
        this.num = (int) num;
    }
    public Integer(double num){
        this.num = (int) num;
    }
    public Integer(long num){
        this.num = (int) num;
    }
    @Override
    protected String repr() {
        return this.num + " ";
    }

    @Override
    public NumberSystem add(NumberSystem other) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(other.getClassName().equals(ComplexNumber.class.getName())||other.getClassName().equals(PolarNumber.class.getName())){
            throw  new MathError(MathError.NON_INTRACTABLE_INTERACTION);
        }
        RealNumbers temp = (RealNumbers)other;
        return new Integer(this.num + temp.getAsInt());
    }

    @Override
    public NumberSystem add(NumberSystem other, boolean writeBack) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(other.getClassName().equals(ComplexNumber.class.getName())||other.getClassName().equals(PolarNumber.class.getName())){
            throw  new MathError(MathError.NON_INTRACTABLE_INTERACTION);
        }
        RealNumbers temp = (RealNumbers)other;
        if(writeBack){
            this.num += temp.getAsInt();
            return this;
        }
        return new Integer(this.num + temp.getAsInt());
    }

    @Override
    public NumberSystem sub(NumberSystem other) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(other.getClassName().equals(ComplexNumber.class.getName())||other.getClassName().equals(PolarNumber.class.getName())){
            throw  new MathError(MathError.NON_INTRACTABLE_INTERACTION);
        }
        RealNumbers temp = (RealNumbers)other;
        return new Integer(this.num - temp.getAsInt());
    }

    @Override
    public NumberSystem sub(NumberSystem other, boolean writeBack) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(other.getClassName().equals(ComplexNumber.class.getName())||other.getClassName().equals(PolarNumber.class.getName())){
            throw  new MathError(MathError.NON_INTRACTABLE_INTERACTION);
        }
        RealNumbers temp = (RealNumbers)other;
        if(writeBack){
            this.num -= temp.getAsInt();
            return this;
        }
        return new Integer(this.num - temp.getAsInt());
    }

    @Override
    public NumberSystem mul(NumberSystem other) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(other.getClassName().equals(ComplexNumber.class.getName())||other.getClassName().equals(PolarNumber.class.getName())){
            return other.mul(this);
        }
        RealNumbers temp = (RealNumbers)other;
        return new Integer(this.num * temp.getAsInt());
    }

    @Override
    public NumberSystem mul(NumberSystem other, boolean writeBack) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(other.getClassName().equals(ComplexNumber.class.getName())||other.getClassName().equals(PolarNumber.class.getName())){
            return other.mul(this,writeBack);
        }
        RealNumbers temp = (RealNumbers)other;
        if(writeBack){
            this.num *= temp.getAsInt();
            return this;
        }
        return new Integer(this.num * temp.getAsInt());
    }


    @Override
    public NumberSystem div(NumberSystem other) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(other.getClassName().equals(ComplexNumber.class.getName())||other.getClassName().equals(PolarNumber.class.getName())){
            return other.div(this);
        }
        RealNumbers temp = (RealNumbers)other;
        if(temp.getAsInt() == 0){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        return new Integer(this.num / temp.getAsInt());
    }

    @Override
    public NumberSystem div(NumberSystem other, boolean writeBack) throws MathError {
        if(other == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(other.getClassName().equals(ComplexNumber.class.getName())||other.getClassName().equals(PolarNumber.class.getName())){
            return other.div(this,writeBack);
        }
        RealNumbers temp = (RealNumbers)other;
        if(temp.getAsInt() == 0){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        if(writeBack){
            this.num /= temp.getAsInt();
            return this;
        }else{
            return new Integer(this.num / temp.getAsInt());
        }
    }

    @Override
    public NumberSystem inv() {
        return new Integer(this.num * -1);
    }

    @Override
    public NumberSystem inv(boolean writeBack) {
        if(writeBack){
            this.num *= -1;
            return this;
        }else{
            return new Integer(this.num * -1);
        }
    }

    @Override
    public NumberSystem Clone() {
        return new Integer(this.num);
    }

    @Override
    public NumberSystem getZeroValue() {
        return new Integer();
    }

    @Override
    public NumberSystem getUnitValue() {
        return new Integer( 1);
    }

    @Override
    public String getClassName() {
        return Integer.class.getName();
    }


    @Override
    public float getAsFloat() {
        return this.num;
    }

    @Override
    public double getAsDouble() {
        return this.num;
    }

    @Override
    public int getAsInt() {
        return this.num;
    }

    @Override
    public long getAsLong() {
        return this.num;
    }
}
