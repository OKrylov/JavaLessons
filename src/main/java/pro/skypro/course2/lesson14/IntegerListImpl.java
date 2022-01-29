package pro.skypro.course2.lesson14;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private static final int DEFAULT_CAPACITY = 8;

    private Integer[] data;
    private int size;

    public IntegerListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public IntegerListImpl(int capacity) {
        this.data = new Integer[capacity];
    }

    @Override
    public Integer add(Integer item) {
        checkNotNull(item);
        checkCapacity();
        data[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkNotNull(item);
        checkIndex(index);
        checkCapacity();
        System.arraycopy(data, index, data, index + 1, data.length - index);
        data[size++] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkNotNull(item);
        checkIndex(index);
        data[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        checkNotNull(item);
        checkItemExists(item);
        checkCapacity();
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
    public Integer remove(int index) {
        checkIndex(index);
        Integer item = get(index);
        removeItem(index);
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        sort();
        return binarySearch(item);
    }

    @Override
    public int indexOf(Integer item) {
        checkNotNull(item);
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkNotNull(item);
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
        data = new Integer[DEFAULT_CAPACITY];
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(data, data.length);
    }

    private Integer[] grow() {
        return Arrays.copyOf(data, (int) (size * 1.5));
    }
    private Integer[] resize() {
        return Arrays.copyOf(data, (data.length * 2 / 3));
    }

    private void checkCapacity() {
        if (size == data.length) {
            data = grow();
        } else if (size < data.length / 2) {
            data = resize();
        }
    }

    private void checkNotNull(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Not null item value is required!");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be positive and less than " + size);
        }
    }

    private void checkItemExists(Integer item) {
        if (indexOf(item) == -1) {
            throw new IllegalArgumentException("Passed item does not exist in the list: " + item);
        }
    }

    private void sort() {
        SortUtils.quickSort(data);
    }

    private boolean binarySearch(Integer item) {
        checkNotNull(item);
        int min = 0;
        int max = data.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(data[mid])) {
                return true;
            }

            if (item < data[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
