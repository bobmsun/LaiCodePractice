package algorithmbeginnerclass.sortingalgorithmsquicksort;

import java.util.Random;

public class BoundedRandomNumber {
    public int random(int a, int b) {
        Random rand = new Random();
        return a + rand.nextInt(b - a + 1);
    }
}
