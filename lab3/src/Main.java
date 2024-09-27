import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        final int SIZE = 10;
        String []colors = {"red", "green", "blue", "yellow"};
        Shape[] shapes = new Shape[SIZE];

        for (int i = 0; i < SIZE; i+=3) {
            shapes[i] = new Rectangle(colors[rand.nextInt(4)], rand.nextDouble(100), rand.nextDouble(100));
            if(i + 1 < SIZE) {
                shapes[i+1] = new Circle(colors[rand.nextInt(4)], rand.nextDouble(100));
            }
            if(i + 2 < SIZE) {
                shapes[i+2] = new Triangle(colors[rand.nextInt(4)], rand.nextDouble(100), rand.nextDouble(100));
            }
        }
        ShapeView view = new ShapeView();
        ShapeController controller = new ShapeController(shapes, view);
        controller.displayShapes();
        controller.displayTotalArea();
        controller.displayAreaByType(Circle.class);
        controller.displayAreaByType(Triangle.class);
        controller.displayAreaByType(Rectangle.class);




    }
}