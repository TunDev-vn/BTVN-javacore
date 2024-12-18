package btvnbuoi8;

public class Staff extends Employee {
    private Manager manager;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
    public void removeManager() {
        this.manager = null;
    }

    public Staff() {
        this.setSalaryPerDay(100);
    }
    public Staff(String id, String fullName, String phoneNumber, int workingDays) {
        super(id, fullName, phoneNumber, workingDays);
        this.setSalaryPerDay(100);
    }

    @Override
    public void showInfo() {
        System.out.println("Chức vụ: nhân viên thường");
        super.showInfo();
        if (manager == null) {
            System.out.println("Chưa thuộc trưởng phòng nào");
        } else {
            System.out.println("Thuộc quản lý của trưởng phòng: " + manager.getId());
        }
    }

    @Override
    public double calSalary() {
        return getSalaryPerDay() * getWorkingDays();
    }

    @Override
    public void handleBeforeDeletion() {
        if (manager != null) {
            manager.removeStaff(this);
        }
    }
}
