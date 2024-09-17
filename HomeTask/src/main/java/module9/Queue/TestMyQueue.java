package module9.Queue;

public class TestMyQueue<T> {
    public static void main(String[] args) {
        MyQueue<Integer> testArr = new MyQueue<>();
        System.out.println("--------------------");
        // ТЕСТ add()
        for(int i=0; i<20; i++){
            testArr.add(i);
        }
        System.out.println("Check add(): "+testArr.toString());
        System.out.println("--------------------");
        // ТЕСТ peek()
        System.out.println("Check peek(): "+testArr.peek());
        System.out.println(testArr.toString());
        System.out.println("--------------------");
        // ТЕСТ poll()
        System.out.println("Check poll(): "+testArr.poll());
        System.out.println(testArr.toString());
        System.out.println("--------------------");
        // ТЕСТ clear()
        testArr.clear();
        System.out.println("Check clear(): "+testArr.toString());
        System.out.println("--------------------");
        // ТЕСТ size()
        System.out.println("Check size(): "+testArr.size());
        System.out.println("--------------------");
    }









}
