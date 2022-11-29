package algorithmbeginnerclass.arrayclassandobjects;

public class SumOf2DArray {

    public int sum(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }
}
