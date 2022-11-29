package algorithmbeginnerclass.binarysearch;

public class FindTheKthElementInTheMatrix {

    public int findElement(int[][] matrix, int k) {
        int row = k / matrix[0].length;
        int col = k % matrix[0].length;
        return matrix[row][col];
    }
}
