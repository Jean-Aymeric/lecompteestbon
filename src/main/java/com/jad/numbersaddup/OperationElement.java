package com.jad.numbersaddup;

public class OperationElement extends AbstractFormulaElement {

    private final Operation operation;
    private final AbstractFormulaElement left;
    private final AbstractFormulaElement right;

    public OperationElement(final AbstractFormulaElement left,
                            final Operation operation,
                            final AbstractFormulaElement right) {
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
