import java.util.*;
import utility.*;

public class Playground {

    public boolean match(String input, String pattern) {
        // Write your solution here
        // corner case

        int curInput = 0;
        for (int curPattern = 0; curPattern < pattern.length(); curPattern++) {

            // if pattern is letter
            if (pattern.charAt(curPattern) >= 'a' && pattern.charAt(curPattern) <= 'z') {
                if (curInput >= input.length() || pattern.charAt(curPattern) != input.charAt(curInput)) {
                    return false;
                }
                curInput++;
                curPattern++;
            } else {
                // if pattern is number

                // read out the number
                int num = pattern.charAt(curPattern) - '0';
                while (curPattern + 1 < pattern.length() && (pattern.charAt(curPattern + 1) < 'a' || pattern.charAt(curPattern + 1) > 'z')) {
                    num *= 10;
                    num += (pattern.charAt(curPattern + 1) - '0');
                    curPattern++;
                }

                if (curInput + num > input.length()) {
                    return false;
                } else {
                    curInput += num;
                }
            }
        }

        if (curInput == input.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Playground sol = new Playground();
        System.out.println(sol.match("sophisticated", "s111d"));
    }
}
