import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        
        // minLen[i] stores the minimum length of a valid sub-array ending at or before index i
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        
        int l = 0;
        int currentSum = 0;
        int minTotalLength = Integer.MAX_VALUE;
        
        for (int r = 0; r < n; r++) {
            currentSum += arr[r];
            
            // Shrink the window from the left if the sum exceeds the target
            while (currentSum > target) {
                currentSum -= arr[l];
                l++;
            }
            
            // If a valid sub-array is found
            if (currentSum == target) {
                int currentLen = r - l + 1;
                
                // If there is a valid non-overlapping sub-array before the left pointer
                if (l > 0 && minLen[l - 1] != Integer.MAX_VALUE) {
                    minTotalLength = Math.min(minTotalLength, currentLen + minLen[l - 1]);
                }
                
                // Update the DP array for the current index
                if (r > 0) {
                    minLen[r] = Math.min(minLen[r - 1], currentLen);
                } else {
                    minLen[r] = currentLen;
                }
            } else {
                // Carry forward the minimum length found so far
                if (r > 0) {
                    minLen[r] = minLen[r - 1];
                }
            }
        }
        
        return minTotalLength == Integer.MAX_VALUE ? -1 : minTotalLength;
    }
}