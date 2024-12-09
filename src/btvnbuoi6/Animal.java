package btvnbuoi6;

public class Animal {
    private String name;
    private int age;

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
    public void showInfo() {
        System.out.println("Name: " + name + " Age: " + age);
    }
}
