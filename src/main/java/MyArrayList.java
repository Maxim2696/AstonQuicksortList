import java.util.*;

/**
 * MyArrayList<T> extends MyAbstractList<T>, works as a ArrayList, also contains a quickSort method
*/

public class MyArrayList<T> extends MyAbstractList<T> {
    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULT_EMPTY_ELEMENT_DATA = {};

    /**
     * Creates an instance of the class
     */
    public MyArrayList() {
        elementData = DEFAULT_EMPTY_ELEMENT_DATA;
    }

    /**
     * Сreates an instance of the class of the required size
     * @param capacityArray - size create of the list
     * @throws IllegalArgumentException - if capacityArray < 0;
     */
    public MyArrayList(int capacityArray) {
        if (capacityArray > 0) {
            this.elementData = new Object[capacityArray];
        }
        else if (capacityArray == 0) {
            this.elementData = DEFAULT_EMPTY_ELEMENT_DATA;
        }
        else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacityArray);
        }
    }


    /**
     * Sorted list with Comparator
     * @param comparator = compare for item
     */
    public void quickSort(Comparator<T> comparator) {
        QuickSort<T> sort = new QuickSort<>(elementData, size);
        System.arraycopy(sort.getSortElementData(comparator), 0, elementData, 0, size);

    }
    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != DEFAULT_EMPTY_ELEMENT_DATA) {
            int newCapacity = oldCapacity + (oldCapacity / 2);
            return Arrays.copyOf(elementData, newCapacity);
        }
        else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }
    private Object[] grow() {return grow(size + 1);}

    /**
     * Add an element in this list
     * @param element whose presence in this collection is to be ensured
     * @return true if element has been added
     */
    @Override
    public boolean add(T element) {
        if (size == elementData.length) {
            elementData = grow();
        }
        elementData[size] = element;
        size++;
        return true;
    }
    /**
     * Returned size of the list
     * @return value
     */
    public int size() {
        return size;
    }

    /**
     * Inserted the element into this list at the specified position
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void addInIndex(int index, T element) {
        if (index > size || index < 0) throw new ArrayIndexOutOfBoundsException();
        if (size == elementData.length) {
            elementData = grow();
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    /**
     * Give you the element from list at the specified position
     * @param index index of the element to return
     * @return the element from list at the specified position
     */
    @Override
    public T getElement(int index) {
        Objects.checkIndex(index, size);
        return (T) elementData[index];
    }

    /**
     * Removes all elements from this list
     */
    @Override
    public void clear() {
        for (int i =0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    /**
     * Сhecks the list for missing items
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return a list as array
     * @return a list as array Objects
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    /**
     * Remove the element from this list at the specified position
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T result = getElement(index);
        for (int i = index; i < size; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[size - 1] = null;
        size--;
        return result;
    }

    /**
     * looking for element in this list
     * @param o element whose presence in this list is to be tested
     * @return true if element in this list
     */
    @Override
    public boolean contains(Object o) {

        for (int i = 0; i < size; i++) {
            if (o == null && elementData[i] == null) return true;
            if (elementData[i].equals(o)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Replaces the element at the specified position in this list with the specified element (optional operation).
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public T set(int index, T element) {
        Objects.checkIndex(index, size);
        T result = (T) elementData[index];
        elementData[index] = element;
        return result;
    }

    /**
     * Add all elements of Collection in this list
     * @param list collection containing elements to be added to this collection
     */
    @Override
    public void addAll(MyAbstractList<T> list) {
        int length = list.size();
        if (length > size) {
            elementData = new Object[length];
        }
        for(int i = 0; i < length; i++) {
            elementData[i] = list.getElement(i);
            size++;
        }
    }
}
