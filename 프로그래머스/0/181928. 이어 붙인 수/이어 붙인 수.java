class Solution {
    public int solution(int[] num_list) {
        String a = "";
        String b = "";
        
        for(int i : num_list) {
            if(i % 2 == 1) a += i;
            else b += i;
        }
        
        return Integer.valueOf(a) + Integer.valueOf(b);
    }
}