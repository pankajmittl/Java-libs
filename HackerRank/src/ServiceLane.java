import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ServiceLane {
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[] seg = new int[N];
		st = new StringTokenizer(br.readLine());		
		for(int i=0;i<N;i++){
			seg[i] = Integer.parseInt(st.nextToken());
		}
		
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			
			int vehicle = seg[min];
			for(int j=min+1; j<=max; j++)
			{
				if(seg[j] < vehicle) vehicle = seg[j];
			}
			System.out.println(vehicle);
		}
	}

}
