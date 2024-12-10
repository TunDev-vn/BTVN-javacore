package btvnbuoi6;

public class Lion extends Animal {
    public Lion() {
        this.specieName = "con hổ";
    }
    @Override
    public void action() {
        System.out.println("The lion is hunting.");
    }

    @Override
    public void showInfo() {
        System.out.println("Thông tin con hổ:");
        super.showInfo();
    }
    @Override
    public void inputInfo() {
        super.inputInfo();
    }
}
