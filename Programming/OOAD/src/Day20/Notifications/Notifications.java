package Day20.Notifications;

public class Notifications {
    public void sendOTP(String via){
        if (via.equals("email")){
            System.out.println("OTP sent to your registered mail.");
        } else if (via.equals("whatsapp")) {
            System.out.println("OTP sent to your WhatsApp.");
        } else {
            System.out.println("OTP sent to your registered mobile number.");
        }
    }

    public static void main(String[] args) {
        Notifications notifications = new Notifications();
        notifications.sendOTP("email");
    }
}
