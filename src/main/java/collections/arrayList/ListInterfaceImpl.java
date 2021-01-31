package collections.arrayList;

public interface ListInterfaceImpl<E> {

    void add(E e);

    E get(int index);

    int size();

    void displayAll();

    E remove(int index);

    boolean removeEle(E e);

    int getIndex(E e);
}
