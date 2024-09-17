package module9.Stack;

public class TestMyStack {
    public static void main(String[] args) {
        MyStack<Integer> testArray = new MyStack<>();
        //ТЕСТ push()
        System.out.println("-----------------");
        for(int i=0; i<15; i++){
            testArray.push(i);
        }
        System.out.println("Check push(): "+testArray.toString());

        //ТЕСТ pop()
        System.out.println("-----------------");
        System.out.println(testArray.pop());
        System.out.println(testArray.pop());
        System.out.println(testArray.pop());
        System.out.println("Check pop(): "+testArray.toString());

        //ТЕСТ remove()
        System.out.println("-----------------");
        testArray.remove(6);
        System.out.println("Check remove(): "+testArray.toString());

        //ТЕСТ peek()
        System.out.println("-----------------");
        System.out.println("Check peek(): "+testArray.peek());

        //ТЕСТ size()
        System.out.println("-----------------");
        System.out.println("Check size(): "+testArray.size());
    }
}
