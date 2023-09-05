import java.math.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int l = nums.length;
        for(int i = 0; i < l; i++) {
            for(int j = i+1; j < l; j++) {
                for(int k = j+1; k < l; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(check(sum)) answer++;
                }
            }
        }

        return answer;
    }
    
    boolean check(int sum) {
        for(int i = 2; i <= (int) Math.sqrt(sum); i++) {
            if(sum % i == 0) return false;
        }
        return true;
    }
}