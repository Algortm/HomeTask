package module11.task5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MixStreamArray{
    final static List<String> FIRST_ARRAY = Arrays.asList("Tom_f", "Mike_f", "Thomas_f", "Tim_f", "Jackson_f", "Olaf_f", "Alice_f");
    final static List<String> SECOND_ARRAY = Arrays.asList("Mike_s", "Tim_s", "Jackson_s", "Olaf_s", "Alice_s");
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        List<T> firstList = first.toList();
        List<T> secondList = second.toList();
        int maxSize = Math.max(firstList.size(), secondList.size());
        return Stream.iterate(0, i -> i + 1)
                .limit(maxSize)
                .flatMap(i -> Stream.of(
                        i < firstList.size() ? firstList.get(i) : null,
                        i < secondList.size() ? secondList.get(i) : null
                ))
                .filter(names -> names != null);
    }
    public static void main(String[] args) {
        Stream<String> result = zip(FIRST_ARRAY.stream(), SECOND_ARRAY.stream());
        System.out.println(result.toList());
    }
}
