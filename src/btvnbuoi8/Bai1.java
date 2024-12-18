package btvnbuoi8;

import java.util.Scanner;

public class Bai1 {
    public static void inputCompanyEmployee(Company company) {
        Director director = new Director("D1", "director1", "0123", 30, 50);
        company.addEmployee(director);
        Manager manager2 = new Manager("M2", "manager2", "0123", 24);
        Manager manager = new Manager("M1", "manager1", "0123", 21);
        company.addEmployee(manager);
        company.addEmployee(manager2);
        Staff staff3 = new Staff("S3", "staff3", "0123", 2);
        Staff staff2 = new Staff("S2", "staff2", "0123", 5);
        Staff staff = new Staff("S1", "staff1", "0123", 12);
        company.addEmployee(staff);
        company.addEmployee(staff2);
        company.addEmployee(staff3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Company company = new Company();

        // Nhập sẵn dữ liệu (Có thể xóa và tự nhập tay)
        inputCompanyEmployee(company);
        // Chương trình
        byte option = 0;
        do {
            System.out.println("\n*=================== MENU ===================*");
            System.out.println("1. Nhập thông tin công ty");
            System.out.println("2. Phân bổ nhân viên vào trưởng phòng");
            System.out.println("3. Thêm thông tin một nhân sự");
            System.out.println("4. Xóa thông tin một nhân sự");
            System.out.println("5. Xuất ra thông tin toàn bộ nhân viên trong công ty");
            System.out.println("6. Tính và xuất tổng lương cho công ty");
            System.out.println("7. Tìm nhân viên thường có lương cao nhất");
            System.out.println("8. Tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất");
            System.out.println("9. Sắp xếp nhân viên toàn công ty theo thứ tự ABC");
            System.out.println("10. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần");
            System.out.println("11. Tìm và xuất ra giám đốc có số lượng cổ phần nhiều nhất");
            System.out.println("12. Tính và xuất tổng thu nhập của từng giám đốc");
            System.out.println("0. Thoát");
            System.out.print("\nNhập lựa chọn: ");
            option = Byte.parseByte(sc.nextLine());
            switch (option) {
                case 0: {
                    System.out.println("Thoát chương trình");
                }
                break;
                case 1: {
                    company.setInfoCompany(sc);
                }
                break;
                case 2: {
                    company.allocateStaffToManager(sc);
                }
                break;
                case 3: {
                    company.addEmployee(sc);
                }
                break;
                case 4: {
                    company.removeEmployee(sc);
                }
                break;
                case 5: {
                    company.showInfoEmployeesInCompany();
                }
                break;
                case 6: {
                    company.calculateTotalSalary();
                }
                break;
                case 7: {
                    company.findStaffWithLargestSalary();
                }
                break;
                case 8: {
                    company.findManagerWithLargestStaffs();
                }
                break;
                case 9: {
                    company.sortEmployeesByName();
                }
                break;
                case 10: {
                    company.sortEmployeesBySalaryDESC();
                }
                break;
                case 11: {
                    company.findDirectorWithLargestStock();
                }
                break;
                case 12: {
                    company.calTotalDirectorSalary(sc);
                }
                break;
                default: {
                    System.out.println("Lựa chọn không hợp lệ!\n");
                }
            }
        } while (option != 0);
    }
}
