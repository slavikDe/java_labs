public class ShapeView {
    public  void displayShape(Shape[] shapes) {
        for(Shape s : shapes) {
            System.out.println(s.toString());
        }
    }

    public  void displayTotalArea(double totalArea) {
        System.out.println("Total area: " + totalArea);
    }

    public void displayTotalAreaByType(double totalArea, String type) {
        System.out.println("Total area of all "+ type + " shapes: " + totalArea);
    }


//    public  void displayTotalAreaByType(Shape[] shapes) {
//        double totalAreaCircle = 0;
//        double totalAreaTriangle = 0;
//        double totalAreaRectangle = 0;
//        for(Shape s : shapes) {
//            if(s.getClass() == Circle.class) {
//                totalAreaCircle += s.culcArea();
//            }
//            else if(s.getClass() == Triangle.class) {
//                totalAreaTriangle += s.culcArea();
//            }
//            else if(s.getClass() == Rectangle.class) {
//                totalAreaRectangle += s.culcArea();
//            }
//        }
//        System.out.println("Total circle area: " + totalAreaCircle);
//        System.out.println("Total triangle area: " + totalAreaTriangle);
//        System.out.println("Total rectangle area: " + totalAreaRectangle);
//    }
}
