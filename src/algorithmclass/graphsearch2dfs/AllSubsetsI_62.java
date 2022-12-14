package algorithmclass.graphsearch2dfs;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsI_62 {
    // method 1: recommended DFS solution.
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        // record the current subset.
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, result);
        return result;
    }

    // at each level, determine the character at the position "index" to be picked
    // or not.
    private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
        // terminate condition:
        // when we finishes determining for all the characters pick or not,
        // we have a complete sebset.
        if (index == set.length) {
            result.add(sb.toString());
            return;
        }
        // 1. not pick the character at index.
        helper(set, sb, index + 1, result);
        // 2. pick the character at index.
        helper(set, sb.append(set[index]), index + 1, result);
        // remember to remove the added character when back tracking to the previous
        // level.
        sb.deleteCharAt(sb.length() - 1);
    }

    // method 2: another DFS solution (not recommended).
    public List<String> subSetsII(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helperII(arraySet, sb, 0, result);
        return result;
    }

    private void helperII(char[] set, StringBuilder sb, int index, List<String> result) {
        result.add(sb.toString());
        // maintains ascending order of the indices of picked characters.
        // choose the next picked index(the smallest one can be picked is index).
        for (int i = index; i < set.length; i++) {
            sb.append(set[i]);
            helperII(set, sb, i + 1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
