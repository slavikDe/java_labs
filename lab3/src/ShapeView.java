public class ShapeView {
    public static void displayShape(Shape[] shapes) {
        for(Shape s : shapes) {
            System.out.println(s.toString());
        }
    }

    public static void displayTotalArea(Shape[] shapes) {
        double totalArea = 0;
        for(Shape s : shapes) {
            totalArea += s.culcArea();
        }
        System.out.println("Total area: " + totalArea);
    }

    public static void displayTotalAreaByType(Shape[] shapes) {
        double totalAreaCircle = 0;
        double totalAreaTriangle = 0;
        double totalAreaRectangle = 0;
        for(Shape s : shapes) {
            if(s.getClass() == Circle.class) {
                totalAreaCircle += s.culcArea();
            }
            else if(s.getClass() == Triangle.class) {
                totalAreaTriangle += s.culcArea();
            }
            else if(s.getClass() == Rectangle.class) {
                totalAreaRectangle += s.culcArea();
            }
        }
        System.out.println("Total circle area: " + totalAreaCircle);
        System.out.println("Total triangle area: " + totalAreaTriangle);
        System.out.println("Total rectangle area: " + totalAreaRectangle);
    }
}
