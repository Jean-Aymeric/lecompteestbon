package com.jad.numbersaddup;

public enum Operation {
    PLUS('+') {
        @Override
        float apply(final int left, final int right) {
            return left + right;
        }
    },
    MINUS('-') {
        @Override
        float apply(final int left, final int right) {
            return left - right;
        }
    },
    MULTIPLY('x') {
        @Override
        float apply(final int left, final int right) {
            return left * right;
        }
    },
    DIVIDE('/') {
        @Override
        float apply(final int left, final int right) {
            return ((float) left) / ((float) right);
        }
    };

    private final char symbol;

    Operation(final char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }

    abstract float apply(int left, int right);
}