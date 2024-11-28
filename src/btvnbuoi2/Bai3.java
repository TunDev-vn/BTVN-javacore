package btvnbuoi2;

import java.util.Scanner;
//Chuyển sang bài 4 để chạy
public class Bai3 {
    public static void tinhTienDien() {
        double soDienSuDung, tienDien = 0;
        final short bac1 = 50, bac2 = 100, bac3 = 200, bac4 = 300, bac5 = 400;
        final float tien1SoHe1 = 1000, tien1SoHe2 = 1200 , heSoBac1 = 1.678f, heSoBac2 = 1.734f, heSoBac3 = 2.014f, heSoBac4 = 2.536f, heSoBac5 = 2.834f, heSoBac6 = 2.927f;
        System.out.println("-- Tính tiền điện --");
        System.out.print("Nhập số điện sử dụng của tháng: ");
        soDienSuDung = new Scanner(System.in).nextFloat();
        double tienDienBac1 = bac1 * heSoBac1 * tien1SoHe1; //50 * 1.678 * 1000 = 83900
        double tienDienBac2 = tienDienBac1 + (bac2 - bac1) * heSoBac2 * tien1SoHe2;
        double tienDienBac3 = tienDienBac2 + (bac3 - bac2) * heSoBac3 * tien1SoHe2;
        double tienDienBac4 = tienDienBac3 + (bac4 - bac3) * heSoBac4 * tien1SoHe2;
        double tienDienBac5 = tienDienBac4 + (bac5 - bac4) * heSoBac5 * tien1SoHe2;
        if (soDienSuDung < 0) {
            System.out.println("Số điện không hợp lệ");
            System.exit(0);
        } else if (soDienSuDung <= bac1) {
            tienDien = soDienSuDung * heSoBac1 * tien1SoHe1;
        } else if (soDienSuDung <= bac2) {
            tienDien = tienDienBac1 + (soDienSuDung - bac1) * heSoBac2 * tien1SoHe2;
        } else if (soDienSuDung <= bac3) {
            tienDien = tienDienBac2 + (soDienSuDung - bac2) * heSoBac3 * tien1SoHe2;
        } else if (soDienSuDung <= bac4) {
            tienDien = tienDienBac3 + (soDienSuDung - bac3) * heSoBac4 * tien1SoHe2;
        } else if (soDienSuDung <= bac5) {
            tienDien = tienDienBac4 + (soDienSuDung - bac4) * heSoBac5 * tien1SoHe2;
        } else {
            tienDien = tienDienBac5 + (soDienSuDung - bac5) * heSoBac6 * tien1SoHe2;
        }
        System.out.printf("Tiền điện tháng này: %,.2f đồng", tienDien);
    }
}
