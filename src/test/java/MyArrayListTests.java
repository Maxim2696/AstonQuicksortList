import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.function.BooleanSupplier;


public class MyArrayListTests {
    private final MyArrayList<Integer> list = new MyArrayList<>();
    private final MyArrayList<Integer> secondList = new MyArrayList<>();
    {
        list.add(5);
        list.add(-5);
        list.add(22);
        list.add(0);
        list.add(10);
        list.add(-2);
        list.add(8);
        secondList.addAll(list);
    }

    @Test
    void testSize() {
        Assertions.assertEquals(7, list.size());
    }
    @Test
    void testIsEmpty() {
        Assertions.assertFalse(new BooleanSupplier() {
            @Override
            public boolean getAsBoolean() {
                return list.isEmpty();
            }
        });
    }
    @Test
    void testContains() {
        Assertions.assertTrue(list.contains(5));
    }
    private class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
    @Test
    void testQuickSort() {
        Collections.sort(secondList);
        list.quickSort(new MyComparator());
        Assertions.assertArrayEquals(secondList.toArray(), list.toArray());
    }
    @Test
    void testAdd() {
        list.add(25);
        Assertions.assertEquals(25, list.get(list.size() - 1));
    }
    @Test
    void testAddInIndex() {
        list.add(5, 500);
        Assertions.assertEquals(500, list.get(5));
    }
    @Test
    void testGetOfIndex() {
        Assertions.assertEquals(5, list.get(0));
    }
    @Test
    void testRemove() {
        int size = list.size();
        int value = list.get(0);
        list.remove(0);
        Assertions.assertAll("Remove element" ,
                () -> Assertions.assertEquals(size - 1, list.size()),
                () -> Assertions.assertNotEquals(value, list.get(0)));
    }
    @Test
    void testClear() {
        list.clear();
        Assertions.assertTrue(list.isEmpty());
    }
}
