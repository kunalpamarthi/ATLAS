// Task002: Composite - company

package Day25.Composite;

public class Main {
    public static void main(String[] args) {
        System.out.println("Composite Method DP - Structural DP");
        Company softwareCompany = new Software(1, "software");
        CompanyHead companyHead = new CompanyHead(3, "abcCompany");

        companyHead.addDepartments(softwareCompany);
        System.out.print(companyHead.getId()+" ");
        companyHead.displayName();
    }
}