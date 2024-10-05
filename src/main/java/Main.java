import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(22);
        list.add(0);
        list.add(10);
        list.add(-2);
        list.add(8);
        list.add(50);
        list.add(50);
        list.add(50);
        list.add(50);
        list.add(50);

        list.remove(4);

        System.out.println(Arrays.toString(list.toArray()) + " - " + list.size());
        list.quickSort(Integer::compareTo);
        System.out.println(Arrays.toString(list.toArray()));

        System.out.println(list.size());

        MyArrayList<Integer> secondList = new MyArrayList<>();
        secondList.add(100);
        secondList.add(200);
        list.addAll(secondList);

        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.size());
    }
}
