import java.util.*;
import java.math.*;

class Solution {
    public int solution(int balls, int share) {
        if(balls == share) return 1;
        return (calc(balls, share).divide((calc(balls-share, 1)))).intValue();
    }
    
    static BigInteger calc(int start, int end) {
        if(start == end) return BigInteger.ONE;
        BigInteger big = new BigInteger(Integer.toString(start));
        return big.multiply(calc(start-1, end));
    }
}

