package module9.hashmap;

public class MyHashMap {
//    put(Object key, Object value) додає пару ключ + значення
//    remove(Object key) видаляє пару за ключем
//    clear() очищає колекцію
//    size() повертає розмір колекції
//    get(Object key) повертає значення (Object value) за ключем
    public static final int DEFAULT_SIZE_HASH_TABLE = 16;
    private int size = 0;
    private Node [] tab = new Node[DEFAULT_SIZE_HASH_TABLE];

    class Node<K, V>{
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        public Node(int hash, K key, V value, Node<K,V> next){
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public<K, V> void put(K key, V value){
        int hash = key.hashCode();
        int indexOfHashTable = (16-1)&hash;
        if(tab[indexOfHashTable]==null){
            Node<K,V> node = new Node<>(hash,key, value, null);
            tab[indexOfHashTable] = node;
        }else{
            Node<K,V> node = new Node<>(hash,key, value, null);
            Node<K,V> e = tab[indexOfHashTable];
            while(e.next!=null){
                e = e.next;
            }
            e.next = node;

        }
        size++;
    }

    public<K,V> Object get(K key){
        int hash = key.hashCode();
        int indexOfHashTable = (16-1)&hash;
        if(tab[indexOfHashTable]==null){
            System.out.println("Такий ключ відсутній");
            return null;
        }else{
            Node<K,V> e = tab[indexOfHashTable];
            if(e.hash == hash && (e.key == key || (key != null && key.equals(e.key)))){
                return e.value;
            }do{
                if(e.next.hash == hash && (e.next.key == key || (key != null && key.equals(e.next.key)))){
                    return e.next.value;
                }
            } while((e = e.next)!=null);


        }
        System.out.println("Такий ключ відсутній");
        return null;
    }
    public void clear() {

        if (tab  != null && size > 0){
            size = 0;
            for (int i = 0; i < tab.length; ++i)
                tab[i] = null;
        }
    }

    public<K,V> void remove(K key){
        int hash = key.hashCode();
        int indexOfHashTable = (16-1)&hash;
        if(tab[indexOfHashTable]==null){
            System.out.println("Такий ключ відсутній");
            return;
        }else{
            Node<K,V> e = tab[indexOfHashTable];
            if(e.hash == hash && (e.key == key || (key != null && key.equals(e.key)))){
                tab[indexOfHashTable] = e.next;
                e = null;
                size--;
                return;
            }do{
                if(e.next.hash == hash && (e.next.key == key || (key != null && key.equals(e.next.key)))){
                    e.next = null;
                    size--;
                    return;
                }
            } while((e = e.next)!=null);


        }
        System.out.println("Такий ключ відсутній");
        return;

    }
    public int size(){
        return size;
    }


}
