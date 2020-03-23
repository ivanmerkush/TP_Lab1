package Application;

public enum TypeOfShape {
    RECTANGLE("Rectangle"), ELLIPSE("Ellipse"), CIRCLE("Circle"), TRIANGLE("Triangle"), LINE("Line"), RAY("Ray"),
    SEGMENT("Segment"), PARALLELOGRAM("Parallelogram"), ISOSCELESTRIANGLE("Isosceles Triangle"),
    REGULARPOLYGON("Regular Polygon"), POLYGON("Polygon"), POLYLINE("Polyline");

    private String name;

    TypeOfShape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
