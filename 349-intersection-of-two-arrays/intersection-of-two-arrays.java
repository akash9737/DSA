import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        
        // Add all elements of nums1 into set1
        for (int num : nums1) {
            set1.add(num);
        }
        
        // Check common elements
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }
        
        // Convert set to array
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }
        
        return result;
    }
}
