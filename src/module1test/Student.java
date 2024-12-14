package module1test;

import java.util.Scanner;

public class Student {
    private String studentID;
    private String name;
    private int age;

    public Student(String studentID) {
        Scanner sc = new Scanner(System.in);
        this.studentID = studentID;
        System.out.print("Nhập tên: ");
        this.name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        this.age = sc.nextInt();
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void showInfo() {
        System.out.printf("Mã sinh viên: %s, Tên: %s, Tuổi: %d\n", studentID, name, age);
    }
    public void enterInfo(String studentID) {
        Scanner sc = new Scanner(System.in);
        this.studentID = studentID;
        System.out.print("Nhập tên sinh viên chỉnh sửa: ");
        this.name = sc.nextLine();
        System.out.print("Nhập tuổi sinh viên chỉnh sửa: ");
        this.age = sc.nextInt();
    }
}
