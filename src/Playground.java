import java.util.*;
import utility.*;

public class Playground {

    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        if (array.length == 0 || k == 0) {
            return new int[0];
        }
        findKSmallestIndex(array, k, 0, array.length - 1);
        int[] kSmallest = Arrays.copyOfRange(array, 0, k);
        Arrays.sort(kSmallest);
        return kSmallest;
    }

    private int findKSmallestIndex(int[] array, int k, int start, int end) {
        System.out.println("start: " + start);
        System.out.println("k: " + k);
        if (start == end) {
            return start;
        }
        int randomPivotIndex = start + (int)(Math.random() * (end - start + 1));
        int pivot = array[randomPivotIndex];
        swap(array, randomPivotIndex, end);
        int i = start;
        int j = end - 1;
        while (i <= j) {
            if (array[i] < pivot) {
                i++;
            } else if (array[j] >= pivot) {
                j--;
            } else {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        swap(array, i, end);
        if (i - start + 1 == k) {
            return i;
        } else if (i - start + 1 > k) {
            return findKSmallestIndex(array, k, start, i - 1);
        } else {
            return findKSmallestIndex(array, k - i - 1, i + 1, end);
        }
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("a");
    //    for (int i = 0; i < list.size(); i++) {
    //        if (list.get(i).equals("a")) {
    //    list.remove(i);
    //        }
    //    }
        System.out.println(list);

        for (String str : list) {
            if (str.equals("a")) {
                str = "haha";
            }
        }

        System.out.println(list);

        Integer[] arr = {1, 2, 3, 4};
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));    // [4, 3, 2, 1]
    }
}
