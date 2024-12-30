package btvnbuoi10;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        System.out.println("Main thread start");
        int n = 10;
        int midle = n / 2;
        int sum = 0;
        ThreadCaculator thread1 = new ThreadCaculator("Thread1", 1, midle);
        ThreadCaculator thread2 = new ThreadCaculator("Thread2", midle + 1, n);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Error");
        }

        sum = thread1.getSum() + thread2.getSum();
        System.out.println("Tổng từ 1 đến " + n + " bằng " + sum);
        System.out.println("Main thread end");
    }
}
