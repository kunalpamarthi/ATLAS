package Day25.Bridge;
// Abstraction
abstract public class Shape {
    protected ExcaliDrawAPI excalidrawAPI;

    protected Shape(ExcaliDrawAPI excalidrawAPI) {
        this.excalidrawAPI = excalidrawAPI;
    }
    abstract void draw();
}
