package com.jad.numbersaddup;

public class NumberElement extends AbstractFormulaElement {
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
}
