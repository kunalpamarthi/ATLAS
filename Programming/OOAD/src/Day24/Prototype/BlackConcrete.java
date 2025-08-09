package Day24.Prototype;

public class BlackConcrete implements Colors{
    String name;

    public BlackConcrete(String name){
        this.name = name;
    }

    @Override
    public Colors clones() {
        return new BlackConcrete(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
