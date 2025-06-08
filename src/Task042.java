public class Task042 {

    private int instanceVariable = 10;
    private final int FINAL_INSTANCE_VARIABLE = 20;
    private static int staticVariable = 30;
    public static final double PI = 3.14159;
    public void testFinalVariables() {
        instanceVariable = 15;
        staticVariable = 35;
        int fin = FINAL_INSTANCE_VARIABLE/2;
        System.out.println(fin);
    }

    public static void main(String[] args) {
        Task042 example1 = new Task042();
        Task042 example2 = new Task042();
        System.out.println("Initial static variable value: " + Task042.staticVariable);

        staticVariable = 40;
        System.out.println("Static variable value after modification: " + staticVariable);
        example1.instanceVariable = 12;
        System.out.println("Instance variable value for example1: " + example1.instanceVariable);
        System.out.println("Instance variable value for example2: " + example2.instanceVariable);
        System.out.println("Value of PI: " + Task042.PI);
        example2.testFinalVariables();
        System.out.println(example2.FINAL_INSTANCE_VARIABLE);
    }
}
