package btvnbuoi6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte option = 0;
        do {
            System.out.println("\n*==== DANH MỤC ====*:\n1. Quản lý sở thú\n2. ATM\n0. Thoát\n");
            System.out.printf("Nhập lựa chọn: ");
            option = new Scanner(System.in).nextByte();
            switch (option) {
                case 1: {
                    ManagerAnimal.runProgram();
                } break;
                case 2: {
                    ATM.runProgram();
                }break;
                case 0: {
                    System.out.println("Thoát chương trình!");
                } break;
                default: {
                    System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        } while(option != 0);
    }
}
