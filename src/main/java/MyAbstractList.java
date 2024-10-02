public abstract class MyAbstractList<T> {
    abstract boolean add(T e);
    abstract void addInIndex(int index, T e);
    abstract T getElement(int index);
    abstract void clear();
    abstract int size();
    abstract boolean isEmpty();
    abstract Object[] toArray();
    abstract T remove(int index);
    abstract boolean contains(Object o);
    abstract T set(int index, T element);
    abstract void addAll(MyAbstractList<T> list);
}
