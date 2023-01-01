package algorithmclass.hashtableandstring1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Assumptions: there could be duplicated elements in the given arrays.
public class CommonNumbersOfTwoSortedArrays_652 {
    // Method 1: two pointers.
    public List<Integer> commonI(int[] a, int[] b) {
        // Assumption: a, b is not null.
        List<Integer> common = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                common.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return common;
    }

    // Method 2: use HashMap.
    public List<Integer> commonII(int[] a, int[] b) {
        List<Integer> common = new ArrayList<Integer>();
        HashMap<Integer, Integer> countA = new HashMap<Integer, Integer>();
        for (int num : a) {
            Integer ct = countA.get(num);
            if (ct != null) {
                countA.put(num, ct + 1);
            } else {
                countA.put(num, 1);
            }
        }
        HashMap<Integer, Integer> countB = new HashMap<Integer, Integer>();
        for (int num : b) {
            Integer ct = countB.get(num);
            if (ct != null) {
                countB.put(num, ct + 1);
            } else {
                countB.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : countA.entrySet()) {
            Integer ctInB = countB.get(entry.getKey());
            if (ctInB != null) {
                int appear = Math.min(entry.getValue(), ctInB);
                for (int i = 0; i < appear; i++) {
                    common.add(entry.getKey());
                }
            }
        }
        return common;
    }
    // 以上的方法虽然来自答案，但是无法通过 laiCode


    // 以下是自己的 HashMap 方法：
    // traverse A, populate a freq map
    // key: number, value: freq
    // traverse B:
    // case 1: num is not in the map, do nothing
    // case 2: num is in the map, then add num to the result list, freq--
    // time: O(n + m)
    // space: O(min(n, m))
    public List<Integer> commonIII(int[] A, int[] B) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int number : A) {
            freq.put(number, freq.getOrDefault(number, 0) + 1);
        }
        for (int number : B) {
            int curFreq = freq.getOrDefault(number, 0);
            if (curFreq > 0) {
                result.add(number);
                freq.put(number, curFreq - 1);
            }
        }
        return result;
    }
}
