class Solution {
    public boolean isSameAfterReversals(int num) {
        int original = num;
        int x;
        int y;
        int reverse = 0; 
        int reverse2 = 0;

        while(num > 0){
            x = num % 10;
            reverse = reverse * 10 + x;
            num = num / 10;
        }

        while(reverse > 0){
             y = reverse % 10;
             reverse2 = reverse2 * 10 + y;
             reverse  = reverse / 10; 
        }
        if (original == reverse2){
            return true;
        }
        else {
            return false;
        }
    }
}