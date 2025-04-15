package com.jad;

import com.jad.numbersaddup.draw.NumberCollection;
import com.jad.numbersaddup.formula.FormulaElement;
import com.jad.numbersaddup.formula.NumberElement;
import com.jad.numbersaddup.solver.Solver;

import java.util.List;

public enum Main {
    ;

    public static void main(String[] args) {
        List<NumberElement> draws = NumberCollection.getRandomNumbers(6);
        int goal = NumberCollection.getGoalNumber();
        System.out.print("Tirage : ");
        for (NumberElement number : draws) {
            System.out.print(number.evaluate() + " ");
        }
        System.out.println("\nObjectif : " + goal);

        Solver solver = new Solver(draws, goal);
        FormulaElement bestFormula = solver.solve();
        if (bestFormula != null) {
            int result = bestFormula.evaluate();
            if (result == goal) {
                System.out.println("Formule trouvée : " + bestFormula.getOperation() + " = " + bestFormula.evaluate());
            } else {
                System.out.println(
                        "Meilleure formule trouvée : " + bestFormula.getOperation() + " = " + bestFormula.evaluate()
                                + ", delta = " + Math.abs(goal - result));
            }
        } else {
            System.out.println("Aucune formule trouvée.");
        }
    }

}