package com.jad;

import com.jad.numbersaddup.draw.NumberCollection;
import com.jad.numbersaddup.formula.FormulaElement;
import com.jad.numbersaddup.formula.NumberElement;
import com.jad.numbersaddup.formula.Operation;
import com.jad.numbersaddup.formula.OperationElement;

import java.util.List;

public enum Main {
    ;

    public static void main(String[] args) {
        FormulaElement formula =
                new OperationElement(
                        new OperationElement(
                                new NumberElement(10),
                                Operation.PLUS,
                                new NumberElement(2)
                        ),
                        Operation.MULTIPLY,
                        new OperationElement(
                                new OperationElement(
                                        new NumberElement(3),
                                        Operation.PLUS,
                                        new NumberElement(4)
                                ),
                                Operation.DIVIDE,
                                new OperationElement(
                                        new NumberElement(4),
                                        Operation.MINUS,
                                        new NumberElement(5)
                                )
                        )
                );
        //System.out.println("Formule: " + formula.getOperation() + " = " + formula.evaluate());
        List<NumberElement> draws = NumberCollection.getRandomNumbers(6);
        int goal = NumberCollection.getGoalNumber();
        System.out.print("Tirage : ");
        for (NumberElement number : draws) {
            System.out.print(number.evaluate() + " ");
        }
        System.out.println("\nObjectif : " + goal);
    }

}