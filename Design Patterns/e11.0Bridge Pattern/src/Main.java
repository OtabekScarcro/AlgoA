// Usage
public class Main {
    public static void main(String[] args) {
        Shape circle1 = new Circle(1, 2, 3, new DrawingAPI1());
        Shape circle2 = new Circle(4, 5, 6, new DrawingAPI2());

        circle1.draw();
        circle2.draw();
    }
}