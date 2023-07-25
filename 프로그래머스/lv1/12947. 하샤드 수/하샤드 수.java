class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String tmp = String.valueOf(x);
        int sum = 0;
        for(int i = 0; i < tmp.length(); i++) sum += tmp.charAt(i) - '0';
        System.out.print(sum);
        if(x % sum != 0) answer = false;
        return answer;
    }
}