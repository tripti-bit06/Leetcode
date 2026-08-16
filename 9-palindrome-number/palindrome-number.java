class Solution {
    public boolean isPalindrome(int x) {
        int original = x;
        int num;
        int sum = 0;

        while (x > 0) {
            num = x % 10;
            sum = sum * 10 + num;
            x = x / 10;
        }

        if (sum == original) {
            return true;
        } else {
            return false;
        }
    }
}