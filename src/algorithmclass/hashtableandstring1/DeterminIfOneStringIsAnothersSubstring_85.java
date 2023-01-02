package algorithmclass.hashtableandstring1;

// Notice:
// 1. There is no assumption about the charset used in the String,
//    so that we can not assume we are using 26 lower case characters.
// 2. This is the most correct version of RabinKarp in computer programming,
//    we need to handle 1. we could use arbitrary charset, 2. the overflow case,
//    by taking the module operation on a very large number.
// 3. You probably do not need to write this kink of solution to handle above,
//    two cases, if you in an interview. But it is still necessary to
//    understand the reason behind it.

public class DeterminIfOneStringIsAnothersSubstring_85 {

    // Method 1: Naive solution.
    public int strstrI(String large, String small) {
        if (large.length() < small.length()) {
            return -1;
        }
        // return 0 if small is empty.
        if (small.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= large.length() - small.length(); i++) {
            if (equals(large, i, small)) {
                return i;
            }
        }
        return -1;
    }

    // Method 2: RabinKarp



    public boolean equals(String large, int start, String small) {
        for (int i = 0; i < small.length(); i++) {
            if (large.charAt(i + start) != small.charAt(i)) {
                return false;
            }
        }
        return true;
    }


}
