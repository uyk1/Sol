import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] arr = a.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c: arr) {
            if(Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
            else sb.append(Character.toUpperCase(c));
        }
        System.out.print(sb);
    }
}