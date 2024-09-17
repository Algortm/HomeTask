package module9.ArrayList;


import java.util.StringJoiner;

public class MyArrayList<T> {
    // add() додає елемент в кінець;
    // remove(int index) видаляє елемент із вказаним індексом
    // clear() очищає колекцію
    // size() повертає розмір колекції
    // get(int index) пове
    private static final int DEFAULT_SIZE_ARRAY = 10;
    private Object[] dataArray = new Object[DEFAULT_SIZE_ARRAY];
    private int index = 0;

    public void add(T value){
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

    public T get(int num){
        if(num<0||num>=index){
            System.out.println("Такого індекса в масиві немає");
            return (T) "-1";
        }else{
            return (T) dataArray[num];
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

    public void clear(){

        for(int i = 0;i<index;i++){
            dataArray[i]=null;
        }
        index=0;
    }
}
