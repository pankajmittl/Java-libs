import java.util.Scanner;


public class FindADigit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0) 
		{
			long n = sc.nextLong();
			
			long temp = n;
			int count=0;
			while(temp > 0)
			{
				int a = (int)(temp % 10);
				temp = temp/10;
				
				if(a!=0 && n%a == 0) count++;				
			}
			System.out.println(count);
		}
	}

}
