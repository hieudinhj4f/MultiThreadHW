import java.io.*;

// Interface mới: Phone
interface Phone {
    void sendMessage(String[] message);
    void receiveMessage(String[] message);
}

// Thành phần cốt lõi của điện thoại: gửi và nhận cơ bản
class BasicPhone implements Phone {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public void sendMessage(String[] message) {
        System.out.print("INPUT:    ");
        try {
            message[0] = in.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void receiveMessage(String[] message) {
        System.out.println("Output:   " + message[0]);
    }
}

// Lớp trang trí cơ sở
class PhoneDecorator implements Phone {
    protected Phone innerPhone;

    public PhoneDecorator(Phone phone) {
        this.innerPhone = phone;
    }

    public void sendMessage(String[] message) {
        innerPhone.sendMessage(message);
    }

    public void receiveMessage(String[] message) {
        innerPhone.receiveMessage(message);
    }
}

// Lớp mã hóa/giải mã
class SecurePhone extends PhoneDecorator {
    public SecurePhone(Phone phone) {
        super(phone);
    }

    public void sendMessage(String[] message) {
        super.sendMessage(message);
        System.out.println("Encrypting message...");
        StringBuilder sb = new StringBuilder(message[0]);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, (char)(sb.charAt(i) - 5));
        }
        message[0] = sb.toString();
    }

    public void receiveMessage(String[] message) {
        StringBuilder sb = new StringBuilder(message[0]);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, (char)(sb.charAt(i) + 5));
        }
        message[0] = sb.toString();
        System.out.println("Decrypting message...");
        super.receiveMessage(message);
    }
}

// Lớp kiểm tra mật khẩu trước khi gửi/nhận
public class SecureAccessPhone extends PhoneDecorator {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public SecureAccessPhone(Phone phone) {
        super(phone);
    }

    public void sendMessage(String[] message) {
        System.out.print("Enter PASSWORD to send: ");
        try {
            in.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        super.sendMessage(message);
    }

    public void receiveMessage(String[] message) {
        System.out.print("Enter PASSWORD to receive: ");
        try {
            in.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        super.receiveMessage(message);
    }

    public static void main(String[] args) {
        Phone phone = new SecureAccessPhone(new SecurePhone(new BasicPhone()));
        String[] msg = {""};
        phone.sendMessage(msg);
        System.out.println("main:     " + msg[0]);
        phone.receiveMessage(msg);
    }
}
