package pro.skypro.course2.lesson14;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private static final int DEFAULT_CAPACITY = 8;

    private String[] data;
    private int size;

    public StringListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public StringListImpl(int capacity) {
        this.data = new String[capacity];
    }

    @Override
    public String add(String item) {
        checkNotNull(item);
        checkCapacity();
        data[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkNotNull(item);
        checkIndex(index);
        checkCapacity();
        System.arraycopy(data, index, data, index + 1, data.length - index);
        data[size++] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkNotNull(item);
        checkIndex(index);
        data[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        checkNotNull(item);
        checkItemExists(item);
        int index = indexOf(item);
        removeItem(index);
        return item;
    }

    private void removeItem(int index) {
        if (size - 1 > index) {
            System.arraycopy(data, index + 1, data, index, data.length - index);
        }
        data[--size] = null;
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String item = get(index);
        removeItem(index);
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) >= 0;
    }

    @Override
    public int indexOf(String item) {
        checkNotNull(item);
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkNotNull(item);
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            return false;
        }
        return Arrays.equals(data, otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        data = new String[DEFAULT_CAPACITY];
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(data, data.length);
    }

    private String[] grow() {
        return Arrays.copyOf(data, size * 2);
    }

    private void checkCapacity() {
        if (size == data.length) {
            data = grow();
        }
    }

    private void checkNotNull(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Not null item value is required!");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be positive and less than " + size);
        }
    }

    private void checkItemExists(String item) {
        if (indexOf(item) == -1) {
            throw new IllegalArgumentException("Passed item does not exist in the list: " + item);
        }
    }

}
