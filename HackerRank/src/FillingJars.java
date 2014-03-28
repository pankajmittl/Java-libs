import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class FillingJars {
	
	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			long average = 0;
			long sumLeft = 0;

			while(M-- > 0)
			{
				st = new StringTokenizer(br.readLine());
				int min = Integer.parseInt(st.nextToken());
				int max = Integer.parseInt(st.nextToken());
				long lot = Long.parseLong(st.nextToken());

				sumLeft += (lot * (max+1-min));
				if(sumLeft > N)
				{
					average += sumLeft/N;
					sumLeft %= N;
				}
			}
						
			System.out.println(average);
		}catch(Exception e) {e.printStackTrace();}
	}
}
