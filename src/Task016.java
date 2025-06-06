//Task 016: What is the output of the below code snippet

public class Task016 {
    enum Color{
        red, blue, green, yellow}
    enum Weekdays{
        Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday}
    public static void main(String[] args) {
        Color color = Color.yellow;
        System.out.println(color);
        Weekdays day = Weekdays.Tuesday;
        System.out.println(day);
    }
}
