package Progress_250414.collection.list;

public interface MyList <E>{
    int size();

    void add (E e);

    void add (int idx, E e);

    E get(int index);

    E set(int index, E element);

    E remove(int idx);

    int indexOf(E o);

}
