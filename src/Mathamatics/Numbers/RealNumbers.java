/*
 * written by Suprith Satish
 * data : 16/06/2021
 */

package Mathamatics.Numbers;

import utility.MathError;

public interface RealNumbers extends NumberSystem{
    //RealNumbers getNumber();
    float getAsFloat();
    double getAsDouble();
    int getAsInt();
    long getAsLong();
    String repr();

    RealNumbers add(int value);
    RealNumbers add(int value, boolean writeBack);
    RealNumbers sub(int value);
    RealNumbers sub(int value, boolean writeBack);
    RealNumbers mul(int value);
    RealNumbers mul(int value, boolean writeBack);
    RealNumbers div(int value) throws MathError;
    RealNumbers div(int value, boolean writeBack) throws MathError;
    boolean eql(int value);

    RealNumbers add(float value);
    RealNumbers add(float value, boolean writeBack);
    RealNumbers sub(float value);
    RealNumbers sub(float value, boolean writeBack);
    RealNumbers mul(float value);
    RealNumbers mul(float value, boolean writeBack);
    RealNumbers div(float value) throws MathError;
    RealNumbers div(float value, boolean writeBack) throws MathError;
    boolean eql(float value);

    RealNumbers add(double value);
    RealNumbers add(double value, boolean writeBack);
    RealNumbers sub(double value);
    RealNumbers sub(double value, boolean writeBack);
    RealNumbers mul(double value);
    RealNumbers mul(double value, boolean writeBack);
    RealNumbers div(double value) throws MathError;
    RealNumbers div(double value, boolean writeBack) throws MathError;
    boolean eql(double value);

    RealNumbers add(long value);
    RealNumbers add(long value, boolean writeBack);
    RealNumbers sub(long value);
    RealNumbers sub(long value, boolean writeBack);
    RealNumbers mul(long value);
    RealNumbers mul(long value, boolean writeBack);
    RealNumbers div(long value) throws MathError;
    RealNumbers div(long value, boolean writeBack) throws MathError;
    boolean eql(long value);
}
