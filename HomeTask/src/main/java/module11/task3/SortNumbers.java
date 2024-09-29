package module11.task3;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class SortNumbers {
    final static List<Integer> NUMBERS_LIST = Arrays.asList(5, 0 , 6 ,2 ,4, 1, 3);
    public static void main(String[] args) {
        String result = NUMBERS_LIST.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(","));


        System.out.println(result);
    }
}
