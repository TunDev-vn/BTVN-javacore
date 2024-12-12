package btvnbuoi6;

import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account() {
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = new Date();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }
    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }
    public void widthdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Rút tiền thành công!\nSố dư hiện tại: " + balance + " USD\n");
        } else if (amount > balance) {
            System.out.println("Số dư hiện tại không đủ: " + balance + " USD\nVui lòng rút số tiền nhỏ hơn");
        } else {
            System.out.println("Số tiền rút phải lớn hơn 0.");
        }
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Gửi tiền thành công!\nSố dư hiện tại: " + balance + " USD\n");

        } else {
            System.out.println("Số tiền gửi phải lớn hơn 0.");
        }
    }
    public void showAccountInfo() {
        System.out.println("ID tài khoản: " + id);
        System.out.println("Số dư hiện tại: " + balance + " USD");
        System.out.println("Tiền lãi hàng tháng: " + (getMonthlyInterestRate() * balance) +" USD");
        System.out.println("Ngày tạo tài khoản: " + dateCreated);
    }
}
