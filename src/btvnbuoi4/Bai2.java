package btvnbuoi4;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        System.out.print("Nhập số điện thoại: ");
        //+84123-123-123
        String phoneNumber = new Scanner(System.in).nextLine();
        if (checkPhoneNumber(phoneNumber)) {
            System.out.println("Số hợp lệ!");
        } else {
            System.out.println("Số không hợp lệ!");
        }
    }
    public static boolean checkPhoneNumber(String phoneNumber) {
        int so = phoneNumber.replaceAll("[\\.\\-]", "").length()-9;
        String chinSoCuoi = phoneNumber.substring(so);
        if (checkFirstNbersbers(phoneNumber.substring(0,so)) && checkSign(phoneNumber.substring(so))) {
            return true;
        }
        return false;
    }
    public static boolean checkFirstNbersbers(String phoneNumber) {
        if ("0".equals(phoneNumber) || "84".equals(phoneNumber) || "+84".equals(phoneNumber)) {
            return true;
        }
        return false;
    }
    public static boolean checkSign (String phoneNumber) {
        if (phoneNumber.matches("[0-9]{9}")) {
            return true;
        } else if (phoneNumber.matches("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}") || phoneNumber.matches("[0-9]{3}-[0-9]{3}-[0-9]{3}")) {
            return true;
        }
        return false;
    }
}
