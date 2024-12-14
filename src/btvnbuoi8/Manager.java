package btvnbuoi8;

import java.util.List;

public class Manager extends Staff {
    List<Employee> employees;

    public Manager() {
        this.salaryPerDay = 200;
    }

    @Override
    public double getTotalSalary() {
        return super.getTotalSalary() + (100 * employees.size());
    }
}
