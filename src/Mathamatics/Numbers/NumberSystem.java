/*
* written by Vasu.Subbannavar
* data : 15/06/2021
*/

package Mathamatics.Numbers;

import utility.MathError;

public interface NumberSystem {
    NumberSystem add(NumberSystem other) throws MathError;
    NumberSystem add(NumberSystem other, boolean writeBack) throws MathError;
    NumberSystem sub(NumberSystem other) throws MathError;
    NumberSystem sub(NumberSystem other, boolean writeBack) throws MathError;
    NumberSystem mul(NumberSystem other) throws MathError;
    NumberSystem mul(NumberSystem other, boolean writeBack) throws MathError;
    NumberSystem div(NumberSystem other) throws MathError;
    NumberSystem div(NumberSystem other, boolean writeBack) throws MathError;
    boolean eql(NumberSystem other);
    boolean grater(NumberSystem other);
    boolean less(NumberSystem other);
    boolean lessEql(NumberSystem other);
    boolean greaterEql(NumberSystem other);

    NumberSystem inv();
    NumberSystem inv(boolean writeBack);
    NumberSystem Clone();

    NumberSystem getZeroValue();
    NumberSystem getUnitValue();

    String getClassName();
    String repr();
}
