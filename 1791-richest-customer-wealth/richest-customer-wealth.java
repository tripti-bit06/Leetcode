class Solution {
    public int maximumWealth(int[][] accounts) {
        int rows = accounts.length;
        int colm = accounts[0].length;  
        int maxwealth = 0;
   
        for (int i = 0 ; i < rows; i++){
            int wealth = 0;
            for(int j = 0 ; j < colm ; j++){
                wealth = accounts[i][j] + wealth;
            }
            if(maxwealth < wealth){
                maxwealth = wealth;
            }
            else {
                maxwealth = maxwealth;
            }
        }
        return maxwealth;
    }
};