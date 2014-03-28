import java.util.Scanner;


public class AlienUsername {
	
	public static void main(String[] args)
	{
		String pattern = "[_.]\\d+[a-zA-Z]*_{0,1}";
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while(T-- > 0)
		{
			String s1 = in.next();
			//System.out.println(s1);
			if(s1.matches(pattern))
			{
				System.out.println("VALID");
			}else {
				System.out.println("INVALID");
			}
		}
	}

}
