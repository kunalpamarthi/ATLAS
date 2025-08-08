package Day24.AbstractFactory;

public class Apple implements Brand{
    @Override
    public Mobile createModel(String modelName) {
        if (modelName.equals("iPhone16")){
            return new iPhone16();
        }
        return null;
    }
}

