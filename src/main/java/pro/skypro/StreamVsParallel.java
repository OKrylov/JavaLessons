package pro.skypro;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@OperationsPerInvocation(StreamVsParallel.N)
public class StreamVsParallel {
    public static final int N = 100;

    static List<Integer> sourceList = new ArrayList<>();
    static {
        for (int i = 0; i < N; i++) {
            sourceList.add(i);
        }
    }

    @Benchmark
    public int stream() {
        return Stream.iterate(1, a -> a + 1)
                .limit(1_000_000)
                .reduce(0, Integer::sum);
    }

    @Benchmark
    public int parallelStream() {
        return Stream.iterate(1, a -> a + 1)
                .limit(1_000_000)
                .parallel()
                .reduce(0, Integer::sum);
    }
}