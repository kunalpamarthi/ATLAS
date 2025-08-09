package Day25.Bridge;

// concrete Implementor DrawingFrame. DrawingPicture
public class DrawingFrame implements ExcaliDrawAPI {
    @Override
    public void drawSquare(int s) {
        System.out.println("draw square in Drawing frame using ExCaliDraw with side "+ s);
    }
}
