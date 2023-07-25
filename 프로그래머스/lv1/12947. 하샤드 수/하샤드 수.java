class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String tmp = String.valueOf(x);
        int sum = 0;
        for(int i = 0; i < tmp.length(); i++) sum += tmp.charAt(i) - '0';
        if(x % sum != 0) answer = false;
        return answer;
    }
}