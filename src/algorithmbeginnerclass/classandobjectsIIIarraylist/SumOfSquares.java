package algorithmbeginnerclass.classandobjectsIIIarraylist;

import java.util.*;

public class SumOfSquares {
    public int sumOfSquare(List<Integer> list) {
        if (list == null) {
            return 0;
        }
        int sum = 0;
        for (int i : list) {
            sum += i * i;
        }
        return sum;
    }
}
