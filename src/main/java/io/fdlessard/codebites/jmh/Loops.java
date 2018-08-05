package io.fdlessard.codebites.jmh;

import java.util.Iterator;
import java.util.List;

public class Loops {


    public static long sumArrayForLoopPrimitive(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        long sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }

        return sum;
    }

    public static long sumArrayForLoopWrapper(Integer[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        long sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }

        return sum;
    }

    public static long sumListForLoop(List<Integer> numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        long sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            sum = sum + numbers.get(i);
        }

        return sum;
    }

    public static long sumListForEach(List<Integer> numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        long sum = 0;

        for (Integer number : numbers) {
            sum = sum + number;
        }

        return sum;
    }

    public static long sumListIterator(List<Integer> numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        long sum = 0;

        for (Iterator<Integer> iter = numbers.iterator(); iter.hasNext(); ) {
            sum = sum + iter.next();
        }

        return sum;
    }

    public static long sumListStream(List<Integer> numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        return numbers.stream()
                .mapToInt(o -> o.intValue())
                .sum();
    }
}
