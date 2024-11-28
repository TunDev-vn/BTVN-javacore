package btvnbuoi3;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String setOfNumbers;
        boolean isNotValid;
        do {
            System.out.println("Nhập vào 1 dãy số cách nhau bằng dấu cách:");
            //6 28 153 2332 121 8208 10
            setOfNumbers = scanner.nextLine();
            isNotValid = !setOfNumbers.matches("[0-9 ]+");
            if (isNotValid) {
                System.out.println("Dãy nhập vào không hợp lệ!");
            } else {
                System.out.println("Dãy nhập vào hợp lệ!\n");
            }
        } while (isNotValid);

        String[] numberString = setOfNumbers.split(" ");
        int total = numberString.length;
        int[] numbers = new int[total];
        for (int i = 0; i < total; i++) {
            numbers[i] = Integer.parseInt(numberString[i]);
        }
        for (int i : numbers) {
            showResult(i);
        }
    }

    public static void showResult(int n) {
        String result = "";
        result += (findPerfectNumber(n)) ? (n + " là số hoàn hảo.\n") : (n + " không phải là số hoàn hảo.\n");
        result += (findArmstrongNumber(n)) ? (n + " là số Armstrong.\n") : (n + " không phải là số Armstrong.\n");
        result += (findSymmetricalNumber(n)) ? (n + " là số đối xứng.\n") : (n + " không phải là số đối xứng.\n");
        result += "Tổng các chữ số của " + n + " là: " + calSumOfDigit(n);
        System.out.println(result + "\n");
    }
    public static boolean findPerfectNumber(int n) {
        int sumN = 0, limit = n/2;
        for (int i = 1; i <= limit; i++) {
            if (n % i == 0 ) {
                sumN += i;
            }
        }
        if (sumN == n) {
            return true;
        }
        return false;
    }
    public static boolean findArmstrongNumber(int n) {
        String num = "" + n;
        int limit = num.length(), sum = 0;
        for (int i = 0; i < limit; i++) {
            sum += Math.pow(Integer.parseInt(num.substring(i, i + 1)), limit);
        }
        if (sum == n) {
            return true;
        }
        return false;
    }
    public static boolean findSymmetricalNumber(int n) {
        String num = "" + n; //3223
        int length = num.length();
        int half = length / 2;
        if (length % 2 == 0 ) {
            if (num.substring(0, half).equals(new StringBuilder(num.substring(half, length)).reverse().toString())) {
                return true;
            }
        } else {
            if (num.substring(0, half).equals(new StringBuilder(num.substring(half+1, length)).reverse().toString())) {
                return true;
            }
        }
        return false;
    }
    public static int calSumOfDigit(int n) {
        String num = "" + n;
        int limit = num.length(), sum = 0;
        for (int i = 0; i < limit; i++) {
            sum += Integer.parseInt(num.substring(i, i + 1));
        }
        return sum;
    }
}
