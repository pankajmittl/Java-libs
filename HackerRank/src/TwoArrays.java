import java.util.Arrays;
import java.util.Scanner;


public class TwoArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T-- > 0)
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[] a = new int[n];
			for(int i=0; i<n;i++)
			{
				a[i] = sc.nextInt();
			}			
			
			int[] b = new int[n];
			for(int i=0; i<n;i++)
			{
				b[i] = sc.nextInt();
			}
			
			Arrays.sort(a);
			Arrays.sort(b);
			
			System.out.println(Arrays.toString(a));
			System.out.println(Arrays.toString(b));
			
			boolean flag = true; 
			for(int i=0; i<n; i++)
			{
				if(a[i] + b[n-1-i] < k) {
					flag = false;
					break;
				}
			}
			if(flag) System.out.println("YES");
			else System.out.println("NO");
		}

	}

}
