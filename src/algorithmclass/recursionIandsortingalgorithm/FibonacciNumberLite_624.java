package algorithmclass.recursionIandsortingalgorithm;

public class FibonacciNumberLite_624 {

    public long fibonacci(int K) {
        if (K <= 0) {
            return 0;
        }
        if (K == 1) {
            return 1;
        }
        return fibonacci(K - 1) + fibonacci(K - 2);
    }
}
