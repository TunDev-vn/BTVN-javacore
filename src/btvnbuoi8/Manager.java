package btvnbuoi8;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    public List<Staff> staffs;

    public Manager() {
        this.setSalaryPerDay(200);
        this.staffs = new ArrayList<>();
    }
    public Manager(String id, String fullName, String phoneNumber, int workingDays) {
        super(id, fullName, phoneNumber, workingDays);
        this.setSalaryPerDay(200);
        this.staffs = new ArrayList<>();
    }

    public void addStaff(Staff staff) {
        this.staffs.add(staff);
    }

    public void removeStaff(Staff staff) {
        this.staffs.remove(staff);
    }

    public void showStaffs() {
        for (Staff staff : staffs) {
            System.out.println("Mã nhân viên thường: " + staff.getId());
        }
    }
    public int getStaffCount() {
        return this.staffs.size();
    }

    @Override
    public void showInfo() {
        System.out.println("Chức vụ: trưởng phòng");
        super.showInfo();
        if (staffs.size() > 0) {
            System.out.println("\nDanh sách các nhân viên thường đang quản lý:");
            showStaffs();
        }
    }

    @Override
    public double calSalary() {
        return getSalaryPerDay() * getWorkingDays() + (100 * staffs.size());
    }

    @Override
    public void handleBeforeDeletion() {
        for (Staff staff : staffs) {
            staff.removeManager();
        }
    }
}
