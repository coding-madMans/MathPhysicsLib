package Mathamatics.Equation;

import Mathamatics.NumberArray;
import Mathamatics.Numbers.RealNumbers;
import utility.MathError;

import java.util.ArrayList;
import java.util.List;

public class Equation<C extends RealNumbers, P extends RealNumbers> {

    private final char[] variables;
    private List<EquationTerm<C, P>> equation;

    public Equation(char[] variables, int numberOfTerms) throws MathError {
        if(variables == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        this.variables = variables.clone();
        this.equation = new ArrayList<>(numberOfTerms);
    }

    public void insertTerm(C coefficient, P[] powers) throws MathError {
        if(powers.length != variables.length){
            throw new MathError(MathError.INCORRECT_ARGUMENT_SIZE);
        }
        this.equation.add(new EquationTerm<>(coefficient, powers));
    }

    public void insertTerm(C coefficient, NumberArray<P> powers) throws MathError {
        if(powers.getLength() != variables.length){
            throw new MathError(MathError.INCORRECT_ARGUMENT_SIZE);
        }
        this.equation.add(new EquationTerm<>(coefficient, powers));
    }

    public RealNumbers solve(RealNumbers[][] values) throws MathError {
        if(values == null){
            throw new MathError(MathError.NULL_POINTER_EXCEPTION);
        }
        RealNumbers ans;
        int i = 0;
        ans = this.equation.get(i).solve(values[i]);
        for(i += 1; i < this.equation.size(); i++){
            ans.add(this.equation.get(i).solve(values[i]), true);
        }
        return ans;
    }

    public String repr(){
        if(this.equation.size() == 0){
            return "";
        }
        StringBuilder eq = new StringBuilder();
        EquationTerm<C, P> e = this.equation.get(0);
        RealNumbers coff = e.getCoefficient();
        RealNumbers[] pow = e.getPowers();
        eq.append(coff.repr());
        for(int p = 0; p < this.variables.length; p++){
            eq.append('*').append(this.variables[p]).append('^').append(pow[p].repr());
        }
        if(this.equation.size() == 1){
            return eq.toString();
        }
        for(int i = 1; i < this.equation.size(); i++){
            e = this.equation.get(i);
            coff = e.getCoefficient();
            pow = e.getPowers();
            eq.append('+').append(coff.repr());
            for(int p = 0; p < this.variables.length; p++){
                eq.append('*').append(this.variables[p]).append('^').append(pow[p].repr());
            }
        }
        return eq.toString();
    }
}
