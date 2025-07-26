// Task002: OCP Implementation

package Day20.Notifications;

public class NotifHandler {
    public static void main(String[] args) {
        BankNotifications emailNotif = new EmailNotif();
        BankNotifications mobileNotif = new MobileNotif();
        BankNotifications whatsappNotif = new WhatsAppNotif();
        emailNotif.sendOTP("email");
        mobileNotif.sendOTP("");
        whatsappNotif.sendOTP("");
    }
}
