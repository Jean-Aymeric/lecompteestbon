package com.jad.numbersaddup.solver;

import com.jad.numbersaddup.draw.NumberCollection;
import com.jad.numbersaddup.formula.FormulaElement;

import java.util.List;

public class Solver {
    private final List<NumberCollection> numbers;
    private final int goal;

    public Solver(final List<NumberCollection> numbers, final int goal) {
        this.numbers = numbers;
        this.goal = goal;
    }

    public FormulaElement solve() {
        return null;
    }
}
