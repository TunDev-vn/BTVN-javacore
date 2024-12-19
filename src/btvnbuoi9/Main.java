package btvnbuoi9;

import module1test.StudentManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();
        int option = 0;
        do {
            System.out.println("\nCHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Hiển thị danh sách sinh viên");
            System.out.println("4. Tìm kiếm sinh viên theo tên");
            System.out.println("5. Sắp xếp danh sách sinh viên theo điểm thi");
            System.out.println("6. Kiểm tra sinh viên có tồn tại không");
            System.out.println("0. Thoát\n");
            option = enterOption(scanner);
            switch (option) {
                case 1: {
                    studentManagement.addStudent(scanner);
                }
                break;
                case 2: {
                    studentManagement.deleteStudent(scanner);
                }
                break;
                case 3: {
                    studentManagement.showStudents();
                }
                break;
                case 4: {
                    studentManagement.searchStudentByName(scanner);
                }
                break;
                case 5: {
                    studentManagement.sortStudentsByScore();
                }
                break;
                case 6: {
                    studentManagement.checkExsitStudent(scanner);
                }
                break;
                case 0: {
                    System.out.println("Thoát chương trình.");
                }
                break;
                default: {
                    System.out.println("Chú ý lựa chọn từ 0 đến 6.");
                }
            }
        } while (option != 0);
        scanner.close();
    }

    public static int enterOption(Scanner scanner) {
        int option;
        while (true) {
            try{
                System.out.print("Nhập lựa chọn (0-6): ");
                option = Integer.parseInt(scanner.nextLine());
                return option;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập vào 1 số nguyên!");
            }
        }
    }
}
