class Solution {
    public char findKthBit(int n, int k) {
        return helper(n, k);
    }

    private char helper(int n, int k) {
        // Base case
        if (n == 1) return '0';

        int length = (1 << n) - 1; // length of Sn = 2^n - 1
        int mid = (length / 2) + 1;

        if (k == mid) {
            return '1'; // middle element is always '1'
        } else if (k < mid) {
            return helper(n - 1, k); // lies in the left half
        } else {
            // lies in the right half
            int mirroredIndex = mid - (k - mid);
            char bit = helper(n - 1, mirroredIndex);
            return bit == '0' ? '1' : '0'; // invert
        }
    }
}