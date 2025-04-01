package com.jad.numbersaddup.formula;

public class OperationElement implements FormulaElement {

    private final Operation operation;
    private final FormulaElement left;
    private final FormulaElement right;

    public OperationElement(final FormulaElement left,
                            final Operation operation,
                            final FormulaElement right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    @Override
    public int evaluate() {
        final int leftValue = this.left.evaluate();
        if (leftValue == -1) return -1;
        final int rightValue = this.right.evaluate();
        if (rightValue == -1) return -1;
        final float result = this.operation.apply(leftValue, rightValue);
        return (result == (int) result) ? (int) result : -1;
    }

    @Override
    public String getOperation() {
        return "(" + this.left.getOperation() + " " + this.operation.getSymbol() + " " + this.right.getOperation() + ")";
    }
}
