package btvnbuoi6;

import java.util.Arrays;
import java.util.Scanner;

public class ManagerAnimal {
    public static Animal[] animals;
    public static int total;
    final static int PLUS = 2;

    public static void main(String[] args) {
        System.out.print("Nhập vào số lượng động vật: ");
        total = new Scanner(System.in).nextInt();
        animals = new Animal[total];
        System.out.println("Số lượng động vật trong sở thú là " + total + " con");
        inputAnimal(animals);

    }
    public static void showAnimalList(Animal[] animals, int total) {
        System.out.println("*--- Hiển thị danh sách động vật ---*");
        for (int i = 0; i < total; i++) {
            if (animals[i] != null) {
                animals[i].showInfo();
            }
        }
        System.out.println("*-----------------------------------*");
    }
    public static void inputAnimal(Animal[] animals) {
        int luaChon;
        int i = 0;
        do {
            System.out.println("\n*--- MENU ---*");
            System.out.println("1. Nhập vào Lion\n2. Nhập vào Elephant\n3. Nhập vào Monkey\n4. Dừng nhập vào\n5. Hiển thị danh sách động vật\n6. Tìm kiếm\n7. Xóa con vật theo tên\n0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            luaChon = new Scanner(System.in).nextInt();
            switch (luaChon) {
                case 1:{
                    if (!(i >= total)) {
                        System.out.println("Con thứ " + (i+1) + "/" + total + " con");
                        animals[i] = new Lion();
                        animals[i].inputInfo();
                        i++;
                    } else {
                        extendAnimal(animals);
                    }
                } break;
                case 2:{
                    if (!(i >= total)) {
                        System.out.println("Con thứ " + (i+1) + "/" + total + " con");
                        animals[i] = new Elephant();
                        animals[i].inputInfo();
                        i++;
                    } else {
                        extendAnimal(animals);
                    }
                } break;
                case 3:{
                    if (!(i >= total)) {
                        System.out.println("Con thứ " + (i+1) + "/" + total + " con");
                        animals[i] = new Monkey();
                        animals[i].inputInfo();
                        i++;
                    } else {
                        extendAnimal(animals);
                    }
                } break;
                case 4:{
                    System.out.println("Dừng nhập!");
                } break;
                case 5:{
                    showAnimalList(animals, total);
                } break;
                case 6:{
                    findAnimal(animals);
                } break;
                case 7:{
                    removeAnimal(animals);
                } break;
                case 0:{
                    System.out.println("Thoát chương trình!");
                } break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (!(luaChon == 0));
    }
    public static Animal[] extendTotal(Animal[] animals, int plus) {
        total = total + plus;
        Animal[] newAnimals = new Animal[total];
        for (int i = 0; i < animals.length; i++) {
            newAnimals[i] = animals[i];
        }
        return newAnimals;
    }
    public static void extendAnimal(Animal[] animals) {
        byte s = 0;
        do {
            System.out.println("Danh sách đã đầy bạn có muốn mở rộng thêm không\n0. Không\n1. Có");
            System.out.print("Nhập lựa chọn: ");
            s = new Scanner(System.in).nextByte();
            switch (s) {
                case 0:{
                    System.out.println("Không mở rộng!");
                } break;
                case 1:{
                    animals = extendTotal(animals, PLUS);
                    System.out.println("Tổng số lượng động vật sau khi thêm là " + animals.length + " con");
                } break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (!(s == 0 || s == 1));
    }
    public static void findAnimal(Animal[] animals) {
        System.out.print("Nhập tên con vật cần tìm: ");
        String nameInput = new Scanner(System.in).nextLine();
        boolean result = false;
        for (int i = 0; i < animals.length; i++) {
            if (!nameInput.equalsIgnoreCase(animals[i].getName())) {
                continue;
            } else {
                result = true;
                System.out.println("Tìm thấy!");
                animals[i].showInfo();
                break;
            }
        }
        if (!result) {
            System.out.println("Không tìm thấy!");
        }
    }
    public static void removeAnimal(Animal[] animals) {
        System.out.print("Nhập tên con vật cần xóa: ");
        String nameInput = new Scanner(System.in).nextLine();
        boolean result = false;
        for (int i = 0; i < animals.length; i++) {
            if (!nameInput.equalsIgnoreCase(animals[i].getName())) {
                continue;
            } else {
                result = true;
                for (int j = i; j < animals.length - 1; j++) {
                    animals[j].setName(animals[j+1].getName());
                    animals[j].setAge(animals[j+1].getAge());
                }
                animals[animals.length-1] = null;
                System.out.println("Xóa thành công!");
                break;
            }
        }
        if (!result) {
            System.out.println("Con vật bạn muốn xóa không tồn tại!");
        }
    }
}
