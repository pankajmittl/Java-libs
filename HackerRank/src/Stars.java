import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Stars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = null;
			int T = Integer.parseInt(br.readLine());
			long star[][] = new long[T][3];
			
			for(int i=0; i<T; i++)
			{
				st = new StringTokenizer(br.readLine());
				star[i][0] = Long.parseLong(st.nextToken());
				star[i][1] = Long.parseLong(st.nextToken());
				star[i][2] = Long.parseLong(st.nextToken());
			}
			
			//brute force
			long min = Long.MAX_VALUE;
			long smaller_part = Long.MAX_VALUE;
			
			for(int i=0; i<T; i++)
			{
				for(int j=i+1; j<T; j++)
				{
					long neg = 0;
					long pos = 0;
					long zeros = 0;
					
					for(int k=0; k<T; k++)
					{
						long cp = cross(star[i], star[j], star[k]);
						
						if(cp>0) pos += star[k][2];
						else if(cp<0) neg += star[k][2];
						else zeros += star[k][2];
					}
					//System.out.println(i+" "+j+" "+pos+" "+neg+" "+zeros);
					if(pos > neg) {
						neg += zeros;
					} else {
						pos += zeros;
					}
					if(min > Math.abs(pos-neg)) {
						//System.out.println("MIN: "+i+" "+j);
						min = Math.abs(pos-neg);
						smaller_part = Math.min(pos, neg);
					}
				}
			}
			System.out.println(smaller_part);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Compute the cross product AB x AC
	public static long cross(long[] A, long[] B, long[] C){
		long[] AB = new long[2];
		long[] AC = new long[2];
		AB[0] = B[0]-A[0];
		AB[1] = B[1]-A[1];
		AC[0] = C[0]-A[0];
		AC[1] = C[1]-A[1];
		long cross = AB[0] * AC[1] - AB[1] * AC[0];
		return cross;
	}

}