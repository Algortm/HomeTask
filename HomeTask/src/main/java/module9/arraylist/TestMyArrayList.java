package module9.arraylist;

public class TestMyArrayList {
    public static void main(String[] args) {
        System.out.println("--------------------");
        // Тест add()
        MyArrayList<Integer> testArray = new MyArrayList<>();
        for (int i = 0; i < 14; i++) {
            testArray.add(i);
        }
        System.out.println("toString test Array: "+testArray);
        System.out.println("--------------------");
        // Тест size()
        System.out.println("Size: "+testArray.size());
        System.out.println("--------------------");

        // Тест get()
        System.out.println("Get of valid index: "+testArray.get(13));
        System.out.println("Get of invalid index: "+testArray.get(-13));
        System.out.println("Get of invalid index: "+testArray.get(130));
        System.out.println("--------------------");

        // Тест remove()
        testArray.remove(0);
        System.out.println("Remove of index: "+testArray);
        System.out.println("--------------------");

       // Тест clear()
        System.out.println("Array before clear: "+testArray);
        testArray.clear();
        System.out.println("Array after clear: "+testArray);
        System.out.println("--------------------");
        
    }
}
