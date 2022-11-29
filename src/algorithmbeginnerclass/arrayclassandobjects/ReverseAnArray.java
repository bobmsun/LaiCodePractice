package algorithmbeginnerclass.arrayclassandobjects;

public class ReverseAnArray {

    public void reverse(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
