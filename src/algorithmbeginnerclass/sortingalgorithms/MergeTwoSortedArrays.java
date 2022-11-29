package algorithmbeginnerclass.sortingalgorithms;

public class MergeTwoSortedArrays {

    public int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                result[k] = array1[i];
                i++;
            } else {
                result[k] = array2[j];
                j++;
            }
            k++;
        }

        // if we still have some elements at left side, we need to copy them
        while (i < array1.length) {
            result[k] = array1[i];
            i++;
            k++;
        }
        // if we still have some elements at right side, we need to copy them
        while (j < array2.length) {
            result[k] = array2[j];
            j++;
            k++;
        }
        return result;
    }
}
