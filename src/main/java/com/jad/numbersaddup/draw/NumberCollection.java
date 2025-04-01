package com.jad.numbersaddup.draw;

import com.jad.numbersaddup.formula.NumberElement;

import java.util.ArrayList;
import java.util.List;

public enum NumberCollection {
    NUMBER_1(new NumberElement(1)),
    NUMBER_2(new NumberElement(2)),
    NUMBER_3(new NumberElement(3)),
    NUMBER_4(new NumberElement(4)),
    NUMBER_5(new NumberElement(5)),
    NUMBER_6(new NumberElement(6)),
    NUMBER_7(new NumberElement(7)),
    NUMBER_8(new NumberElement(8)),
    NUMBER_9(new NumberElement(9)),
    NUMBER_10(new NumberElement(10)),
    NUMBER_25(new NumberElement(25)),
    NUMBER_50(new NumberElement(50)),
    NUMBER_75(new NumberElement(75)),
    NUMBER_100(new NumberElement(100));

    static final int GOAL_MIN = 101;
    static final int GOAL_MAX = 999;
    private final NumberElement numberElement;

    NumberCollection(final NumberElement numberElement) {
        this.numberElement = numberElement;
    }

    public static List<NumberElement> getRandomNumbers(final int count) {
        final List<NumberElement> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(NumberCollection.getRandomNumber());
        }
        return numbers;
    }

    private static NumberElement getRandomNumber() {
        final int randomIndex = (int) (Math.random() * NumberCollection.values().length);
        return NumberCollection.values()[randomIndex].numberElement;
    }

    public static int getGoalNumber() {
        return (int) (Math.random() * (NumberCollection.GOAL_MAX - NumberCollection.GOAL_MIN + 1)) + NumberCollection.GOAL_MIN;
    }
}
