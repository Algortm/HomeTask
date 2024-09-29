package module11.task2;

import java.util.Arrays;
import java.util.List;

public class SortName {
    final static List<String> NAME_LIST = Arrays.asList("Tom", "Mike", "Thomas", "Tim", "Jackson", "Olaf", "Alice");

    public static void main(String[] args) {
        List<String> result = NAME_LIST.stream()
                .sorted()
                .map(String::toUpperCase)
                .toList();
        System.out.println(result);
    }
}
