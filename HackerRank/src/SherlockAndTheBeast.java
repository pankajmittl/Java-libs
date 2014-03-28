import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class SherlockAndTheBeast {
	
	public static void main(String[] args)
	{
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int T = Integer.parseInt(br.readLine());
			while(T-- > 0)
			{
				System.out.println(getNumber(Integer.parseInt(br.readLine())));
			}
		} catch(Exception e) {}

	}
	
	public static String getNumber(int digits)
	{
		if(digits < 3) return "-1";
		
		int digit3 = 0;
		int digit5 = 0;
		
		if(digits%3 == 0) {
			digit5 = digits;
		} else {
          	int i=1;
			for(; i<=digits/5; i++)
			{
				digit3 = i*5;
				if((digits - digit3)%3 == 0) {
					digit5 = (digits-digit3);
					break;
				}
			}
          	if(i>digits/5) return "-1";
		}
		
		//generate number
		char c[] = new char[digits];
		Arrays.fill(c, 0, digit5, '5');
		Arrays.fill(c, digit5, digits, '3');
		
		return new String(c);
	}
}	
