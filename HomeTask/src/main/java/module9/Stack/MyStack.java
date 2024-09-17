package module9.Stack;

import java.util.StringJoiner;

public class MyStack <T>{
//        push(Object value) додає елемент в кінець
//        remove(int index) видаляє елемент за індексом
//        clear() очищає колекцію
//        size() повертає розмір колекції
//        peek() повертає перший елемент стеку
//        pop() повертає перший елемент стеку та видаляє його з колекції

    private static final int DEFAULT_SIZE_LIST = 10;
    private Object[] dataArray = new Object[DEFAULT_SIZE_LIST];
    private int index = 0;

    public void push(T value){
        resize();
        dataArray[index] = value;
        index++;
    }

    private void resize(){
        if(index == dataArray.length-1){
            int size = index * 2;
            Object[] newDataArray = new Object[size];
            System.arraycopy(dataArray, 0, newDataArray,0, dataArray.length);
            dataArray = newDataArray;
        }
    }

    @Override
    public String toString(){
        StringJoiner result = new StringJoiner(", ");
        for(int i=0; i<index; i++){
            result.add(String.valueOf(dataArray[i]));
        }
        return "["+result.toString()+"]";
    }

    public int size(){
        return index;
    }

    public void clear(){

        for(int i = 0;i<index;i++){
            dataArray[i]=null;
        }
        index=0;
    }

    public T peek(){
        return (T) dataArray[index-1];
    }

    public T pop(){
        if (index == 0) {
            System.out.println("Колекція пуста");
            return (T) "-1";
        } else {
            T value = peek();
            int size = index - 1;

            if (size > 0) {
                System.arraycopy(dataArray, 0, dataArray, 0, size);
            }
            index--;
            return value;
        }
    }
    public void remove(int num){
        int size = index-1;
        if(num<0||num>=index){
            System.out.println("Такого індекса в масиві немає");
        }else{
            index--;
            System.arraycopy(dataArray, num+1, dataArray, num, size);

        }
    }
}
