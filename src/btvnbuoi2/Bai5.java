package btvnbuoi2;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        int tongNgay = 0, thang, nam;
        System.out.print("Nhập năm: ");
        nam = new Scanner(System.in).nextInt();
        do {
            System.out.print("Nhập tháng: ");
            thang = new Scanner(System.in).nextInt();
            switch (thang) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    tongNgay = 31;
                    break;
                case 4: case 6: case 9: case 11:
                    tongNgay = 30;
                    break;
                case 2:
                    if ((nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0)) {
                        tongNgay = 29;
                    } else {
                        tongNgay = 28;
                    }
                    break;
                default:
                    System.out.println("Tháng không hợp lệ!");
            }
        }while (thang < 1 || thang > 12);
        System.out.printf("năm %d tháng %d có %d ngày", nam, thang, tongNgay);
    }
}
