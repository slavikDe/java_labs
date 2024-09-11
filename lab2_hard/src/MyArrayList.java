import java.util.RandomAccess;

public class MyArrayList implements MyList, RandomAccess {
    private Object[] array;
    private int size;
    private int capacity;
    private static final int INITIAL_CAPACITY = 10;  // Initial capacity of the array

    public MyArrayList() {
        array = new Object[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        size = 0;
    }

    public MyArrayList(int size) {
        this.capacity = (int)(size * 1.5);
        array = new Object[capacity];
        this.size = 0;
    }

    public void print(){
        for(int i = 0; i < size; i++){
            System.out.println("Index: " + i + " = " + array[i]);
        }
    }

    private void increaseCapacity() {
        capacity *= 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array =Array;
    }

    private void decreaseCapacity() {
        capacity /= 2;
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > capacity) { // Перевірка коректності індексу
            System.out.println("Index out of bounds");
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(Object o) { // пошук індексу за значенням елемента
        for(int i = 0; i < size; i++){
            if(o.equals(array[i] )){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() { // розмір списку
        return size;
    }

    @Override
    public void add(Object e) { // додає елемент в кінець списку
        if(size == capacity){
            increaseCapacity();
        }
        array[size++] = e;
    }

    @Override
    public void add(int index, Object element) {// додає елемент у вказане місце списку
        checkIndex(index);
        if (size >= capacity) {
            increaseCapacity();
        }

        if(index > size) {
            for (int i = size; i < index; i++) {
                array[i] = 0;
            }
            size = index;
        }

        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    @Override
    public void addAll(Object[] c) { // додає масив елементів в кінець списку
        while(capacity < size + c.length){
            increaseCapacity();
        }
        System.arraycopy(c, 0, array, size, c.length);
        size += c.length;

    }

    @Override
    public void addAll(int index, Object[] c) { // додає масив елементів у вказане місце списку
        checkIndex(index);
        for(Object o : c){
            add(index,o);
            index++;
        }
    }

    @Override
    public Object remove(int index) { // видаляє елемент за індексом
        checkIndex(index);
        Object removed = get(index);
        System.arraycopy(array, index + 1, array, index, size - index - 1);

        if(size < (int)(capacity / 2) + 1 ){
            decreaseCapacity();
        }

        return removed;
    }

    public Object[] toArray() {; // перетворює список в масив об'єктів
        return array;
    }

    public void set(int index, Object element) {; // змінює значення елемента
     checkIndex(index);
     array[index] = element;
    }

    public Object get(int index) { ; // повертає елемент за індексом
        checkIndex(index);
        return array[index];
    }
}