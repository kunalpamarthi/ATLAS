package Day25.Bridge;

public class Square extends Shape{
    private final int s;

    Square(int s, ExcaliDrawAPI excalidrawAPI) {
        super(excalidrawAPI);

        this.s = s;
    } 
    @Override
    void draw() {
        excalidrawAPI.drawSquare(s);
    }
}
