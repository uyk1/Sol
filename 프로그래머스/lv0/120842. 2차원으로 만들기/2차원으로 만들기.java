class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        int row = 0;
        int col = 0;
        for(int i = 0; i < num_list.length; i++) {
            if((i + 1) % n == 0) {
                answer[row][col] = num_list[i]; 
                row++;
                col = 0;
            } else {  
                answer[row][col] = num_list[i];
                col++;
            }
        }
        return answer;
    }
}