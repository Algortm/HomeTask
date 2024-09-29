package module11.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamIterate {
    final static long A = 25214903917L;
    final static long C = 11L;
    final static long M = (long) Math.pow(2L, 48);
    final static long SEED = 2L;
    public static Stream<Long> lineRandomGenerator(long seed, long A, long C, long M){

        return Stream.iterate(seed, x -> (A * x + C) % M);
    }
    public static void main(String[] args) {

        Stream<Long> results = lineRandomGenerator(SEED, A, C, M);
        results
                .limit(15)
                .forEach(i -> System.out.println(String.valueOf(i)));

    }
}
