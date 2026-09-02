class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101]; // Constraints: 1 <= nums[i] <= 100
        int goodPairs = 0;
        
        for (int num : nums) {
            goodPairs += count[num]; // Add existing frequency to total pairs
            count[num]++;            // Increment frequency count
        }
        // Doudt
        return goodPairs;
    }
}