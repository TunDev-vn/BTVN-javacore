package btvnbuoi6;

import java.util.Arrays;
import java.util.Scanner;

public class ManagerAnimal {
    public static void main(String[] args) {
        Animal[] animals;
        int soLuong;
        System.out.print("Nhập vào số lượng động vật: ");
        soLuong = new Scanner(System.in).nextInt();
        animals = new Animal[soLuong];
        System.out.println("Số lượng động vật trong sở thú là " + soLuong + " con");

        int result = inputAnimal(animals, soLuong, 0);
        byte s = 0;
        do {
            if (result == animals.length) {
                System.out.println("Danh sách đã đầy bạn có muốn nhập thêm không\n0. Không\n1. Có");
                System.out.print("Nhập lựa chọn: ");
                s = new Scanner(System.in).nextByte();
                switch (s) {
                    case 0:{
                        System.out.println("Hoàn thành nhập!");
                    } break;
                    case 1:{
                        animals = extendAnimal(animals, 10);
                        System.out.println("Số lượng động vật trong sở thú là " + animals.length + " con");
                        result = inputAnimal(animals, animals.length, result);
                    } break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        } while (s != 0);
        showAnimalList(animals, soLuong);
        System.out.println("Thêm 1 con vật");
    }
    public static void showInfo(Animal animal) {
        System.out.println("Tên: " + animal.getName());
        System.out.println("Tuổi: " + animal.getAge());
    }
    public static void showAnimalList(Animal[] animals, int soLuong) {
        for (int i = 0; i < soLuong; i++) {
            if (animals[i] instanceof Lion) {
                System.out.println("Thông tin con thứ " + (i+1) + ": con Hổ");
                showInfo(animals[i]);
            } else if (animals[i] instanceof Elephant) {
                System.out.println("Thông tin con thứ " + (i+1) + ": con Voi");
                showInfo(animals[i]);
            } else if (animals[i] instanceof Monkey) {
                System.out.println("Thông tin con thứ " + (i+1) + ": con Khỉ");
                showInfo(animals[i]);
            }
        }
    }
    public static Lion setLion() {
        Lion lion = new Lion();
        System.out.print("Nhập tên hổ: ");
        String name = new Scanner(System.in).next();
        System.out.print("Nhập tuổi hổ: ");
        int age = new Scanner(System.in).nextInt();
        lion.setName(name);
        lion.setAge(age);
        return lion;
    }
    public static Elephant setElephant() {
        Elephant Elephant = new Elephant();
        System.out.print("Nhập tên voi: ");
        String name = new Scanner(System.in).next();
        System.out.print("Nhập tuổi voi: ");
        int age = new Scanner(System.in).nextInt();
        Elephant.setName(name);
        Elephant.setAge(age);
        return Elephant;
    }
    public static Monkey setMonkey() {
        Monkey monkey = new Monkey();
        System.out.print("Nhập tên khỉ: ");
        String name = new Scanner(System.in).next();
        System.out.print("Nhập tuổi khỉ: ");
        int age = new Scanner(System.in).nextInt();
        monkey.setName(name);
        monkey.setAge(age);
        return monkey;
    }
    public static int inputAnimal(Animal[] animals, int soLuong, int startIndex) {
        int luaChon;
        int i = startIndex;
        do {
            System.out.println("1. Nhập vào Lion\n" + "2. Nhập vào Elephant\n" + "3. Nhập vào Monkey\n" + "4. Dừng nhập vào");
            System.out.print("Nhập lựa chọn: ");
            luaChon = new Scanner(System.in).nextInt();
            switch (luaChon) {
                case 1:{
                    System.out.println("Con thứ " + (i+1) + "/" + soLuong + " con");
                    animals[i] = setLion();
                    System.out.println("Thông tin chú hổ vừa nhập: ");
                    showInfo(animals[i]);
                    i++;
                } break;
                case 2:{
                    System.out.println("Con thứ " + (i+1) + "/" + soLuong + " con");
                    animals[i] = setElephant();
                    System.out.println("Thông tin chú voi vừa nhập: ");
                    showInfo(animals[i]);
                    i++;
                } break;
                case 3:{
                    System.out.println("Con thứ " + (i+1) + "/" + soLuong + " con");
                    animals[i] = setMonkey();
                    System.out.println("Thông tin chú khỉ vừa nhập: ");
                    showInfo(animals[i]);
                    i++;
                } break;
                case 4:{
                    System.out.println("Dừng nhập!");
                } break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (!(luaChon == 4 || i == soLuong));
        return i;
    }
    public static Animal[] extendAnimal(Animal[] animal, int them) {
        Animal[] newAnimal = Arrays.copyOf(animal, animal.length + them);
        return newAnimal;
    }
}
