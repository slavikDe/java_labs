import java.util.Comparator;
import java.util.Arrays;

public class ShapeController {
    private Shape [] shapes;
    private ShapeView view;

    public ShapeController(Shape [] shapes, ShapeView view) {
        this.shapes = shapes;
        this.view = view;
    }

    public void displayShapes() {
        view.displayShape(shapes);
    }

    public void sortByColor(){
        Arrays.sort(shapes, Comparator.comparing(shape -> shape.shapeColor));
    }

    public void displayTotalArea() {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.culcArea();
        }
        view.displayTotalArea(totalArea);
    }

    public void displayAreaByType(Class<?> shapeType) {
        double area = 0;
        for (Shape shape : shapes) {
            if (shape.getClass() == shapeType) {
                area += shape.culcArea();
            }
        }

        view.displayTotalAreaByType(area, shapeType.getSimpleName());
    }


    public void sortByArea(){
        Arrays.sort(shapes, Comparator.comparingDouble(Shape::culcArea));
    }

    public void culcTotalArea(){
        double totalArea = 0;
        for(Shape s : shapes) {
            totalArea += s.culcArea();
        }
    }


}
