// Task013: Static inner class

package Collections;

class College{
    String name;
    College(String name){
        this.name = name;
    }
    static class Section{
        String secName;
        int secStrength;
        Section(String name, int strength){
            this.secName = name;
            this.secStrength = strength;
        }
        void display(){
            System.out.println(secName+"\t"+secStrength);
        }
    }
    void display(){
        System.out.println("College: "+ name);
    }
}

public class Task013 {
    public static void main(String[] args) {
        String clg = "Sri Chaitanya", sec = "SEB";
        int total = 90;
        College college = new College(clg);
        College.Section section = new College.Section(sec, total);
        college.display();
        section.display();
    }
}
