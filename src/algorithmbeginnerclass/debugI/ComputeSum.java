package algorithmbeginnerclass.debugI;

public class ComputeSum {

    public int sum(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int s = 0;
        for (int i = 0; i < array.length; i++) {
            s += array[i];
        }
        return s;
    }
}
