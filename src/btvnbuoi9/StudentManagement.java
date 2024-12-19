package btvnbuoi9;

import java.util.*;

public class StudentManagement {
    private final List<Student> students;
    private final Set<String> studentIds;

    public StudentManagement() {
        students = new ArrayList<>();
        studentIds = new HashSet<>();
    }

    public static void displayList(List<Student> studentList) {
        System.out.println("HIỂN THỊ DANH SÁCH SINH VIÊN");
        System.out.println("----------------------------");
        for (Student student : studentList) {
            student.showInfo();
            System.out.println("----------------------------");
        }
    }

    // 1. Thêm sinh viên
    public String enterStudentId(Scanner scanner, boolean checkExist) {
        String id;
        while (true) {
            try {
                System.out.print("Nhập mã sinh viên: ");
                id = scanner.nextLine();
                if (id == null || id.trim().isEmpty()) {
                    throw new IllegalArgumentException("Mã sinh viên không được để trống.");
                }
                id = id.trim();
                if (!id.matches("[a-zA-Z0-9]+")) {
                    throw new IllegalArgumentException("Mã sinh viên chỉ bao gồm số và kí tự.");
                }
                if (checkExist && studentIds.contains(id)) {
                    throw new IllegalArgumentException("Mã sinh viên đã tồn tại.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại.");
            }
        }
        return id;
    }

    public static String capitalizeFirstLetter(String nameInput) {
        String[] words = nameInput.split(" ");
        StringBuilder fullName = new StringBuilder();
        for (String word : words) {
            fullName.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }
        return fullName.toString().trim();
    }

    public String enterStudentName(Scanner scanner) {
        String name;
        while (true) {
            try {
                System.out.print("Nhập họ tên sinh viên: ");
                name = scanner.nextLine();
                if (name == null || name.trim().isEmpty()) {
                    throw new IllegalArgumentException("Tên sinh viên không được để trống.");
                }
                if (!name.matches("[\\p{L}\\s]+")) {
                    throw new IllegalArgumentException("Tên sinh viên chứa các ký tự không hợp lệ.");
                }
                name = capitalizeFirstLetter(name.trim().replaceAll("[ ]+", " "));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại.");
            }
        }
        return name;
    }

    public static double checkScore(String scoreStr) {
        if (scoreStr == null || scoreStr.trim().isEmpty()) {
            throw new IllegalArgumentException("Điểm thi không được để trống.");
        }
        double score;
        try {
            score = Double.parseDouble(scoreStr.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Điểm thi không hợp lệ.");
        }
        if (score < 0 || score > 10) {
            throw new IllegalArgumentException("Điểm thi nhập vào phải thuộc hệ 10.");
        }
        return score;
    }

    public double enterScore(Scanner scanner) {
        double score;
        while (true) {
            try {
                System.out.print("Nhập điểm thi: ");
                score = checkScore(scanner.nextLine());

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
                System.out.println("Vui lòng nhập lại.");
            }
        }
        return score;
    }

    public void addStudent(Scanner scanner) {
        String id, name;
        double score;
        System.out.println("THÊM SINH VIÊN");
        id = enterStudentId(scanner, true);
        name = enterStudentName(scanner);
        score = enterScore(scanner);

        students.add(new Student(id, name, score));
        studentIds.add(id);
        System.out.println("Thêm thành công.");
    }

    // 2. Xóa sinh viên
    public void deleteStudent(Scanner scanner) {
        System.out.println("XÓA SINH VIÊN");
        String id = enterStudentId(scanner, false);
        for (Student student : students) {
            if (id.equals(student.getId())) {
                students.remove(student);
                studentIds.remove(id);
                System.out.println("Xóa thành công sinh viên với mã: " + id);
                return;
            }
        }
        System.out.println("Không tồn tại sinh viên với mã: " + id);
    }

    // 3. Hiển thị danh sách sinh viên
    public void showStudents() {
        displayList(students);
    }

    // 4. Tìm kiếm sinh viên theo tên
    public void searchStudentByName(Scanner scanner) {
        System.out.println("TÌM KIẾM SINH VIÊN THEO TÊN");
        String name = enterStudentName(scanner);
        List<Student> studentsSameName = new ArrayList<>();
        for (Student student : students) {
            if (name.equalsIgnoreCase(student.getFullName())) {
                studentsSameName.add(student);
            }
        }

        if (studentsSameName.isEmpty()) {
            System.out.println("Không tồn tại sinh viên với tên: " + name);
        } else {
            System.out.println("Tìm thấy " + studentsSameName.size() + " sinh viên với tên: " + name);
            displayList(studentsSameName);
        }
    }

    // 5. Sắp xếp sinh viên theo điểm thi
    public void sortStudentsByScore() {
        System.out.println("SẮP XẾP DANH SÁCH SINH VIÊN THEO ĐIỂM THI TĂNG DẦN");
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên đang trống.");
            return;
        }

        List<Student> sortedStudents = new ArrayList<>(students);
        sortedStudents.sort((s1, s2) -> Double.compare(s1.getScore(), s2.getScore()));
        displayList(sortedStudents);
    }

    // 6. Kiểm tra sinh viên có tồn tại không
    public Student findStudentById(String idInput) {
        for (Student student : students) {
            if (idInput.equalsIgnoreCase(student.getId())) {
                return student;
            }
        }
        return null;
    }

    public void checkExsitStudent(Scanner scanner) {
        System.out.println("KIỂM TRA SINH VIÊN TỒN TẠI");
        String id = enterStudentId(scanner, false);
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Sinh viên với mã: " + id + " không tồn tại trong danh sách.");
            return;
        }
        System.out.println("Sinh viên với mã: " + id + " có tồn tại trong danh sách.");
        System.out.println("Thông tin sinh viên:");
        student.showInfo();
    }
}
