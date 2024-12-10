package btvnbuoi6;

public class Monkey extends Animal{
    public Monkey() {
        this.specieName = "con khỉ";
    }
    @Override
    public void action() {
        System.out.println("The monkey is climbing trees");
    }

    @Override
    public void showInfo() {
        System.out.println("Thông tin con khỉ:");
        super.showInfo();
    }
    @Override
    public void inputInfo() {
        super.inputInfo();
    }
}
