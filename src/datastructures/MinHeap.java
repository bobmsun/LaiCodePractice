package datastructures;

import java.util.NoSuchElementException;

public class MinHeap {

    private int[] array;
    private int size;

    public MinHeap(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input array can not be null or empty");
        }
        this.array = array;
        size = array.length;
        heapify();
    }

    private void heapify() {
        int lastNonLeafIndex = size / 2 - 1;
        for (int i = lastNonLeafIndex; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public MinHeap(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("capacity can not be <= 0");
        }
        array = new int[cap];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    private void percolateDown(int index) {
        while (2 * index + 1 < size) {
            int swapCandidateIndex = 2 * index + 1;
            if (2 * index + 2 < size && array[2 * index + 2] < array[swapCandidateIndex]) {
                swapCandidateIndex = 2 * index + 2;
            }
            if (array[index] <= array[swapCandidateIndex]) {
                break;
            } else {
                swap(index, swapCandidateIndex);
                index = swapCandidateIndex;
            }
        }
    }

    private void percolateUp(int index) {
        while ((index - 1) / 2 >= 0) {
            if (array[(index - 1) / 2] > array[index]) {
                swap((index - 1) / 2, index);
                index = (index - 1) / 2;
            } else {
                break;
            }
        }
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        return array[0];
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        // what if size == 0?
        int result = array[0];
        array[0] = array[size - 1];
        size -= 1;
        percolateDown(0);
        return result;
    }

    public void offer(int ele) {
        if (size == array.length) {
            int[] newArray = new int[(int)(array.length * 1.5)];
            // copy(array, newArray);
            array = newArray;
        }
        array[size] = ele;
        size += 1;
        percolateUp(size - 1);
    }

    public int update(int index, int ele) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("invalid index range");
        }
        int result = array[index];
        array[index] = ele;
        if (ele < result) {
            percolateUp(index);
        } else if (ele > result) {
            percolateDown(index);
        }
        return result;
    }

    private void swap(int l, int r) {
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }

}
