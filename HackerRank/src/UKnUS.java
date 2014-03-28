import java.io.BufferedReader;
import java.io.InputStreamReader;


public class UKnUS {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[][] str = new String[n][];
		for(int i=0; i<n; i++)
		{
			str[i] = br.readLine().split(" ");
		}
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0)
		{
			int count=0;
			
			String match = br.readLine();
			match = match.substring(0, match.length()-2) + "ze";
			String match1 = match.substring(0, match.length()-2) + "se";
			
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<n; j++) 
				{
					if(str[i][j].equals(match)) count++;
					else if(str[i][j].equals(match1)) count++;
				}
			}
			System.out.println(count);
		}
	}

}
