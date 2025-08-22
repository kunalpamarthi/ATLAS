package Day25.Composite;
//leaf component
public class Software implements Company{
    private final int id;
    private final String Name;

    public Software(int id, String name){
        this.id = id;
        this.Name = name;
    }

    public void displayName() {
        System.out.println(getClass().getSimpleName());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }
    //Constructor 
    //getters
    //setters
}
