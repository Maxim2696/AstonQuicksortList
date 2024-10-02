import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(-5);
        list.add(22);
        list.add(0);
        list.add(10);
        list.add(-2);
        list.add(8);
        System.out.println(Arrays.toString(list.toArray()));
        list.quickSort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(list.toArray()));
    }
}
