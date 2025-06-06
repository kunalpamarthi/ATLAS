// Task 017: Getter and Setter

class Person{
        private String name = "Kunal";

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
}

public class Task017 {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("Person's name: "+
                person.getName()+"\t\t\t-from getter.");
        person.setName("shiro");
        System.out.println("Person's name: "+
                person.getName()+"\t\t\t-after setting.");
    }
}
