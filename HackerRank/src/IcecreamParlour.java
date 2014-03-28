import java.util.Scanner;


public class IcecreamParlour {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0) 
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			
			int a[] = new int[n];
			
			for(int i=0; i<n; i++) a[i] = sc.nextInt();
			
			for(int i=0; i<n; i++)
			{
				for(int j=i+1; j<n; j++)
				{
					if(a[i]+a[j] == m) {
						System.out.println((i+1)+" "+(j+1));
						i = n;
						break;					
					}
				}
			}
		}
	}

}
