package btvnbuoi2;

import java.util.Scanner;
//Chuyển sang bài 4 để chạy
public class Bai2 {
    public static void kiemTraLoaiTamGiac() {
        int canh1, canh2, canh3;
        System.out.println("-- Kiểm tra loại tam giác --");
        System.out.print("Nhập cạnh thứ nhất: ");
        canh1 = new Scanner(System.in).nextInt();
        System.out.print("Nhập cạnh thứ hai: ");
        canh2 = new Scanner(System.in).nextInt();
        System.out.print("Nhập cạnh thứ ba: ");
        canh3 = new Scanner(System.in).nextInt();
        String ketLuan;

        if (canh1 + canh2 > canh3 && canh1 + canh3 > canh2 && canh2 + canh3 > canh1) {
            if (canh1 == canh2 && canh1 == canh3) {
                ketLuan = "Tam giác đều";
            } else if (canh1 == canh2 || canh1 == canh3 || canh2 == canh3) {
                if (ktTamGiacVuong(canh1, canh2, canh3)) {
                    ketLuan = "Tam giác vuông cân";
                } else {
                    ketLuan = "Tam giác cân";
                }
            } else if (ktTamGiacVuong(canh1, canh2, canh3)) {
                ketLuan = "Tam giác vuông";
            } else {
                ketLuan = "Tam giác thường";
            }
        } else {
            ketLuan = "Không phải tam giác";
        }
        System.out.println(ketLuan);

    }
    public static boolean ktTamGiacVuong(int a, int b, int c) {
        boolean pytago1 = (a*a == b*b + c*c) ?true:false;
        boolean pytago2 = (b*b == a*a + c*c) ?true:false;
        boolean pytago3 = (c*c == b*b + a*a) ?true:false;
        if (pytago1 || pytago2 || pytago3) {
            return true;
        }
        return false;
    }
}
