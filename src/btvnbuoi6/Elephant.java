package btvnbuoi6;

public class Elephant extends Animal{
    public Elephant() {
        this.specieName = "con voi";
    }
    @Override
    public void action() {
        System.out.println("The elephant is spraying water");
    }

    @Override
    public void showInfo() {
        System.out.println("Thông tin con voi:");
        super.showInfo();
    }
    @Override
    public void inputInfo() {
        super.inputInfo();
    }
}
