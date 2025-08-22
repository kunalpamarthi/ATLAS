package Day25.Composite;

import java.util.ArrayList;
import java.util.List;

// composite component
public class CompanyHead implements Company{
    private final int id;
    private final String name;
    private final List<Company> subDepartments;
    public CompanyHead(int id, String name) {
        this.id = id;
        this.name= name;
        this.subDepartments = new ArrayList<>();
    }

    public void displayName() {
        subDepartments.forEach(Company::displayName);
    }

    public void addDepartments(Company company) {
        subDepartments.add(company);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    // remove details
}
