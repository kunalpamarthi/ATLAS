package Day25.Bridge;

public class Square extends Shape{
    private int s;
    ExcalidrawAPI excalidrawAPI;
    Square(int s) {
        super(excalidrawAPI);
        // super(ExcalidrawAPI excalidrawAPI); // need to check

        this.s = s;
    } 
    @Override
    void draw() {
        excalidrawAPI.drawSquare(s);
    }
}
