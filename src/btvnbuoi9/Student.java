package btvnbuoi9;

public class Student {
    private String id;
    private String fullName;
    private double score;

    public Student() {}
    public Student(String id, String fullName, double score) {
        this.id = id;
        this.fullName = fullName;
        this.score = score;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void showInfo() {
        System.out.println("Mã sinh viên: " + this.id);
        System.out.println("Họ tên sinh viên: " + this.fullName);
        System.out.println("Điểm thi: " + this.score);
    }
}
