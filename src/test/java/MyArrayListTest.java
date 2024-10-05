import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MyArrayListTest {

    private MyArrayList<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    @DisplayName("Checked size of list")
    void testSize() {
        list.add(5);
        list.add(2);
        int size = list.size();
        assertEquals(2, size);
    }

    @Test
    @DisplayName("Checked no empty of list")
    void testIsNoEmpty() {
        list.add(5);
        boolean noEmpty = list.isEmpty();
        assertFalse(noEmpty);
    }

    @Test
    @DisplayName("Checked empty of list")
    void testIsEmpty() {
        boolean empty = list.isEmpty();
        assertTrue(empty);
    }

    @Test
    @DisplayName("Contains element in list")
    void testContains() {
        list.add(5);
        boolean containElement = list.contains(5);
        assertTrue(containElement);
    }

    @DisplayName("QuickSort this list")
    @Test
    void testQuickSort() {
        MyArrayList<Integer> secondList = new MyArrayList<>();
        secondList.add(2);
        secondList.add(5);
        secondList.add(7);

        list.add(7);
        list.add(2);
        list.add(5);

        list.quickSort((Integer::compareTo));
        Object[] secondArray = secondList.toArray();
        Object[] listArray = list.toArray();

        assertArrayEquals(secondArray, listArray);
    }

    @Test
    @DisplayName("Add element into list")
    void testAdd() {
        list.add(25);
        int getLastElementOfList = list.getElement(list.size() - 1);
        assertEquals(25, getLastElementOfList);
    }

    @Test
    @DisplayName("Add element into list at the wrong specific position")
    void testAddInWrongIndex() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.addInIndex(50, 500));
    }

    @Test
    @DisplayName("Add element into list at the specific position")
    void testAddInIndex() {
        list.add(0);
        list.add(2);
        list.addInIndex(1, 500);
        int getAddInIndexElement = list.getElement(1);
        assertEquals(500, getAddInIndexElement);
    }

    @Test
    @DisplayName("Get an item from the list at the wrong index")
    void testGetOfWrongIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.getElement(50));
    }

    @Test
    @DisplayName("Get an item from the list")
    void testGetOfIndex() {
        list.add(5);
        list.add(0);
        int getOfIndex = list.getElement(1);
        assertEquals(0, getOfIndex);
    }

    @Test
    @DisplayName("Remove element at the wrong specific position")
    void testRemoveWrongIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
    }

    @Test
    @DisplayName("Remove element at the specific position")
    void testRemove() {
        list.add(5);
        list.add(10);
        int value = list.getElement(0);
        list.remove(0);
        assertAll("Remove element" ,
                () -> assertEquals(1, list.size()),
                () -> assertNotEquals(value, list.getElement(0)));

    }

    @Test
    @DisplayName("Get element after remove this element")
    void testGetElementAfterRemove() {
        list.add(5);
        int removeValue = list.remove(0);
        assertEquals(5, removeValue);

    }

    @Test
    @DisplayName("Clearing the list")
    void testClear() {
        list.add(5);
        list.add(10);
        list.clear();

        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Set element at the wrong specific position")
    void testWrongSet() {
            assertThrows(IndexOutOfBoundsException.class, () -> list.set(5, 10));
    }

    @Test
    @DisplayName("Set element at the specific position")
    void setElementTest() {
        list.add(5);
        list.add(10);
        list.set(1, 7);
        assertAll(() -> assertEquals(2, list.size()),
                () -> assertEquals(7, list.getElement(1)));
    }

    @Test
    @DisplayName("Given element at the specific position before set another element at the this position")
    void setAndGivenPreviousElementTest() {
        list.add(5);
        list.add(10);
        int value = list.set(1, 7);
        assertEquals(10, value);
    }

    @Test
    @DisplayName("List is as array")
    void testToArray() {
        list.add(5);
        list.add(10);
        Object[] array = list.toArray();
        Object[] arrayExpected = new Object[] {5, 10};
        assertArrayEquals(arrayExpected, array);
    }

    @Test
    @DisplayName("All elements add into list")
    void testAddAll() {
        MyArrayList<Integer> anotherList = new MyArrayList<>();
        anotherList.add(5);
        anotherList.add(10);

        list.addAll(anotherList);

        assertAll(() -> assertEquals(2, list.size()),
                () -> assertEquals(5, list.getElement(0)),
                () -> assertArrayEquals(anotherList.toArray(), list.toArray()));
    }
}
