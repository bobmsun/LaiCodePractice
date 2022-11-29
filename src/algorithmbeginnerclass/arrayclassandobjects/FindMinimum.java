package algorithmbeginnerclass.arrayclassandobjects;

public class FindMinimum {

    public int min(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int m = array[0];
        for (int i = 1; i < array.length; i++) {
            m = array[i] < m ? array[i] : m;
        }
        return m;
    }
}
