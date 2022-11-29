package algorithmbeginnerclass.controlflowandmethods;

public class CalculateFactorialOfN {

    public int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
