package no65;
public class TestCircle {
    public static void main(String[] args) {
        GeometricObject c1 = new Circle(1);
        System.out.println(c1);
        
        GeometricObject c2 = new Circle(2);
        System.out.println(c2);
        System.out.println("Area: " + c2.getArea());
        System.out.println("Perimeter: " + c2.getPerimeter());
    }
}