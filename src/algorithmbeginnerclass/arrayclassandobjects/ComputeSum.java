package algorithmbeginnerclass.arrayclassandobjects;

public class ComputeSum {

    public int sum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int s = 0;
        for (int x : array) {
            s += x;
        }
        return s;
    }
}
