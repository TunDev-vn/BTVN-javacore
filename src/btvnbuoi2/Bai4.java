package btvnbuoi2;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {

        byte luaChon;
        System.out.println("+---------------------------+");
        System.out.println("| 1. Tính điểm sinh viên    |");
        System.out.println("| 2. Kiểm tra loại tam giác |");
        System.out.println("| 3. Tính tiền điện         |");
        System.out.println("| 4. Kết thúc               |");
        System.out.println("+---------------------------+");
        do {
            System.out.printf("Nhập lựa chọn: ");
            luaChon = new Scanner(System.in).nextByte();
            switch (luaChon) {
                case 1:
                    Bai1.tinhDiemSinhVien();
                    break;
                case 2:
                    Bai2.kiemTraLoaiTamGiac();
                    break;
                case 3:
                    Bai3.tinhTienDien();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 1 && luaChon != 2 && luaChon != 3 && luaChon != 4);
    }
}
