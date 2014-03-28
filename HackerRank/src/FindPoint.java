import java.util.Scanner;


public class FindPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0)
		{
			int Px = sc.nextInt();
			int Py = sc.nextInt();
			int Qx = sc.nextInt();
			int Qy = sc.nextInt();
			
			System.out.println((2*Qx - Px)+" "+(2*Qy-Py));
		}
	}

}
