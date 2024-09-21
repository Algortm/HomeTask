package module9.linkedlist;

import java.util.StringJoiner;

public class MyLinkedList<T> {
//    add(Object value) додає елемент в кінець
//    remove(int index) видаляє елемент із вказаним індексом
//    clear() очищає колекцію
//    size() повертає розмір колекції
//    get(int index) повертає елемент за індексом
    private int size=0;
    private Node first;
    private Node last;
private static class Node{
    Object value;
    Node next;
    Node previous;
    public <T> Node(T value){
        this.value = value;
    }
}
public void add(T obj){
    Node newNode = new Node(obj);
    if(first==null){
        first = newNode;
        last = newNode;
        newNode.next=null;
        newNode.previous=null;
    }else{
        last.next = newNode;
        newNode.previous = last;
        last=newNode;
    }
    size++;
    }
    public int size(){
        return size;
    }
    @Override
    public String toString(){
        if(size == 0){
            return "[]";
        }else{
            StringJoiner textList = new StringJoiner(", ");
            Node obj = first;
            textList.add(String.valueOf(obj.value));
            for(int i=0; i<size-1;i++){
                obj = obj.next;
                textList.add(String.valueOf(obj.value));
            }
            return "["+textList+"]";
        }

    }
    public Node findIndex(int index){
        Node obj = first;
        if (index < 0 || index >= size) {
            System.out.println("Введіть коректний індекс");
            return null;
        } else {
            for(int i = 0; i < index - 1; i++) {
                obj = obj.next;
            }
            return obj;
        }
    }
    public T get(int index) {
        Node obj  = findIndex(index);
        if(obj == null){
            System.out.println("Введіть коректний індекс");
            return null;
        }else{
            return (T) obj.value;
        }
    }
    public void remove(int index){
        Node removeObj = findIndex(index);
        if(removeObj.previous==null){
            Node obj = removeObj.next;
            obj.previous = null;
        }else if(removeObj.next==null){
            Node obj = removeObj.previous;
            obj.next = null;
        }else{
            Node obj = removeObj.previous;
            obj.next = removeObj.next;
        }
        size--;
    }
    public void clear(){
        Node obj = first;
        for(int i = 0; i < size - 1; i++) {

            obj = obj.next;
            obj.previous = null;
        }
        first = null;
        last = null;
        size=0;
    }
}
