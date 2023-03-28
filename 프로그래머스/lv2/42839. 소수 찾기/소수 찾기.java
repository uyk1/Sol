import java.util.*;

class Solution {
    static HashSet<Integer> hs; // 생성된 소수 담기(중복 X)
    static char[] arr; // numbers
    static boolean[] visited; // 방문처리
    
    public int solution(String numbers) {
        int answer = 0;
        hs = new HashSet<Integer>();
        arr = numbers.toCharArray();
        visited = new boolean[numbers.length()];
        
        dfs("", 0);
        
        return hs.size();
    }
    
    static void dfs(String str, int depth) {
        if(!str.equals("")) {
            int num = Integer.parseInt(str);
            if(isPrime(num)) hs.add(num); //알아서 중복 제거
        };
        if(depth == arr.length) return;
        // str의 길이만큼 재귀 -> 
        for(int i = 0; i < arr.length; i++ ) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(str+arr[i], depth+1);
            visited[i] = false;
        }
    }
    
    static boolean isPrime(int num) {
        if(num == 0 || num == 1) return false;
        for(int i = 2; i < num/2+1; i++) if(num%i == 0) return false;
        return true;
    }
}