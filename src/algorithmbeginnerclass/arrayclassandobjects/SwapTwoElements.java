package algorithmbeginnerclass.arrayclassandobjects;

public class SwapTwoElements {

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
