package module9.linkedlist;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        System.out.println("--------------------");
        // ТЕСТ add()
        testList.add(1);
        testList.add(3);
        testList.add(7);
        for(int i=0; i<=5; i++){
            testList.add(i);
        }
        System.out.println("Check add():"+testList.toString());
        System.out.println("--------------------");
        // ТЕСТ size()
        System.out.println("Check size():"+testList.size());
        // ТЕСТ get()
        System.out.println("--------------------");
        System.out.println("Check get():"+String.valueOf(testList.get(6)));
        System.out.println("--------------------");
        // ТЕСТ remove()
        testList.remove(5);
        System.out.println("Check remove():"+testList.toString());
        System.out.println("Check size():"+testList.size());
        System.out.println("--------------------");
        // ТЕСТ clear()
        testList.clear();
        System.out.println(testList.toString());
        System.out.println("Check clear():"+testList.size());
        System.out.println("--------------------");


    }
}


