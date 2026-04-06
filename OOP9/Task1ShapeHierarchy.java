class Shape {
    public double calculateArea() {
        return 0;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return calculateArea(this.radius);
    }

    public double calculateArea(double radius) {
        return 3.14159 * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double calculateArea() {
        return calculateArea(this.side);
    }

    public double calculateArea(double side) {
        return side * side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return calculateArea(this.base, this.height);
    }

    public double calculateArea(double base, double height) {
        return 0.5 * base * height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

public class Task1ShapeHierarchy {
    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        Shape s2 = new Square(4);
        Shape s3 = new Triangle(6, 3);

        System.out.println("Circle area = " + s1.calculateArea());
        System.out.println("Square area = " + s2.calculateArea());
        System.out.println("Triangle area = " + s3.calculateArea());

        Circle c = new Circle(2);
        Square sq = new Square(7);
        Triangle t = new Triangle(8, 2);

        System.out.println("Circle overloaded method area = " + c.calculateArea(2));
        System.out.println("Square overloaded method area = " + sq.calculateArea(7));
        System.out.println("Triangle overloaded method area = " + t.calculateArea(8, 2));
    }
}
