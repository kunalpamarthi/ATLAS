class College{
    String name;
    String location;

    College(String name, String location){
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}

class Teacher{
    String name;
    String dept;
    College college;

    Teacher(String name, String dept, College college){
        this.name = name;
        this.dept = dept;
        this.college = college;
    }

    public College getCollege() {
        return college;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }
}

class Student{
    String name;
    int rollNum;
    College college;

    Student(String name, int rollNum, College college){
        this.name = name;
        this.rollNum = rollNum;
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public int getRollNum() {
        return rollNum;
    }

    public College getCollege() {
        return college;
    }
}

class SportTeam{
    String name;
    String game;
    Manager mng;
    Coach coach;
    Players[] players;

    SportTeam(String name, String game, Manager mng, Coach coach, Players[] players){
        this.game = game;
        this.name = name;
        this.mng = mng;
        this.coach = coach;
        this.players = players;
    }

    void displayTeam(){
        System.out.println("Details of the " +game+" team:\n" +
                "\nTeam name\t-\t" + name +
                "\nManager\t\t-\t" + mng.name +
                "\n"+coach.designation+"\t-\t" + coach.name +
                "\n------------------------------------");
        System.out.println("Player details:");
        System.out.println("Jersey \t\tName\t\t\tPosition");
        for (Players player : players){
            System.out.println(player.jersey + "\t\t\t" +player.name+ "\t" + player.position);
        }
    }
}

class Players{
    String name;
    String position;
    int jersey;

    Players(String name, String position, int num){
        this.name = name;
        this.position = position;
        jersey = num;
    }
}

class Manager{
    String name;
    int exp;

    Manager(String name, int exp){
        this.name = name;
        this.exp = exp;
    }
}

class Coach{
    String name;
    int exp;
    String designation;

    Coach(String name, int exp, String designation){
        this.exp = exp;
        this.designation = designation;
        this.name = name;
    }
}

public class OOP_Aggregation {
    public static void main(String[] args) {

        College college = new College("IIIT ", "Kottayam");

        Teacher prof = new Teacher("Arun", "Comp. Sci.", college);
        Student shiro = new Student("shiro", 43, college);

        System.out.println(shiro.getName()+" of roll: "+shiro.getRollNum() +" graduated from "+ shiro.getCollege().getName() + shiro.getCollege().location);
        System.out.println(prof.getName()+" teaches "+ prof.getDept()+ " at " + prof.getCollege().name+prof.getCollege().getLocation());


        Manager mng = new Manager("Tom Moody", 45);
        Coach coach = new Coach("Harries", 30, "Head Coach");
        Players[] players = {new Players("Shikar Dhawan", "Left-handed batsman", 25)};

        SportTeam sportTeam = new SportTeam("Sunrisers Hyderabad", "IPL-Cricket", mng, coach, players);
        sportTeam.displayTeam();
        }
    }

