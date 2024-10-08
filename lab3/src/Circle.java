
public class Circle extends Shape {
    private double radius;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.radius = radius;
    }

    @Override
    public double culcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with area: " + culcArea());
    }

    @Override
    public String toString() {
        return "Circle:{" + "color='" + shapeColor + "', radius=" + radius  + "', area='" + culcArea() + "'}";
    }
}
