package io.fdlessard.codebites.jmh;

import java.util.Iterator;
import java.util.List;

public class Loops {


    public static long sumForLoop(List<Integer> numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        long sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            sum = sum + numbers.get(i);
        }

        return sum;
    }


    public static long sumForEach(List<Integer> numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        long sum = 0;

        for (Integer number : numbers) {
            sum = sum + number;
        }

        return sum;
    }

    public static long sumIterator(List<Integer> numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        long sum = 0;

        for (Iterator<Integer> iter = numbers.iterator(); iter.hasNext(); ) {
            sum = sum + iter.next();
        }

        return sum;
    }


    public static long sumStream(List<Integer> numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        return numbers.stream()
                .mapToInt(o -> o.intValue())
                .sum();
    }
}
