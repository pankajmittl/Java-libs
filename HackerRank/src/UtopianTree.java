import java.io.BufferedReader;
import java.io.InputStreamReader;


public class UtopianTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0)
		{
			System.out.println(getLength(Integer.parseInt(br.readLine())));
		}
	}
	
	public static int getLength(int cycles)
	{
		int height = 1;
		
		for(int i=0; i<cycles; i++)
		{
			if(i%2==0) height *= 2;
			else height += 1;
		}
		return height;
	}

}
