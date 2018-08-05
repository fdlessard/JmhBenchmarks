package io.fdlessard.codebites.jmh;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Measurement(iterations = 5)
@Warmup(iterations = 5)
@Fork(value = 5)
public class LoopsBenchmarks {

    private static final int arraySize = 1000;

    private static List<Integer> integers = new ArrayList<>();

    private static Integer[] integerWrapperArray;

    private static int[] integerPrimitiveArray;

    public static void main(String[] args) throws Exception {

        integerPrimitiveArray = new int[arraySize];
        integerWrapperArray = new Integer[arraySize];

        for (int i = 0; i < arraySize; i++) {
            integerPrimitiveArray[i] = i;
            integerWrapperArray[i] = Integer.valueOf(i);
            integers.add(Integer.valueOf(i));
        }

        org.openjdk.jmh.Main.main(args);
    }

/*    @Setup(Level.Trial)
    public synchronized void initialize() {
    }*/

    @Benchmark
    public void sumArrayForLoopPrimitive() {
        long sum = Loops.sumArrayForLoopPrimitive(integerPrimitiveArray);
    }

    @Benchmark
    public void sumArrayForLoopWrapper() {
        long sum = Loops.sumArrayForLoopWrapper(integerWrapperArray);
    }

    @Benchmark
    public void sumListForLoop() {
        long sum = Loops.sumListForLoop(integers);
    }

    @Benchmark
    public void sumListForEach() {
        long sum = Loops.sumListForEach(integers);
    }

    @Benchmark
    public void sumListIterator() {
        long sum = Loops.sumListIterator(integers);
    }

    @Benchmark
    public void sumListStream() {
        long sum = Loops.sumListStream(integers);
    }
}