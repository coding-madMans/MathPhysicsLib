package Mathamatics.Numbers;

import utility.MathError;

public class Double extends NumberClass implements NumberSystem,RealNumbers{

    private double num;

    public Double()
    {
        num = 0.0;
    }

    public Double(double num)
    {
        this.num = num;
    }

    public Double(int num)
    {
        this.num = (double)num;
    }

    public Double(float num)
    {
        this.num = (double)num;
    }

    public Double(long num)
    {
        this.num = (double)num;
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
        return new Double(this.num + temp.getAsDouble());
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
            this.num += temp.getAsDouble();
            return this;
        }
        return new Double(this.num + temp.getAsDouble());
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
        return new Double(this.num - temp.getAsDouble());
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
            this.num -= temp.getAsDouble();
            return this;
        }
        return new Double(this.num - temp.getAsDouble());
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
        return new Double(this.num * temp.getAsDouble());
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
            this.num *= temp.getAsDouble();
            return this;
        }
        return new Double(this.num * temp.getAsDouble());
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
        if(temp.getAsDouble() == 0.0f){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        return new Double(this.num / temp.getAsDouble());
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
        if(temp.getAsDouble() == 0.0){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        if(writeBack){
            this.num /= temp.getAsDouble();
            return this;
        }else{
            return new Double(this.num / temp.getAsDouble());
        }
    }

    @Override
    public NumberSystem inv() {
        return new Double(this.num * -1.0);
    }

    @Override
    public NumberSystem inv(boolean writeBack) {
        if(writeBack){
            this.num *= -1.0;
            return this;
        }else{
            return new Double(this.num * -1.0);
        }
    }

    @Override
    public NumberSystem Clone() {
        return new Double(this.num);
    }

    @Override
    public NumberSystem getZeroValue() {
        return new Double();
    }

    @Override
    public NumberSystem getUnitValue() {
        return new Double( 1.0);
    }

    @Override
    public String getClassName() {
        return Double.class.getName();
    }


    @Override
    public float getAsFloat() {
        return (float)this.num;
    }

    @Override
    public double getAsDouble() {
        return this.num;
    }

    @Override
    public int getAsInt() {
        return (int)this.num;
    }

    @Override
    public long getAsLong() {
        return (long)this.num;
    }
}