public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String shapeColor, double base, double height) {
        super(shapeColor);
        this.base = base;
        this.height = height;
    }

    @Override
    public double culcArea() {
        return 0.5 * base * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Triangle with area: "  + culcArea());
    }

    @Override
    public String toString() {
        return "Triangle:{" + "color='" + shapeColor + "', base='" + base + "', height='" + height + "', area='" + culcArea() + "'}";
    }
}
