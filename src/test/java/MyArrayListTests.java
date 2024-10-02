import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Comparator;


class MyArrayListTests {
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
    private class MyComparatorInTest implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
    @DisplayName("Checked size of list")
    @Test
    void testSize() {
        Assertions.assertEquals(7, list.size());
    }
    @DisplayName("Checked empty of list")
    @Test
    void testIsEmpty() {
        Assertions.assertFalse(list::isEmpty);
    }

    @DisplayName("Contains element in list")
    @Test
    void testContains() {
        Assertions.assertTrue(list.contains(5));
    }

    @DisplayName("QuickSort this list")
    @Test
    void testQuickSort() {
        boolean needSort = true;
        while (needSort) {
            needSort = false;
            for (int i = 1; i < secondList.size(); i++) {
                if (secondList.getElement(i) < secondList.getElement(i - 1)) {
                    int temp = secondList.getElement(i);
                    secondList.set(i, secondList.getElement(i - 1));
                    secondList.set(i - 1, temp);
                    needSort = true;
                }
            }
        }
        list.quickSort(new MyComparatorInTest());
        Assertions.assertArrayEquals(secondList.toArray(), list.toArray());
    }

    @DisplayName("Add element into list")
    @Test
    void testAdd() {
        list.add(25);
        Assertions.assertEquals(25, list.getElement(list.size() - 1));
    }
    @DisplayName("Add element into list at the specific position")
    @Test
    void testAddInIndex() {
        list.addInIndex(5, 500);
        Assertions.assertEquals(500, list.getElement(5));
    }
    @DisplayName("Get an item from the list")
    @Test
    void testGetOfIndex() {
        Assertions.assertEquals(5, list.getElement(0));
    }

    @DisplayName("Remove element at the specific position")
    @Test
    void testRemove() {
        int size = list.size();
        int value = list.getElement(0);
        list.remove(0);
        Assertions.assertAll("Remove element" ,
                () -> Assertions.assertEquals(size - 1, list.size()),
                () -> Assertions.assertNotEquals(value, list.getElement(0)),
                () -> Assertions.assertEquals(8, list.getElement(5)));

    }
    @DisplayName("Clearing the list")
    @Test
    void testClear() {
        list.clear();
        Assertions.assertTrue(list.isEmpty());
    }
}
