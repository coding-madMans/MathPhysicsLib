package Mathamatics.Numbers;

import utility.MathError;

public class PolarNumber extends NumberClass implements  NumberSystem{

    private double radius, angle;

    public PolarNumber(){
        this.radius = 0.0;
        this.angle = 0.0;
    }

    public PolarNumber(double radius, double angle){
        this.radius = radius;
        this.angle = angle;
    }

    public PolarNumber(float radius, float angle){
        this.radius = radius;
        this.angle = angle;
    }

    public PolarNumber(int radius, int angle){
        this.radius = radius;
        this.angle = angle;
    }

    public PolarNumber(long radius, long angle){
        this.radius = radius;
        this.angle = angle;
    }

    @Override
    protected String repr() {
        return this.radius + " + r " + this.angle;
    }

    @Override
    public NumberSystem add(NumberSystem other) throws MathError {
        return this.add(other, false);
    }

    @Override
    public NumberSystem add(NumberSystem other, boolean writeBack) throws MathError {
        return null;
    }

    @Override
    public NumberSystem sub(NumberSystem other) throws MathError {
        return this.sub(other, false);
    }

    @Override
    public NumberSystem sub(NumberSystem other, boolean writeBack) throws MathError {
        return null;
    }

    @Override
    public NumberSystem mul(NumberSystem other) throws MathError {
        return this.mul(other, false);
    }

    @Override
    public NumberSystem mul(NumberSystem other, boolean writeBack) throws MathError {
        return null;
    }

    @Override
    public NumberSystem div(NumberSystem other) throws MathError {
        return this.div(other, false);
    }

    @Override
    public NumberSystem div(NumberSystem other, boolean writeBack) throws MathError {
        return null;
    }

    @Override
    public NumberSystem inv() {
        return this.inv(false);
    }

    @Override
    public NumberSystem inv(boolean writeBack) {
        return null;
    }

    @Override
    public NumberSystem Clone() {
        return new PolarNumber(this.radius, this.angle);
    }

    @Override
    public NumberSystem getZeroValue() {
        return new PolarNumber();
    }

    @Override
    public NumberSystem getUnitValue() {
        return new PolarNumber(1.0f, 1.0f);
    }

    @Override
    public String getClassName() {
        return null;
    }
}
