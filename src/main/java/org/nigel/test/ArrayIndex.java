package org.nigel.test;

import java.util.ArrayList;

public class ArrayIndex {
    static void main() {
        ArrayList<String> testArray = new ArrayList<>();
        testArray.add("cat");
        testArray.add("dog");
        testArray.add("pig");
        testArray.add("fish");
        testArray.add("bird");
        testArray.add("rat");
        testArray.add("bat");

        System.out.println(ArrayTest(testArray, 2));
    }

    static String ArrayTest(ArrayList<String> Arr, int ChosenIndex) {
        return Arr.get(ChosenIndex - 1);
    }
}
