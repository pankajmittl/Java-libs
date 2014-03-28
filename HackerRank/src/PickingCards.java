import java.util.Arrays;
import java.util.Scanner;


public class PickingCards {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0) {
			int n = sc.nextInt();
			int[] cards = new int[n];
			
			for(int i=0; i<n; i++) {
				cards[i] = sc.nextInt();
			}
			
			Arrays.sort(cards);
			//System.out.println(Arrays.toString(cards));
			
			long answer = 1;
			int prevCount = 0;
			for(int i=0; i<n; i++) {
				int count=prevCount;
				int j = i+prevCount;
				for(; j<n; j++) {
					if(cards[j] <= i) count++;
					else break;
				}
				//System.out.println(i+" "+count);
				answer *= count;
				if(answer > 1000000007) {
					answer -= ((answer/1000000007) * 1000000007);
				}
				prevCount = count-1;
			}			
			System.out.println(answer);
		}

	}

}
