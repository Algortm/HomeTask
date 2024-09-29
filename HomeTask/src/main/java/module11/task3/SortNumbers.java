package module11.task3;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class SortNumbers {
    final static List<Integer> NUMBERS_LIST = Arrays.asList(5, 0 , 6 ,2 ,4, 1, 3);
    public static void main(String[] args) {
        List<Integer> result = NUMBERS_LIST.stream()
                .sorted()
                .toList();

        StringJoiner txt = new StringJoiner(", ");
        for(Integer num: result){
            txt.add(String.valueOf(num));
        }
        System.out.println(txt);
    }
}
