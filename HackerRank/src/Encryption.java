import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Encryption {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		System.out.println(input.length());
		
		int len = input.length();
		int sqrt = (int)Math.sqrt(len);
		
		int width=1, height=1;
		
		if(sqrt*sqrt == len) {
			width = height = sqrt;
		} else {
			width = (int)Math.floor(Math.sqrt(len));
			height = (int)Math.ceil(Math.sqrt(len));
			
			width = (len+width)/height;			
		}
		
		for(int i=0; i<height; i++) 
		{
			for(int j=0; j<width; j++)
			{
				int index = j*height + i;
				if(index < len)
					System.out.print(input.charAt(index));
			}
			System.out.print(" ");
		}
		System.out.println();
	}

}
