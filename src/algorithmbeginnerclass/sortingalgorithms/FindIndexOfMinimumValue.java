package algorithmbeginnerclass.sortingalgorithms;

public class FindIndexOfMinimumValue {

    public int minIndex(int[] array, int i) {
        int minIndex = i;
        for (int j = i + 1; j < array.length; j++) {
            if (array[minIndex] > array[j]) {
                minIndex = j;
            }
        }
        return minIndex;
    }
}
