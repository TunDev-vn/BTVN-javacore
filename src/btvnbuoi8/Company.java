package btvnbuoi8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Company {
    private String name;
    private String taxCode;
    private double monthlyRevenue;
    private double salaryTotal;
    List<Employee> employees;

    public Company() {
        employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public double getMonthlyRevenue() {
        return monthlyRevenue;
    }

    public void setMonthlyRevenue(double monthlyRevenue) {
        this.monthlyRevenue = monthlyRevenue;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public double getSalaryTotal() {
        return salaryTotal;
    }

    public void setSalaryTotal() {
        this.salaryTotal = 0;
        for (Employee employee : employees) {
            System.out.println(employee.calSalary());
            this.salaryTotal += employee.calSalary();
        }
    }

    public Employee findEmployee(String id) {
        for (Employee employee : employees) {
            if (id.equals(employee.getId())) {
                return employee;
            }
        }
        return null;
    }

    // 1. Nhập thông tin công ty
    public void setInfoCompany(Scanner sc) {
        System.out.println("NHẬP THÔNG TIN CÔNG TY");
        System.out.print("Nhập tên công ty: ");
        this.name = sc.nextLine();
        System.out.print("Nhập mã số thuế: ");
        this.taxCode = sc.nextLine();
        System.out.print("Nhập doanh thu tháng: ");
        this.monthlyRevenue = Double.parseDouble(sc.nextLine());
    }

    // 2. phân bổ nhân viên vào trưởng phòng
    public void allocateStaffToManager(Scanner sc) {
        System.out.println("PHÂN BỔ NHÂN VIÊN VÀO TRƯỞNG PHÒNG");
        System.out.print("Nhập mã nhân viên thường cần phân bổ vào trưởng phòng: ");
        String staffID = sc.nextLine();
        Employee employee = findEmployee(staffID);
        if (!(employee instanceof Staff staff)) {
            System.out.println("Không tồn tại nhân viên thường với mã: " + staffID);
            return;
        }
        if (staff.getManager() != null) {
            System.out.println("Nhân viên thường " + staffID + " đang thuộc quản lý " + staff.getManager().getId());
            if (!changeManager(sc, staff)) return;
        }
        System.out.print("Nhập mã quản lý: ");
        String managerID = sc.nextLine();
        employee = findEmployee(managerID);
        if (!(employee instanceof Manager manager)) {
            System.out.println("Không tồn tại quản lý với mã: " + managerID);
            return;
        }
        staff.setManager(manager);
        manager.addStaff(staff);
        System.out.println("Phân bổ thành công!");
    }

    public boolean changeManager(Scanner sc, Staff staff) {
        System.out.println("Bạn có muốn thay đổi quản lý của nhân viên không?");
        System.out.println("0. No");
        System.out.println("1. Yes");
        byte option = 1;
        do {
            System.out.print("Nhập lựa chọn: ");
            option = Byte.parseByte(sc.nextLine());
            switch (option) {
                case 0: {
                    System.out.println("Bạn lựa chọn không thay đổi.");
                    return false;
                }
                case 1: {
                    staff.getManager().removeStaff(staff);
                    System.out.println("Bạn lựa chọn thay đổi quản lý.");
                    return true;
                }
                default: {
                    System.out.println("Không hợp lệ. Mời nhập lại!");
                }
            }
        } while (true);
    }

    // 3. Thêm thông tin 1 nhân sự
    public void addEmployee(Scanner sc) {
        System.out.println("THÊM MỘT NHÂN SỰ");
        Employee employee = choseEmployeeType(sc);
        if (employee == null) return;
        employee.enterInfo(sc);
        employees.add(employee);
        System.out.println("Thêm thành công.");
    }

    public Employee choseEmployeeType(Scanner sc) {
        Employee employee = null;
        System.out.println("Chức vụ:");
        System.out.println("1. Giám đốc");
        System.out.println("2. Trưởng phòng");
        System.out.println("3. Nhân viên thường");
        System.out.println("0. Hủy thêm");
        int choice = 0;
        do {
            System.out.print("Lựa chọn chức vụ: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: {
                    employee = new Director();
                }
                break;
                case 2: {
                    employee = new Manager();
                }
                break;
                case 3: {
                    employee = new Staff();
                }
                break;
                case 0: {
                    System.out.println("Hủy thêm nhân viên");
                }
                break;
                default: {
                    System.out.println("Lựa chọn không hợp lệ! Mời nhập lại");
                }
            }
        } while (!(choice >= 0 && choice <= 3));
        return employee;
    }

    // 4. Xóa nhân sự
    public void removeEmployee(Scanner sc) {
        System.out.println("XÓA THÔNG TIN MỘT NHÂN SỰ");
        System.out.print("Nhập mã nhân viên: ");
        String idEmployee = sc.nextLine();
        Employee employee = findEmployee(idEmployee);
        if (employee == null) {
            System.out.println("Không tìm thấy nhân viên với mã: " + idEmployee);
            return;
        } else if (employee instanceof Director) {
            System.out.println("Không thể xóa giám đốc.");
        } else {
            employee.handleBeforeDeletion();
            employees.remove(employee);
            System.out.println("Xóa thành công!");
        }
    }

    // 5. Xuất thông tin toàn bộ nhân viên trong công ty
    public void showInfoEmployeesInCompany() {
        System.out.println("THÔNG TIN TOÀN BỘ NHÂN VIÊN TRONG CÔNG TY");
        System.out.println("---------------------------");
        for (Employee employee : employees) {
            employee.showInfo();
            System.out.println("---------------------------");
        }
    }

    // 6. Tính tổng lương của công ty
    public void calculateTotalSalary() {
        System.out.println("TỔNG LƯƠNG CỦA CÁC NHÂN VIÊN TRONG CÔNG TY");
        this.setSalaryTotal();
        System.out.println("Tổng lương của toàn bộ nhân viên trong công ty: " + this.getSalaryTotal());
    }

    // 7. Tìm nhân viên thường có lương cao nhất
    public void findStaffWithLargestSalary() {
        System.out.println("NHÂN VIÊN THƯỜNG CÓ LƯƠNG CAO NHẤT");
        Staff staffWithLargestSalary = null;
        double salary = 0;
        for (Employee employee : employees) {
            if (employee instanceof Staff && ((Staff) employee).calSalary() > salary) {
                staffWithLargestSalary = (Staff) employee;
                salary = ((Staff) employee).calSalary();
            }
        }
        if (salary == 0) {
            System.out.println("Chưa có nhân viên thường hoặc các nhân viên chưa có công.");
        } else {
            System.out.println("Mã nhân viên thường: " + staffWithLargestSalary.getId());
            System.out.println("Số lương: " + salary);
        }
    }

    // 8. Tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất
    public void findManagerWithLargestStaffs() {
        System.out.println("TRƯỞNG PHÒNG CÓ SỐ LƯỢNG NHÂN VIÊN DƯỚI QUYỀN NHIỀU NHẤT");
        Manager managerMax = null;
        int count = 0;
        for (Employee employee : employees) {
            if (employee instanceof Manager && ((Manager) employee).getStaffCount() > count) {
                managerMax = (Manager) employee;
                count = ((Manager) employee).getStaffCount();
            }
        }
        if (count == 0) {
            System.out.println("Chưa có trưởng phòng hoặc các trưởng phòng chưa quản lý nhân viên nào.");
        } else {
            System.out.println("Mã trưởng phòng: " + managerMax.getId());
            System.out.println("Số lượng nhân viên dưới quyền: " + count);
        }
    }

    // 9. Sắp xếp nhân viên theo ABC
    public void sortEmployeesByName() {
        System.out.println("SẮP XẾP NHÂN VIÊN THEO TÊN (ALPHABET)");
        System.out.println("---------------------------");
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên đang trống");
            return;
        }
        this.employees
                .stream()
                .filter(employee -> employee != null && employee.getName() != null)
                .sorted((employee1, employee2) -> employee1.getName().compareTo(employee2.getName()))
                .forEach(employee -> {
                    employee.showInfo();
                    System.out.println("---------------------------");
                });
    }

    // 10. Sắp xếp nhân viên theo lương giảm dần
    public void sortEmployeesBySalaryDESC() {
        System.out.println("SẮP XẾP NHÂN VIÊN THEO LƯƠNG GIẢM DẦN");
        System.out.println("---------------------------");
        if (employees.isEmpty()) {
            System.out.println("Danh sách nhân viên đang trống");
            return;
        }
        this.employees
                .stream()
                .filter(employee -> employee != null && employee.getWorkingDays() != 0)
                .sorted((employee1, employee2) -> Double.compare(employee2.calSalary(), employee1.calSalary()))
                .forEach(employee -> {
                    employee.showInfo();
                    System.out.println("---------------------------");
                });
    }

    // 11. Tìm giám đốc có số lượng cổ phần nhiều nhất
    public void findDirectorWithLargestStock() {
        System.out.println("GIÁM ĐỐC CÓ SỐ LƯỢNG CỔ PHẦN NHIỀU NHẤT");
        Director directorMax = null;
        double stock = 0;
        for (Employee employee : employees) {
            if (employee instanceof Director && ((Director) employee).getCompanyStock() > stock) {
                directorMax = (Director) employee;
                stock = ((Director) employee).getCompanyStock();
            }
        }
        if (stock == 0) {
            System.out.println("Chưa có giám đốc hoặc các giám đốc chưa có cổ phần.");
        } else {
            System.out.println("Mã giám đốc: " + directorMax.getId());
            System.out.println("Số lượng cổ phần: " + stock + "%");
        }
    }

    // 12. Tổng thu nhập của các giám đốc
    public void calTotalDirectorSalary(Scanner sc) {
        if (monthlyRevenue == 0d) {
            System.out.println("Bạn cần nhập thông tin của công ty trước.");
            setInfoCompany(sc);
        }
        System.out.println("TỔNG THU NHẬP CỦA CÁC GIÁM ĐỐC");
        for (Employee employee : employees) {
            if (employee instanceof Director) {
                ((Director) employee).calTotalIncome(monthlyRevenue - this.getSalaryTotal());
                System.out.println("Giám đốc với mã: " + employee.getId());
                System.out.println("Có tổng thu nhập: " + ((Director) employee).getTotalIncome());
            }
        }
    }
}
