package DataStructures;

public class DS_1_Index {

    public static void forLoopTime(){
        String[] students = {"shiro", "kunal", "etherious", "javed"}; // O(1)
        String first = students[0]; // O(1)
        int strength = 0; //O(1)

        for(String student: students){
            System.out.print(student+" "); // O(n) or O(students.length)
            strength++; // O(n) or O(students.length)
        }

        String last = students[strength-1]; // O(1)
        System.out.println("\n"+first+"\t"+last); // O(1)
    }

    public static void main(String[] args) {
        // How to calculate time complexity:
        forLoopTime(); // gives us: O(5 + n + n)
        // => O(5 + 2n) => O(2n) => O(n)
    }
}
