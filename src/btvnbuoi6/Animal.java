package btvnbuoi6;

import java.util.Scanner;

public class Animal {
    private String name;
    private int age;
    public String specieName = "động vật";
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void action() {
        System.out.println("Animal action");
    }
    public void inputInfo() {
        System.out.print("Nhập tên " + specieName + ": ");
        this.setName(new Scanner(System.in).nextLine());
        System.out.print("Nhập tuổi " + specieName + ": ");
        this.setAge(new Scanner(System.in).nextInt());
    }
    public void showInfo() {
        System.out.println("Tên: " + this.name + "\nTuổi: " + this.age);
    }
}
