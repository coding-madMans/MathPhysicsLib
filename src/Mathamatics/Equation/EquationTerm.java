package Mathamatics.Equation;

import Mathamatics.NumberArray;
import Mathamatics.Numbers.RealNumbers;
import utility.MathError;

import static Mathamatics.BasicFormulas.Func.Pow;

public class EquationTerm<C extends RealNumbers, P extends RealNumbers> {

    private final RealNumbers[] powers;
    private final RealNumbers coefficient;

    public EquationTerm(C coefficient, P[] powers) throws MathError {
        if((powers == null) || (coefficient == null)){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        this.coefficient = coefficient.Clone();
        this.powers = powers.clone();
    }

    public EquationTerm(C coefficient, NumberArray<P> powers) throws MathError {
        if((powers == null) || (coefficient == null)){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        this.coefficient = coefficient.Clone();
        this.powers = new RealNumbers[powers.getLength()];
        for(int i = 0; i < this.powers.length; i++){
            this.powers[i] = powers.get(i);
        }
    }

    public RealNumbers getCoefficient(){
       return this.coefficient.Clone();
    }

    public RealNumbers[] getPowers() {
        return this.powers.clone();
    }

    public RealNumbers solve(RealNumbers[] values) throws MathError {
        if(values == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        if(this.powers.length != values.length){
            throw new MathError(MathError.INCORRECT_ARGUMENT_SIZE);
        }
        RealNumbers ans = (RealNumbers) values[0].getUnitValue().mul(this.coefficient);
        for(int i = 0; i < this.powers.length; i++){
            ans.mul(Pow(values[i], this.powers[i]), true);
        }
        return ans;
    }
}
