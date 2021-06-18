package Mathamatics.Numbers;

import utility.MathError;
import Mathamatics.Numbers.ComplexNumber;

public class Float extends NumberClass implements NumberSystem,RealNumbers{

    private float num;

    public Float()
    {
        num = 0.0f;
    }

    public Float(float num)
    {
        this.num = num;
    }

    public Float(int num)
    {
        this.num = (float)num;
    }

    public Float(double num)
    {
        this.num = (float)num;
    }

    public Float(long num)
    {
        this.num = (float)num;
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
        return new Float(this.num + temp.getAsFloat());
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
            this.num += temp.getAsFloat();
            return this;
        }
        return new Float(this.num + temp.getAsFloat());
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
        return new Float(this.num - temp.getAsFloat());
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
            this.num -= temp.getAsFloat();
            return this;
        }
        return new Float(this.num - temp.getAsFloat());
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
        return new Float(this.num * temp.getAsFloat());
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
            this.num *= temp.getAsFloat();
            return this;
        }
        return new Float(this.num * temp.getAsFloat());
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
        if(temp.getAsFloat() == 0.0f){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        return new Float(this.num / temp.getAsFloat());
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
        if(temp.getAsFloat() == 0.0f){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        if(writeBack){
            this.num /= temp.getAsFloat();
            return this;
        }else{
            return new Float(this.num / temp.getAsFloat());
        }
    }

    @Override
    public NumberSystem inv() {
        return new Float(this.num * -1.0f);
    }

    @Override
    public NumberSystem inv(boolean writeBack) {
        if(writeBack){
            this.num *= -1.0f;
            return this;
        }else{
            return new Float(this.num * -1.0f);
        }
    }

    @Override
    public NumberSystem Clone() {
        return new Float(this.num);
    }

    @Override
    public NumberSystem getZeroValue() {
        return new Float();
    }

    @Override
    public NumberSystem getUnitValue() {
        return new Float( 1.0f);
    }

    @Override
    public String getClassName() {
        return Float.class.getName();
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
        return (int)this.num;
    }

    @Override
    public long getAsLong() {
        return (long)this.num;
    }
}
