import java.util.Scanner;

abstract class Shape {
    // Two integers to represent dimensions
    protected int dimension1; // Could be length or base
    protected int dimension2; // Could be width or height/radius
 
    public Shape(int dimension1, int dimension2) {
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
    }

    public abstract void printArea();
}

class Rectangle extends Shape {
    public Rectangle(int length, int width) {
        super(length, width);
    }

    @Override
    public void printArea() {
        int area = dimension1 * dimension2; // length * width
        System.out.println("Area of Rectangle: " + area);
    }
}

class Triangle extends Shape {
    public Triangle(int base, int height) {
        super(base, height);
    }

    @Override
    public void printArea() {
        double area = 0.5 * dimension1 * dimension2; // 0.5 * base * height
        System.out.println("Area of Triangle: " + area);
    }
}

class Circle extends Shape {
    public Circle(int radius) {
        super(radius, 0); // dimension2 is not used
    }

    @Override
    public void printArea() {
        double area = Math.PI * dimension1 * dimension1; // π * r^2
        System.out.println("Area of Circle: " + area);
    }
}

public class AreaFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of rectangle: ");
        int rectangleLength = scanner.nextInt();
        System.out.print("Enter width of rectangle: ");
        int rectangleWidth = scanner.nextInt();
        Shape rectangle = new Rectangle(rectangleLength, rectangleWidth);
        rectangle.printArea();

        System.out.print("Enter base of triangle: ");
        int triangleBase = scanner.nextInt();
        System.out.print("Enter height of triangle: ");
        int triangleHeight = scanner.nextInt();
        Shape triangle = new Triangle(triangleBase, triangleHeight);
        triangle.printArea();

        System.out.print("Enter radius of circle: ");
        int circleRadius = scanner.nextInt();
        Shape circle = new Circle(circleRadius);
        circle.printArea();

        scanner.close();
    }
}
