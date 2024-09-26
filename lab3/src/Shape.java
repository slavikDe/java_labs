public abstract class Shape implements Drawable {
    protected String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double culcArea();

    @Override
    public String toString(){
        return "Shape:{" + "color='" + shapeColor + '\'' + ", area=" + culcArea() + '}';
    }
}
