package btvnbuoi6;

import java.util.Scanner;

public class TestAccount {
    public static void main(String[] args) {
        Account customer1 = new Account(1122, 20000, 4.5);
        byte option = 0;
        do {
            System.out.println("1. Xem thông tin\n2. Rút tiền\n3. Gửi tiền\n0. Thoát\n");
            System.out.print("Nhập lựa chọn: ");
            option = new Scanner(System.in).nextByte();
            switch (option) {
                case 1:{
                    customer1.showAccountInfo();
                } break;
                case 2:{
                    System.out.print("Nhập số tiền muốn rút: ");
                    double amount = new Scanner(System.in).nextDouble();
                    customer1.widthdraw(amount);
                } break;
                case 3:{
                    System.out.print("Nhập số tiền muốn gửi: ");
                    double amount = new Scanner(System.in).nextDouble();
                    customer1.deposit(amount);
                } break;
                case 0:{
                    System.out.println("Thoát chương trình!");
                }
                default:
                    System.out.println("Lựa chọn không hợp lê. Vui lòng nhập lại");
            }
        } while (option != 0);
    }

}
