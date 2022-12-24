package algorithmclass.graphsearch2dfs;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsI_64 {

    // 1. DFS solution with swapping (recommended)
    public List<String> permutations(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }

    // choose the character to be at the position of "index",
    // all the already chosen positions are (0, index-1)
    // all the candidate characters can be at position "index"
    // are in th subarray of (index, array.length-1)
    private void helper(char[] array, int index, List<String> result) {
        // terminate condition:
        // only when we have already chosen the characters for all the position,
        // we can have a complete permutation.
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        // all the possible characters could be placed at index are
        // the characters in the subarray (index, array.length-1);
        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            helper(array, index + 1, result);
            // remember to swap back when back track to previous level.
            swap(array, index, i);
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
