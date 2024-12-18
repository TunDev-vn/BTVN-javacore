package btvnbuoi8;

import java.util.Scanner;

public class Director extends Employee {
    private double companyStock;
    private double totalIncome;

    public Director() {
        this.setSalaryPerDay(300);
    }
    public Director(String id, String fullName, String phoneNumber, int workingDays, double companyStock) {
        super(id, fullName, phoneNumber, workingDays);
        this.companyStock = companyStock;
        this.setSalaryPerDay(300);
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getCompanyStock() {
        return companyStock;
    }
    public void setCompanyStock(double companyStock) {
        this.companyStock = companyStock;
    }

    public void calTotalIncome(double revene) {
        this.setTotalIncome(this.calSalary() + ((revene / 100) * this.companyStock));
    }

    @Override
    public void enterInfo(Scanner sc) {
        super.enterInfo(sc);
        while (true) {
            System.out.print("Số cổ phần: ");
            this.companyStock = Double.parseDouble(sc.nextLine());
            if (companyStock >= 0 && companyStock <= 100) {
                this.setCompanyStock(companyStock);
                break;
            }
            System.out.println("Cổ phẩn phải nằm trong khoảng 0% đến 100%;");
        }
    }

    @Override
    public void showInfo() {
        System.out.println("Chức vụ: giám đốc");
        super.showInfo();
        System.out.println("Số cố phần : " + companyStock + "%");
    }

    @Override
    public double calSalary() {
        return getSalaryPerDay() * getWorkingDays();
    }

    @Override
    public void handleBeforeDeletion() {

    }
}
