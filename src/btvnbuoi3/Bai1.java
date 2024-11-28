package btvnbuoi3;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        int soTH = 0, tongTien = 200000;
        int to1000, to2000, to5000;
        int tongTien2 = tongTien/1000, tongSoTo2000;
        for (to1000 = 1; to1000 <= tongTien2; to1000++) {
            tongSoTo2000 = (tongTien2 - to1000) / 2;
            for (to2000 = 1; to2000 <= tongSoTo2000; to2000++) {
                if ((tongTien2 - to1000 - to2000*2) % 5 == 0 && (to1000 + to2000*2) != tongTien2) {
                    to5000 = (tongTien2 - to1000 - to2000*2)/5;
                    soTH++;
                    System.out.printf("%d tờ 1000 + %d tờ 2000 + %d tờ 5000 = %d %n", to1000, to2000, to5000, tongTien);
                }
            }
        }
        System.out.println("Số trường hợp là: " + soTH);
    }
}
