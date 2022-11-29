package algorithmclass.recursionIandsortingalgorithm;

import java.util.Arrays;

public class MergeSort_9 {

    // Method 1 (for beginners)
    public int[] mergeSort(int[] array) {
        // check null array first.
        if (array == null || array.length <= 1) {
            return array;
        }
        return mergeSort(array, 0, array.length - 1);
    }

    private int[] mergeSort(int[] array,  int left, int right) {
        if (left == right) {
            return new int[]{array[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftResult = mergeSort(array, left, mid);
        int[] rightResult = mergeSort(array, mid + 1, right);
        return merge(leftResult, rightResult);
    }

    private int[] merge(int[] leftResult, int[] rightResult) {
        int[] result = new int[leftResult.length + rightResult.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        while (leftIndex < leftResult.length && rightIndex < rightResult.length) {
            if (leftResult[leftIndex] <= rightResult[rightIndex]) {
                result[resultIndex] = leftResult[leftIndex];
                leftIndex++;
            } else {
                result[resultIndex] = rightResult[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        while (leftIndex < leftResult.length) {
            result[resultIndex] = leftResult[leftIndex];
            leftIndex++;
            resultIndex++;
        }
        while (rightIndex < rightResult.length) {
            result[resultIndex] = rightResult[rightIndex];
            rightIndex++;
            resultIndex++;
        }
        return result;
    }
}

// Method 2 (better, using a helper array)
class MergeSort_9_2 {
    public int[] mergeSort(int[] array) {
        // check null array first.
        if (array == null) {
            return array;
        }
        // allocate helper array to helper merge step,
        // so that we guarantee no more than O(n) space is used.
        // The space complexity is O(n) in this case.
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        // copy the content to helper array and we will merge from the
        // helper array.
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                array[left++] = helper[leftIndex++];
            } else {
                array[left++] = helper[rightIndex++];
            }
        }
        // if we still have some elements at left side, we need to copy them
        while (leftIndex <= mid) {
            array[left++] = helper[leftIndex++];
        }
        // if there are some elements on the right side, we do not need to copy them
        // because they are already in their position.
    }

    public static void main(String[] args) {
        MergeSort_9_2 solution = new MergeSort_9_2();

        // test cases to cover possible situations.
        int[] array = null;
        array = solution.mergeSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] { 1, 2, 3, 4 };
        array = solution.mergeSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] { 4, 3, 2, 1 };
        array = solution.mergeSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] { 2, 4, 1, 5, 3 };
        array = solution.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
