import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        // 1. Sort the array
        Arrays.sort(nums);
        
        int maxSum = 0;
        
        // 2. Sum elements at even indices
        for (int i = 0; i < nums.length; i += 2) {
            maxSum += nums[i];
        }
        
        return maxSum;
    }
}