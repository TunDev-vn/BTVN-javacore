package btvnbuoi3;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số nguyên dương n: ");
        int n = scanner.nextInt();
        String binaryString = "";
        int kq = n;
        do {
            binaryString += (kq % 2);
            kq /= 2;
        } while (kq > 0);
        binaryString = new StringBuilder(binaryString).reverse().toString();
        System.out.println(binaryString);
        scanner.close();
    }
}
