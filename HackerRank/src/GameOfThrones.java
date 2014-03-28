import java.io.BufferedReader;
import java.io.InputStreamReader;


public class GameOfThrones {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int len = input.length();
		
		int count[] = new int[26];
		
		for(int i=0; i<len; i++)
		{
			count[input.charAt(i)-'a']++;
		}
		
		int oddcount=0;
		for(int i=0; i<26;i++) {
			if(count[i] %2 !=0) oddcount++;
		}
		
		if(oddcount <= 1) System.out.println("YES");
		else System.out.println("NO");

	}

}
