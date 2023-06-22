import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            int cnt = i;
            while(cnt-- != 0) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);            
    }
}