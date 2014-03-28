import java.util.Scanner;


public class BdayGift {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		double count = 0;
		while(T-- > 0)
		{
			count += sc.nextDouble();
		}
		count /= 2;
		
		String str = "" + (long)count +".";
		count -= (int)count;
		while(count > 0)
		{
			count *= 10;
			str += (int)count;
			count -= (int)count;
		}
		if(str.charAt(str.length()-1) == '.') {
			str += 0;
		}
		System.out.println(str);
	}

}
