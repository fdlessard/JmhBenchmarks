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

    private List<Integer> integers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    @Setup(Level.Trial)
    public synchronized void initialize() {

        for (int i = 0; i < arraySize; i++) {
            integers.add(Integer.valueOf(i));
        }
    }

    @Benchmark
    public void sumForLoop() {
        long sum = Loops.sumForLoop(integers);
    }

    @Benchmark
    public void sumForEach() {
        long sum = Loops.sumForEach(integers);
    }

    @Benchmark
    public void sumIterator/**/() {
        long sum = Loops.sumIterator(integers);
    }


    @Benchmark
    public void sumStream() {
        long sum = Loops.sumStream(integers);
    }
}