
public class MyLinkedList implements MyList {
    private Node head;
    private Node tail;
    private int size;

    public class Node {
        Object data;
        Node next;
        Node prev;

        public Node(Object data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void print(){
        Node current = head;
        for(int i = 0; i < size; i++){
            System.out.println("Index: " + i + " : " + current.data);
            current = current.next;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) { // Перевірка коректності індексу
            System.out.println("Index out of bounds");
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(Object e) { // додає елемент в кінець списку
        if (head == null) {
            head = new Node(e);
            tail = head;
        }
        else {
            Node newNode = new Node(e);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    @Override
    public int size(){ // розмір списку
        return size;
    }

    @Override
    public void add(int index, Object element) { // додає елемент у вказане місце списку
        //checkIndex(index);
        if (index < 0) { // Перевірка коректності індексу
            System.out.println("Index less than 0");
            throw new IndexOutOfBoundsException();
        }


        if(index <= size) {
            if (index == 0) {
                if (head == null) {
                    head = new Node(element);
                    tail = head;
                } else {
                    Node current = head;
                    head = new Node(element);
                    head.next = current;
                    current.prev = head;
                }
                size++;
            } else if (index == size) {
                Node temp = new Node(element);
                temp.prev = tail;
                if (head != null) {
                    tail.next = temp;
                }
                tail = temp;
                size++;
            } else {
                Node current;
                if (index < (int) (size / 2)) {
                    current = head;
                    for (int i = 0; i < index; i++) {
                        current = current.next;
                    }
                } else {
                    current = tail;
                    for (int i = size - 1; i > index; i--) {
                        current = current.prev;
                    }
                }
                Node temp = new Node(element);
                temp.next = current;
                temp.prev = current.prev;
                if (current.prev != null) {
                    current.prev.next = temp;
                }
                current.prev = temp;
                size++;
            }
        }
        else {
            add(null);
            add(index, element);
        }
    }

    @Override
    public int indexOf(Object o) { // пошук індексу за значенням елемента
        Node current = head;
        for (int i = 0; i < size; i++) {
            if(o.equals(current.data)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public void addAll(Object[] c) { // додає масив елементів в кінець списку
        for (Object o : c) {
            add(o);
        }
    }

    @Override
    public void addAll(int index, Object[] c) { // додає масив елементів у вказане місце списку
        for ( Object o : c) {
            add(index++, o);
        }
    }

    @Override
    public Object remove(int index) { // видаляє елемент за індексом
        checkIndex(index);
        Object removed = get(index);

        Node current;
        if(index < (int)(size / 2)) {
            current = head;
            for(int i =0; i != index; i++) {
                current = current.next;
            }
            if(current.prev != null && current.next != null) { // inside chain
                current.prev.next = current.next;
                current.next.prev = current.prev;
                current.prev = null;
                current.next = null;
            }
            else if(current.prev != null) { // tail
                tail = current.prev;
                tail.next = null;
            }
            else if(current.next != null) { // head
                head = current.next;
                head.prev = null;
            }
            else { // head == tail
                head = null;
                tail = null;
            }
            size--;

        }
        return removed;
    }

    @Override
    public Object[] toArray() { // перетворює список в масив об'єктів
       Object[] res = new Object[size];

       Node current = head;
       for (int i = 0; i < size; i++) {
           res[i] = current.data;
           current = current.next;
       }
       return res;
    }

    @Override
    public void set(int index, Object element) { // змінює значення елемента
        checkIndex(index);
        Node current = head;

        if(index < (int)(size / 2)) {
            for (int i = 0; i < size / 2; i++) {
                if(index == i) {
                    current.data = element;
                    return;
                }
                current = current.next;
            }
        }
        else {
            current = tail;
            for(int i = size - 1; i > size; i--) {
                if(index == i) {
                    current.data = element;
                    return;
                }
                current = current.prev;
            }
        }

    }

    @Override
    public Object get(int index) { // повертає елемент за індексом
        checkIndex(index);
        Node current = head;

        if(index < (int)(size / 2)) {
            for (int i = 0; i < size / 2; i++) {
                if(index == i) {
                    return current.data;
                }
                current = current.next;
            }
        }
        else {
            current = tail;
            for(int i = size - 1; i > size; i--) {
                if(index == i) {
                    return current.data;
                }
                current = current.prev;
            }
        }

        return null;
    }
}
