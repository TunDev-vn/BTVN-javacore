package btvnbuoi4;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        int element;
        int[] integers = {0,1,2,3,4,5,6,7,8,9};
        System.out.println("Mảng nhập vào: " + showArray(integers));
        findPrime(integers);
        int[] odds = divideOddEven(integers, "odd");
        int[] evens = divideOddEven(integers, "even");
        System.out.println("Tổng các số chẵn = " + calSum(odds));
        System.out.println("Tổng các số lẻ = " + calSum(evens));
        System.out.println("Mảng số chẵn giảm: " + sort(odds, "desc"));
        System.out.println("Mảng số lẻ tăng: " + sort(evens, "asc"));
        divideArray(integers);

        System.out.println("Mảng hiện tại: " + showArray(integers));
        System.out.print("Thêm phần tử tại index: ");
        int index = new Scanner(System.in).nextInt();
        System.out.print("Giá trị: ");
        element = new Scanner(System.in).nextInt();
        integers = addElement(integers, index, element);
        System.out.println("Mảng sau khi thêm: " + showArray(integers));

        boolean check = true;
        do {
            System.out.println("Mảng hiện tại: " + showArray(integers));
            System.out.print("Xóa phần tử: ");
            element = new Scanner(System.in).nextInt();
            for (int i : integers) {
                if (i == element) {
                    check = false;
                    integers = removeElement(integers, element);
                    System.out.println("Mảng sau khi xóa: " + showArray(integers));
                }
            }
            if (check) {
                System.out.println("Phần tử không tồn tại!");
            }
        } while (check);
    }

    public static String showArray(int[] array) {
        String s = "";
        for (int i : array) {
            s += i + " ";
        }
        return s.trim();
    }
    public static int[] convertStringToIntArray(String s) {
        s = s.trim();
        String[] sArray = s.split(" ");
        int length = sArray.length;
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = Integer.parseInt(sArray[i]);
        }
        return intArray;
    }
    public static int calSum(int[] numbers) {
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        return sum;
    }
    public static void findPrime(int[] numbers) {
        String primesStr = "";
        for (int i = 0; i < numbers.length; i++) {
            int length = (int)Math.sqrt(numbers[i]);
            boolean isPrime = true;
            if (numbers[i] <= 1) {
                isPrime = false;
            } else {
                for (int j = 2; j <= length; j++) {
                    if (numbers[i] % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                primesStr += numbers[i] + " ";
            }
        }
        if ("".equals(primesStr)) {
            System.out.println("Không có số nguyên tố trong mảng.");
        } else {
            System.out.println("Số nguyên tố trong mảng: " + primesStr.trim());
        }
    }
    public static String sort(int[] numbers, String sortCase) {
        int length = numbers.length;
        String sortedString = "";
        if ("asc".equals(sortCase)) {
            for (int i = 0; i < length-1; i++) {
                for (int j = i+1; j < length; j++) {
                    if (numbers[i] > numbers[j]) {
                        int temp = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = temp;
                    }
                }
            }
        } else if ("desc".equals(sortCase)) {
            for (int i = 0; i < length-1; i++) {
                for (int j = i+1; j < length; j++) {
                    if (numbers[i] < numbers[j]) {
                        int temp = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = temp;
                    }
                }
            }
        }
        for (int i : numbers) {
            sortedString += i + " ";
        }
        return sortedString.trim();
    }
    public static int[] divideOddEven(int[] numbers, String type) {
        String oddStr = "", evenStr = "";
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            if (numbers[i] % 2 == 0) {
                evenStr += numbers[i] + " ";
            } else {
                oddStr += numbers[i] + " ";
            }
        }
        if (type.equals("odd")) {
            return convertStringToIntArray(oddStr);
        } else if (type.equals("even")) {
            return convertStringToIntArray(evenStr);
        }
        return null;
    }
    public static void divideArray(int[] numbers) {
        int length = numbers.length;
        int average = calSum(numbers)/length;
        String lessOrEqualStr = "", greaterStr = "";
        for (int i = 0; i < length; i++) {
            if (numbers[i] <= average) {
                lessOrEqualStr += numbers[i] + " ";
            } else {
                greaterStr += numbers[i] + " ";
            }
        }
        System.out.println("Trung bình: " + average);
        System.out.println("Mảng nhỏ hơn hoặc bằng trung bình:\n" + lessOrEqualStr.trim());
        System.out.println("Mảng lớn hơn trung bình:\n" + greaterStr.trim());
    }
    public static int[] addElement (int[] numbers, int index, int element) {
        int length = numbers.length;
        String numbersStr = "";
        for (int i = 0; i < length; i++) {
            if (i == index) {
                numbersStr += element + " " + numbers[i] + " ";
            } else {
                numbersStr += numbers[i] + " ";
            }
        }
        return convertStringToIntArray(numbersStr);
    }
    public static int[] removeElement(int[] numbers, int element) {
        int length = numbers.length;
        String numbersStr = "";
        for (int i = 0; i < length; i++) {
            if (numbers[i] == element) {
                numbersStr += "";
            } else {
                numbersStr += numbers[i] + " ";
            }
        }
        return convertStringToIntArray(numbersStr);
    }
}
