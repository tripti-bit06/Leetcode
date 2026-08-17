class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] Sum = new int[n];
        int current = 0;
        for(int i = 0 ; i < nums.length ; i++){
            current = nums[i] + current;
            Sum[i] = current;
        }
        return Sum;
        
    }
}