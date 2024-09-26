package Comparators;

import java.util.Comparator;


public class SortByColor implements Comparator {
    public int compare(Object o1, Object o2) {
        Circle shape1 = (Circle) o1;
        Circle shape2 = (Circle) o2;

        if(shape1.culcArea() < shape2.culcArea()) return -1;

        return 0;
    }
    
}
