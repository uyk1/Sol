import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        // 합이 최소가 되려면 A의 최소와 B의 최대를 곱해 더하면 됨 - 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < A.length; i++) answer += A[i] * B[(A.length - 1) - i];
        
        return answer;
    }
}