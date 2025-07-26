package Day20.Employee;

public class EmailSender {
    public void sendEmail(String name, String msg){
        System.out.println("An e-mail has been sent to "+name);
        System.out.println("\nDear "+name+"\n\n"+msg+"\n\nRegards,\nShiro, Inc");
    }
}
