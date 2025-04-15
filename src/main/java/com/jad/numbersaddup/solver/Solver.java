package com.jad.numbersaddup.solver;

import com.jad.numbersaddup.formula.FormulaElement;
import com.jad.numbersaddup.formula.NumberElement;
import com.jad.numbersaddup.formula.Operation;
import com.jad.numbersaddup.formula.OperationElement;

import java.util.ArrayList;
import java.util.List;

public class Solver {
    private final List<NumberElement> numbers;
    private final int goal;
    private FormulaElement bestFormula = null;
    private int delta = Integer.MAX_VALUE;

    public Solver(final List<NumberElement> numbers, final int goal) {
        this.numbers = numbers;
        this.goal = goal;
    }

    public FormulaElement solve() {
        this.solve(new ArrayList<>(this.numbers), this.goal);
        if (this.bestFormula != null) return this.bestFormula;
        return null;
    }

    private boolean solve(final List<FormulaElement> numbers, final int goal) {
        if (numbers.size() == 1) return false;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                FormulaElement number = numbers.get(i);
                FormulaElement other = numbers.get(j);
                if (number != other) {
                    for (Operation operation : Operation.values()) {
                        List<FormulaElement> newNumbers = this.getRemainingNumbers(numbers, number, other);
                        FormulaElement formula = new OperationElement(number, operation, other);
                        if (this.checkFormula(goal, formula)) return true;
                        newNumbers.add(formula);
                        if (this.solve(newNumbers, goal)) return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkFormula(final int goal, final FormulaElement formula) {
        int result = formula.evaluate();
        if (result == goal) {
            this.bestFormula = formula;
            return true;
        }
        if (result != -1 && (Math.abs(goal - result) < this.delta)) {
            this.bestFormula = formula;
            this.delta = Math.abs(goal - result);

        }
        return false;
    }

    private List<FormulaElement> getRemainingNumbers(final List<FormulaElement> numbers,
                                                     final FormulaElement number,
                                                     final FormulaElement other) {
        List<FormulaElement> newNumbers = new ArrayList<>(numbers);
        newNumbers.remove(number);
        newNumbers.remove(other);
        return newNumbers;
    }
}
