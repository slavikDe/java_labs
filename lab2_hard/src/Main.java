import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
       MyLinkedList list = new MyLinkedList();

       list.add("value1");
       list.add(null);
       list.add("value3");
       list.add(22, "value4");
       list.print();


//       Object[] arr = list.toArray();
//
//        for(Object o : arr) {
//            System.out.println("item: " + o);
//        }
    }
}