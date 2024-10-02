import java.util.*;

/**
 * MyArrayList<T> наследуется от интерфейса List<T> и реализует его базовые методы.
 * В особенностях, добавлена "быстрая сортировка".
*/

public class MyArrayList<T> implements List<T> {
    private final List<T> list;

    /**
     * Создает экземпляр класс с переданным типом
     */
    public MyArrayList() {
        list = new ArrayList<>();
    }

    private void quickSort(Comparator<T> comparator, int low, int high) {
        if (low >= high) return;
        int middle = low + (high - low) / 2;
        T pivot = list.get(middle);
        int i = low;
        int j = high;
        while (i <= j) {
            while (comparator.compare(list.get(i), pivot) < 0) i++;
            while (comparator.compare(list.get(j), pivot) > 0) j--;
            if (i <= j) {
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(comparator, low, j);
        }
        if (high > i) quickSort(comparator, i, high);
    }

    /**
     * Сортирует массив по переданному Comparator
     * @param comparator = по нему сравниваются объекты списка
     */
    public void quickSort(Comparator<T> comparator) {
        quickSort(comparator, 0, size() - 1);
    }

    /**
     * Размер списка
     * @return value
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Проверяет список на отсутствие элементов
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * looking for element in this list
     * @param o element whose presence in this list is to be tested
     * @return true if element in this list
     */
    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    /**
     * Return an iterator of this list
     * @return an iterator of this list
     */
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    /**
     * Return a list as array
     * @return a list as array Objects
     */
    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    /**
     *
     * @param a the array into which the elements of this list are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return a list as typed array
     * @param <T1> - the type of our list
     */
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return list.toArray(a);
    }

    /**
     * Add an element in this list
     * @param t element whose presence in this collection is to be ensured
     * @return true if element has been added
     */
    @Override
    public boolean add(T t) {
        return list.add(t);
    }

    /**
     * Remove element out of this list
     * @param o element to be removed from this list, if present
     * @return true if element has been removed
     */
    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    /**
     * Checks whether the collection is included in this list
     * @param c collection to be checked for containment in this list
     * @return true if this list contains all elements of Collection
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    /**
     * Add all elements of Collection in this list
     * @param c collection containing elements to be added to this collection
     * @return if this list changed as a result of the call
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        return list.addAll(c);
    }

    /**
     * Add all elements of Collection into this list at the specified position(index)
     * @param index index at which to insert the first element from the
     *              specified collection
     * @param c collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return list.addAll(index, c);
    }

    /**
     * Removes from this list all of its elements that are contained in the specified collection (optional operation).
     * @param c collection containing elements to be removed from this list
     * @return true if this list changed as a result of the call
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection (optional operation).
     * In other words, removes from this list all of its elements that are not contained in the specified collection.
     * @param c collection containing elements to be retained in this list
     * @return true if this list changed as a result of the call
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    /**
     * Removes all elements from this list
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Give you the element from list at the specified position
     * @param index index of the element to return
     * @return the element from list at the specified position
     */
    @Override
    public T get(int index) {
        return list.get(index);
    }

    /**
     * Replaces the element at the specified position in this list with the specified element (optional operation).
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public T set(int index, T element) {
        return list.set(index, element);
    }

    /**
     *  Inserted the element into this list at the specified position
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, T element) {
        list.add(index, element);
    }

    /**
     * Remove the element from this list at the specified position
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
    @Override
    public T remove(int index) {
        return list.remove(index);
    }

    /**
     * Returned the index of the first occurrence of the specified element in this list.
     * Or -1 if this list doesn't contain the element
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in this list.
     * Or -1 if this list doesn't contain the element
     */
    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    /**
     * Returned the index of the last occurrence of the specified element in this list.
     * Or -1 if this list doesn't contain the element
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in this list.
     * Or -1 if this list doesn't contain the element
     */
    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    /**
     * Returned ListIterator over the element
     * @return ListIterator over the element
     */
    @Override
    public ListIterator<T> listIterator() {
        return list.listIterator();
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list.
     * @param index index of the first element to be returned from the
     *        list iterator (by a call to {@link ListIterator#next next})
     * @return a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list.
     */
    @Override
    public ListIterator<T> listIterator(int index) {
        return list.listIterator(index);
    }

    /**
     * Returned a list with specified range of this list
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     */
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }
}
