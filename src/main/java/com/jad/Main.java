package com.jad;

import com.jad.numbersaddup.AbstractFormulaElement;
import com.jad.numbersaddup.NumberElement;
import com.jad.numbersaddup.Operation;
import com.jad.numbersaddup.OperationElement;

public class Main {
    public static void main(String[] args) {
        AbstractFormulaElement formula =
                new OperationElement(
                        new NumberElement(3),
                        Operation.DIVIDE,
                        new OperationElement(
                                new NumberElement(4),
                                Operation.PLUS,
                                new NumberElement(5)
                        )
                );
        System.out.println("Formula: " + formula.getOperation() + " = " + formula.evaluate());
    }

}