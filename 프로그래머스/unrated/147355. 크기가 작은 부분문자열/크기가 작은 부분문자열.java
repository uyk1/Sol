import java.math.BigInteger;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        BigInteger b = new BigInteger(p);
        for(int i = 0; i <= t.length()-p.length(); i++) {
            BigInteger a = new BigInteger(t.substring(i, i+p.length()));
            if(a.compareTo(b) <= 0) answer++;
        }
        return answer;
    }
}