// Concrete Implementor
class DrawingAPI1 implements DrawingAPI {
    public void drawCircle(int x, int y, int radius) {
        System.out.println("DrawingAPI1: Circle at (" + x + ", " + y + ") with radius " + radius);
    }
}