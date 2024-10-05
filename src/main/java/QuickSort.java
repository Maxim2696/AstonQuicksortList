import java.util.Comparator;

/**
 * This class for quick sorting of the passed array
 * @param <T> - the type of items to be sorted
 */
public class QuickSort<T> {
    private final T[] sortElementData;
    private final int size;

    /**
     * Creates an instance of the class with transmitted array
     * @param sortElementData - array for sorted
     */
    public QuickSort(Object[] sortElementData, int size) {
        this.sortElementData = (T[]) new Object[size];
        System.arraycopy(sortElementData, 0, this.sortElementData, 0, size);
        this.size = size;
    }

    private void quickSort(Comparator<T> comparator, int low, int high) {
        if (low >= high) return;
        int middle = low + (high - low) / 2;
        T pivot = sortElementData[middle];
        int i = low;
        int j = high;
        while (i <= j) {
            while (comparator.compare(sortElementData[i], pivot) < 0) i++;
            while (comparator.compare(sortElementData[j], pivot) > 0) j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(comparator, low, j);
        }
        if (high > i) quickSort(comparator, i, high);
    }

    private void swap(int i, int j) {
        T temp = sortElementData[i];
        sortElementData[i] = sortElementData[j];
        sortElementData[j] = temp;
    }

    /**
     * Return sorted transmitted array
     * @return sorted transmitted array
     */
    public Object[] getSortElementData(Comparator<T> comparator) {
        quickSort(comparator, 0, size - 1);
        return sortElementData;
    }
}
