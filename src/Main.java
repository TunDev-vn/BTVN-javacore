import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(2);
        list.add(4);

        list.addAll(nums);
        showList(list);

        Iterator<Integer> iterator = list.iterator();
        System.out.println(iterator.hasNext());
    }

    private static void showList(ArrayList<Integer> list) {
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}

