package btvnbuoi6;

import java.util.Scanner;

public class ATM {
    final static int ACCOUNT_TOTAL = 10;

    public static void runProgram() {
        Account[] accounts = new Account[ACCOUNT_TOTAL];
        for (int i = 0; i < ACCOUNT_TOTAL; i++) {
            accounts[i] = new Account(i, 100, 4.5);
        }
        enterID(accounts);


    }
    public static void enterID(Account[] accounts) {
        boolean result = true;
        do {
            System.out.printf("Nhập ID tài khoản (0-9): ");
            int id = new Scanner(System.in).nextInt();
            for (int i = 0; i < ACCOUNT_TOTAL; i++) {
                if(accounts[i].getId() != id) {
                    continue;
                } else {
                    result = false;
                    System.out.println("ID chính xác!");
                    actionAccount(accounts, accounts[i]);
                }
            }
            if(result) {
                System.out.println("ID không đúng. Vui lòng nhập lại!");
            }
            result = true;
        } while (result);
    }
    public static void actionAccount(Account[] accounts, Account account) {
        byte option = 0;
        do {
            System.out.println("\n*--------- MENU ---------*");
            System.out.println("1. Xem thông tin\n2. Rút tiền\n3. Gửi tiền\n0. Thoát");
            System.out.println("*------------------------*\n");

            System.out.print("Nhập lựa chọn: ");
            option = new Scanner(System.in).nextByte();
            switch (option) {
                case 1:{
                    account.showAccountInfo();
                } break;
                case 2:{
                    System.out.print("Nhập số tiền muốn rút: ");
                    double amount = new Scanner(System.in).nextDouble();
                    account.widthdraw(amount);
                } break;
                case 3:{
                    System.out.print("Nhập số tiền muốn gửi: ");
                    double amount = new Scanner(System.in).nextDouble();
                    account.deposit(amount);
                } break;
                case 0:{
                    System.out.println("Thoát chương trình!\n");
                } break;
                default:
                    System.out.println("Lựa chọn không hợp lê. Vui lòng nhập lại");
            }
        } while (option != 0);
    }
}
