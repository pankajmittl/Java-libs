import java.io.BufferedReader;
import java.io.InputStreamReader;


public class HelloweenParty {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int T = Integer.parseInt(br.readLine());
			while(T-- > 0)
			{
				int cuts = Integer.parseInt(br.readLine());
				long pieces = ((((long)cuts+1)/2)*(cuts/2));
				if(pieces==0) pieces = 1;
				System.out.println(pieces);
			}
		} catch(Exception e) {}

	}

}
