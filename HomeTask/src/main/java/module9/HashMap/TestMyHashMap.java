package module9.HashMap;

public class TestMyHashMap {
    public static void main(String[] args) {
        MyHashMap test = new MyHashMap();
        test.put("Тестовий", "тест");
        System.out.println(test.get("Тестовий"));
        test.put(1, "Перший");
        test.put(2, "Другий");
        test.put(3, "Третій");
        test.remove(2);
        System.out.println(test.get(1));
        System.out.println(test.size());
        test.clear();
        System.out.println(test.size());


    }
}
