package btvnbuoi8;

import java.util.Scanner;

public abstract class Employee {
    private String id;
    private String fullName;
    private String phoneNumber;
    private int workingDays;
    private double salaryPerDay;

    public Employee() {

    }
    public Employee(String id, String fullName, String phoneNumber, int workingDays) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.workingDays = workingDays;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return fullName;
    }

    public void setName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public double getSalaryPerDay() {
        return salaryPerDay;
    }

    public void setSalaryPerDay(double salaryPerDay) {
        this.salaryPerDay = salaryPerDay;
    }

    public abstract double calSalary();
    public abstract void handleBeforeDeletion();

    public void enterInfo(Scanner sc) {
        System.out.println("NHẬP THÔNG TIN NHÂN VIÊN");
        System.out.print("Mã nhân viên: ");
        this.id = sc.nextLine();
        System.out.print("Họ tên: ");
        this.fullName = sc.nextLine();
        System.out.print("Số điện thoại: ");
        this.phoneNumber = sc.nextLine();
        System.out.print("Số ngày làm việc: ");
        this.workingDays = Integer.parseInt(sc.nextLine());
    }
    public void showInfo() {
        System.out.println("Mã nhân viên : " + id);
        System.out.println("Họ tên : " + fullName);
        System.out.println("Số điện thoại : " + phoneNumber);
        System.out.println("Số ngày làm việc: " + workingDays);
        System.out.println("Lương một ngày : " + salaryPerDay);
    }
}
