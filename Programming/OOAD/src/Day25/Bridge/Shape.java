package Day25.Bridge;
// Abstraction
abstract public class Shape {
    protected ExcalidrawAPI excalidrawAPI;

    protected Shape(ExcalidrawAPI excalidrawAPI) {
        this.excalidrawAPI = excalidrawAPI;
    }
    abstract void draw();
}
