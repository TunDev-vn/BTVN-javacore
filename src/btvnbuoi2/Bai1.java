package btvnbuoi2;

import java.util.Scanner;
//Chuyển sang bài 4 để chạy
public class Bai1 {
    public static void tinhDiemSinhVien() {
        float diemChuyenCan, diemGiuaKy, diemCuoiKy;
        final float heSoDiemChuyenCan = 0.1f, heSoDiemGiuaKy = 0.25f, heSoDiemCuoiKy =0.65f;
        float tongDiem;
        char xepLoai;
        System.out.println("-- Tính điểm sinh viên --");
        System.out.print("Nhập điểm chuyên cần: ");
        diemChuyenCan = new Scanner(System.in).nextFloat();
        System.out.print("Nhập điểm giữa kỳ: ");
        diemGiuaKy = new Scanner(System.in).nextFloat();
        System.out.print("Nhập điểm cuối kỳ: ");
        diemCuoiKy = new Scanner(System.in).nextFloat();
        tongDiem = (diemChuyenCan * heSoDiemChuyenCan) + (diemGiuaKy * heSoDiemGiuaKy) + (diemCuoiKy * heSoDiemCuoiKy);

//        System.out.printf("Tổng điểm: %.2f", tongDiem);
//        System.out.println("Tổng điểm: " + (Math.round(tongDiem*100)/(float)100));
        if (tongDiem >= 9) {
            xepLoai = 'A';
        } else if (tongDiem >= 7) {
            xepLoai = 'B';
        } else if (tongDiem >= 5) {
            xepLoai = 'C';
        } else {
            xepLoai = 'D';
        }
        System.out.printf("Tổng điểm của bạn là %.2f, xếp loại %s", tongDiem, xepLoai, xepLoai);
    }
}
