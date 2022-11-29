package algorithmbeginnerclass.controlflowandmethods;

public class CalculateAToThePowerOfBNaive {

    public int power(int a, int b) {
        int res = 1;
        for (int i = 0; i < b; i++) {
            res *= a;
        }
        return res;
    }
}
