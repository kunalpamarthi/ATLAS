package Day20.Notifications;

public interface BankNotifications {
    void sendOTP(String via);
}

class EmailNotif implements BankNotifications{
    @Override
    public void sendOTP(String via) {
        System.out.println("OTP sent to your registered "+via);
    }
}

class WhatsAppNotif implements BankNotifications{
    @Override
    public void sendOTP(String via) {
        System.out.println("OTP sent to your registered WhatsApp.");
    }
}

class MobileNotif implements BankNotifications{
    @Override
    public void sendOTP(String via) {
        System.out.println("OTP sent to your registered mobile number.");
    }
}
