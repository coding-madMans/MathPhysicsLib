package Mathamatics.Numbers;
import utility.MathError;
public class Long extends NumberClass implements NumberSystem,RealNumbers {
    private long num;
    public Long(){
        num = 0L;
    }
    public Long(int num){
        this.num = (long)num;
    }
    public Long(float num){
        this.num = (long) num;
    }
    public Long(double num){
        this.num = (long) num;
    }
    public Long(long num){
        this.num = num;
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
        return new Long(this.num + temp.getAsLong());
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
            this.num += temp.getAsLong();
            return this;
        }
        return new Long(this.num + temp.getAsLong());
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
        return new Long(this.num - temp.getAsLong());
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
            this.num -= temp.getAsLong();
            return this;
        }
        return new Long(this.num - temp.getAsLong());
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
        return new Long(this.num * temp.getAsLong());
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
            this.num *= temp.getAsLong();
            return this;
        }
        return new Long(this.num * temp.getAsLong());
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
        if(temp.getAsLong() == 0L){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        return new Long(this.num / temp.getAsLong());
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
        if(temp.getAsLong() == 0L){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        if(writeBack){
            this.num /= temp.getAsLong();
            return this;
        }else{
            return new Long(this.num / temp.getAsLong());
        }
    }

    @Override
    public NumberSystem inv() {
        return new Long(this.num * -1L);
    }

    @Override
    public NumberSystem inv(boolean writeBack) {
        if(writeBack){
            this.num *= -1;
            return this;
        }else{
            return new Long(this.num * -1L);
        }
    }

    @Override
    public NumberSystem Clone() {
        return new Long(this.num);
    }

    @Override
    public NumberSystem getZeroValue() {
        return new Long();
    }

    @Override
    public NumberSystem getUnitValue() {
        return new Long( 1L);
    }

    @Override
    public String getClassName() {
        return Long.class.getName();
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
        return this.num;
    }
}
