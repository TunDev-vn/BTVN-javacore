package module1test;

import java.util.Scanner;

public class StudentManager {
    public static int total = 10;
    public static Student[] students = new Student[total];
    final static int PLUS = 10;
    public static int lastStudent = 0;
    final static Scanner scanner = new Scanner(System.in);

    public static void runProgram() {
        byte option = 0;
        do {
            System.out.println("\nCHƯƠNG TRÌNH QUẢN LÝ DANH SÁCH SINH VIÊN");
            System.out.println("1. Thêm sinh viên vào danh sách");
            System.out.println("2. Sửa thông tin sinh viên");
            System.out.println("3. Xóa sinh viên khỏi danh sách");
            System.out.println("4. Tìm kiếm sinh viên theo tên");
            System.out.println("5. Hiển thị danh sách sinh viên");
            System.out.println("6. Thoát\n");

            System.out.print("Nhập lựa chọn: ");
            option = Byte.parseByte(scanner.nextLine());
            switch (option) {
                case 1: {
                    addStudent();
                }
                break;
                case 2: {
                    editStudent();
                }
                break;
                case 3: {
                    removeStudent();
                }
                break;
                case 4: {
                    findStudent();
                }
                break;
                case 5: {
                    showStudents();
                }
                break;
                case 6: {
                    System.out.println("Thoát chương trình");
                }
                break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (option != 6);
        scanner.close();
    }

    public static void extendStudents() {
        Student[] newStudents = new Student[total + PLUS];
        for (int i = 0; i < total; i++) {
            newStudents[i] = students[i];
        }
        students = newStudents;
        total += PLUS;

    }

    public static int checkStudent(String id) {
        for (int i = 0; i < lastStudent; i++) {
            if (id.equalsIgnoreCase(students[i].getStudentID())) {
                return i;
            }
        }
        return -1;
    }

    public static int checkStudent(String id, int exceptIDIndex) {
        for (int i = 0; i < lastStudent; i++) {
            if (id.equalsIgnoreCase(students[i].getStudentID()) && i != exceptIDIndex) {
                return i;
            }
        }
        return -1;
    }

    public static void reduceStudents(int indexRemoving) {
        Student[] newStudents = new Student[total];
        for (int i = 0; i < indexRemoving; i++) {
            newStudents[i] = students[i];
        }
        for (int i = indexRemoving + 1; i < lastStudent; i++) {
            newStudents[i - 1] = students[i];
        }
        students = newStudents;
        lastStudent--;
    }

    //1.
    public static void addStudent() {
        if (lastStudent == total) {
            extendStudents();
        }
        System.out.println("*-- Thêm sinh viên vào danh sách --*");
        String studentID;
        do {
            System.out.print("Nhập mã sinh viên: ");
            studentID = scanner.nextLine();
            if (checkStudent(studentID) != -1) {
                System.out.println("Mã sinh viên đã tồn tại. Vui lòng nhập mã khác.");
            }
        } while (checkStudent(studentID) != -1);
        students[lastStudent] = new Student(studentID);
        lastStudent++;
    }

    //2.
    public static void editStudent() {
        System.out.println("*-- Sửa thông tin sinh viên --*");
        System.out.print("Nhập mã sinh viên cần chỉnh sửa: ");
        String studentID = scanner.nextLine();
        int index = checkStudent(studentID);
        if (index == -1) {
            System.out.println("Không tìm thấy sinh viên với mã " + studentID);
        } else {
            System.out.println("Thông tin sinh viên hiện tại:");
            students[index].showInfo();
            do {
                System.out.print("Nhập mã sinh viên chỉnh sửa: ");
                studentID = scanner.nextLine();
                if (checkStudent(studentID, index) != -1) {
                    System.out.println("Mã sinh viên đã tồn tại. Vui lòng nhập mã khác.");
                }
            } while (checkStudent(studentID, index) != -1);
            students[index].enterInfo(studentID);
            System.out.println("Thông tin sin viên đã cập nhật:");
            students[index].showInfo();
        }
    }

    //3.
    public static void removeStudent() {
        System.out.println("*-- Xóa sinh viên khỏi danh sách --*");
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String studentID = scanner.nextLine();
        int index = checkStudent(studentID);
        if (index == -1) {
            System.out.println("Không tìm thấy sinh viên với mã: " + studentID);
        } else {
            reduceStudents(index);
            System.out.println("Sinh viên đã được xóa khỏi danh sách");
        }
    }

    //4.
    public static void findStudent() {
        System.out.println("*-- Tìm kiếm sinh viên theo tên --*");
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < lastStudent; i++) {
            if (!name.equalsIgnoreCase(students[i].getName())) continue;
            else {
                found = true;
                System.out.println("Kết quả tìm kiếm:");
                students[i].showInfo();
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sinh viên nào có tên: " + name);
        }
    }


    //5.
    public static void showStudents() {
        System.out.println("*-- Hiển thị danh sách sinh viên --*");
        if (lastStudent == 0) {
            System.out.println("Danh sách sinh viên hiện tại đang trống");
        } else {
            for (int i = 0; i < lastStudent; i++) {
                students[i].showInfo();
            }
        }
    }
}
