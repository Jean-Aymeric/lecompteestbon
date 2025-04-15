package com.jad.numbersaddup.formula;

public class NumberElement implements FormulaElement {
    private final int value;

    public NumberElement(final int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return this.value;
    }

    @Override
    public String getOperation() {
        return String.valueOf(this.value);
    }

    @Override
    public String toString() {
        return this.getOperation();
    }
}
