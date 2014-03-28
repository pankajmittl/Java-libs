import java.io.BufferedReader;
import java.io.InputStreamReader;


public class UKnUS2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int N = Integer.parseInt(br.readLine());
			String str[][] = new String[N][];
			
			for(int i=0;i<N;i++){
				str[i] = br.readLine().split(" ");
			}
			
			int T = Integer.parseInt(br.readLine());
			String US, UK;
			int count=0;
			for(int i=0; i<T; i++)
			{
				UK = br.readLine();
				US = UK.replace("our", "or");
				
				//System.out.println("|"+UK +"| |"+US+"|");
				
				for(int j=0; j<N; j++) {
					for(int k=0; k<str[j].length; k++) {
						//System.out.println("|"+str[j][k]+"|");
						if(UK.equals(str[j][k]) || US.equals(str[j][k])) count++;						
					}
				}
				System.out.println(count);
				count=0;
			}
			
		}catch(Exception e) { e.printStackTrace();}

	}

}
