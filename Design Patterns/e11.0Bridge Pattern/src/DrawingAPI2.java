
// Concrete Implementor
class DrawingAPI2 implements DrawingAPI {
    public void drawCircle(int x, int y, int radius) {
        System.out.println("DrawingAPI2: Circle at (" + x + ", " + y + ") with radius " + radius);
    }
}