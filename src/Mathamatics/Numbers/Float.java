/*
 * written by Suprith Satish
 * data : 16/06/2021
 */

package Mathamatics.Numbers;

import utility.MathError;


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
    public String repr() {
        return this.num + "f ";
    }

    @Override
    public RealNumbers add(int value) {
        return new Double(this.num + value);
    }

    @Override
    public RealNumbers add(int value, boolean writeBack) {
        if(writeBack){
            this.num += value;
            return this;
        }else{
            return new Double(this.num + value);
        }
    }

    @Override
    public RealNumbers sub(int value) {
        return new Double(this.num - value);
    }

    @Override
    public RealNumbers sub(int value, boolean writeBack) {
        if(writeBack){
            this.num -= value;
            return this;
        }else{
            return new Double(this.num - value);
        }
    }

    @Override
    public RealNumbers mul(int value) {
        return new Double(this.num * value);
    }

    @Override
    public RealNumbers mul(int value, boolean writeBack) {
        if(writeBack){
            this.num *= value;
            return this;
        }else{
            return new Double(this.num * value);
        }
    }

    @Override
    public RealNumbers div(int value) throws MathError {
        if(value == 0){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        return new Double(this.num / value);
    }

    @Override
    public RealNumbers div(int value, boolean writeBack) throws MathError {
        if(value == 0){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        if(writeBack){
            this.num /= value;
            return this;
        }else{
            return new Double(this.num / value);
        }
    }

    @Override
    public boolean eql(int value) {
        return this.num == value;
    }

    @Override
    public RealNumbers add(float value) {
        return new Double(this.num + value);
    }

    @Override
    public RealNumbers add(float value, boolean writeBack) {
        if(writeBack){
            this.num += value;
            return this;
        }else{
            return new Double(this.num + value);
        }
    }

    @Override
    public RealNumbers sub(float value) {
        return new Double(this.num - value);
    }

    @Override
    public RealNumbers sub(float value, boolean writeBack) {
        if(writeBack){
            this.num -= value;
            return this;
        }else{
            return new Double(this.num - value);
        }
    }

    @Override
    public RealNumbers mul(float value) {
        return new Double(this.num * value);
    }

    @Override
    public RealNumbers mul(float value, boolean writeBack) {
        if(writeBack){
            this.num *= value;
            return this;
        }else{
            return new Double(this.num * value);
        }
    }

    @Override
    public RealNumbers div(float value) throws MathError {
        if(value == 0){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        return new Double(this.num / value);
    }

    @Override
    public RealNumbers div(float value, boolean writeBack) throws MathError {
        if(value == 0){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        if(writeBack){
            this.num /= value;
            return this;
        }else{
            return new Double(this.num / value);
        }
    }

    @Override
    public boolean eql(float value) {
        return this.num == value;
    }

    @Override
    public RealNumbers add(double value) {
        return new Double(this.num + value);
    }

    @Override
    public RealNumbers add(double value, boolean writeBack) {
        if(writeBack){
            this.num += value;
            return this;
        }else{
            return new Double(this.num + value);
        }
    }

    @Override
    public RealNumbers sub(double value) {
        return new Double(this.num - value);
    }

    @Override
    public RealNumbers sub(double value, boolean writeBack) {
        if(writeBack){
            this.num -= value;
            return this;
        }else{
            return new Double(this.num - value);
        }
    }

    @Override
    public RealNumbers mul(double value) {
        return new Double(this.num * value);
    }

    @Override
    public RealNumbers mul(double value, boolean writeBack) {
        if(writeBack){
            this.num *= value;
            return this;
        }else{
            return new Double(this.num * value);
        }
    }

    @Override
    public RealNumbers div(double value) throws MathError {
        if(value == 0){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        return new Double(this.num / value);
    }

    @Override
    public RealNumbers div(double value, boolean writeBack) throws MathError {
        if(value == 0){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        if(writeBack){
            this.num /= value;
            return this;
        }else{
            return new Double(this.num / value);
        }
    }

    @Override
    public boolean eql(double value) {
        return this.num == value;
    }

    @Override
    public RealNumbers add(long value) {
        return new Double(this.num + value);
    }

    @Override
    public RealNumbers add(long value, boolean writeBack) {
        if(writeBack){
            this.num += value;
            return this;
        }else{
            return new Double(this.num + value);
        }
    }

    @Override
    public RealNumbers sub(long value) {
        return new Double(this.num - value);
    }

    @Override
    public RealNumbers sub(long value, boolean writeBack) {
        if(writeBack){
            this.num -= value;
            return this;
        }else{
            return new Double(this.num - value);
        }
    }

    @Override
    public RealNumbers mul(long value) {
        return new Double(this.num * value);
    }

    @Override
    public RealNumbers mul(long value, boolean writeBack) {
        if(writeBack){
            this.num *= value;
            return this;
        }else{
            return new Double(this.num * value);
        }
    }

    @Override
    public RealNumbers div(long value) throws MathError {
        if(value == 0){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        return new Double(this.num / value);
    }

    @Override
    public RealNumbers div(long value, boolean writeBack) throws MathError {
        if(value == 0){
            throw new MathError(MathError.DIVISION_BY_ZERO_ERROR);
        }
        if(writeBack){
            this.num /= value;
            return this;
        }else{
            return new Double(this.num / value);
        }
    }

    @Override
    public boolean eql(long value) {
        return this.num == value;
    }

    @Override
    public NumberSystem add(NumberSystem other) throws MathError {
        return this.add(other, false);
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
        return this.sub(other, false);
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
        return this.mul(other, false);
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
        return this.div(other, false);
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
    public boolean eql(NumberSystem other) {
        Float temp = (Float) other;
        return this.num == temp.num;
    }

    @Override
    public boolean grater(NumberSystem other) {
        Float temp = (Float) other;
        return this.num > temp.num;
    }

    @Override
    public boolean less(NumberSystem other) {
        Float temp = (Float) other;
        return this.num < temp.num;
    }

    @Override
    public NumberSystem inv() {
        return this.inv(false);
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
