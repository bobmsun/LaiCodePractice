package algorithmbeginnerclass.controlflowandmethods;

public class CalculateSumOfSquares {

    public int sumOfSquares(int n) {
        int sum = 0;
        for (int i = 1; i * i <= n; i++) {
            sum += i * i;
        }
        return sum;
    }
}
