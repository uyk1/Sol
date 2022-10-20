import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] arr = new int[26];//알파벳 개수
		for(int i = 0; i < str.length(); i++) 
			arr[Integer.valueOf(((String.valueOf(str.charAt(i))).toUpperCase()).charAt(0)) - Integer.valueOf('A')]++; 
		int maxIdx = 0;
		for(int i = 0; i < 26; i++) {
			if(arr[maxIdx]<arr[i]) {
				maxIdx = i;
			}
		}
		boolean sign = false;
		for(int i = 0; i < 26; i++) {
			if(i != maxIdx && arr[maxIdx]==arr[i]) {
				sign = true;
			}
		}
		if(!sign) System.out.println((char) (maxIdx + Integer.valueOf('A')));
		else System.out.println('?');
	}
}