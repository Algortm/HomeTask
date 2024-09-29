package module11.task1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OddNameList {
    final static List<String> NAME_LIST = Arrays.asList("Tom", "Mike", "Thomas", "Tim", "Jackson", "Olaf", "Alice");
    public static void main(String[] args) {
        Map<Integer, String> results  = IntStream.range(0, NAME_LIST.size())
                .filter(i -> i % 2 != 0)
                .boxed()
                .collect(Collectors.toMap(i->i, NAME_LIST::get));
        results.forEach((index, value)->{System.out.println(index + ". " + value);});
    }
}
