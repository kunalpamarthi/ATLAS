package Day25.Bridge;
// concrete Implementor DrawingFrame. DrawingPicture
public class DrawingPicture implements ExcaliDrawAPI {
    @Override
    public void drawSquare(int s) {
        System.out.println("draw square in Drawing Picture using ExcaliDraw with side "+ s);

    }
}
