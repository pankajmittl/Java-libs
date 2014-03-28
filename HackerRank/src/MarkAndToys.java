import java.util.Arrays;
import java.util.Scanner;


public class MarkAndToys {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Scanner stdin=new Scanner(System.in);
        int n=stdin.nextInt(),k=stdin.nextInt();
        int prices[]=new int[n];
        for(int i=0;i<n;i++) prices[i]=stdin.nextInt();
        
        int answer = 0;
        // Compute the final answer from n,k,prices 
      	Arrays.sort(prices);
			
		for(int i=0; i<n; i++)
		{
			if(k > prices[i]) {
				k -= prices[i];
				answer++;
			}  else break;
		}
        System.out.println(answer);
    }

}
