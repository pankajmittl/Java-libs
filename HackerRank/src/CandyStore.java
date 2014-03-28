import java.math.BigInteger;
import java.util.Scanner;


public class CandyStore {

	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        while(T-- > 0)
        {
        	int k = sc.nextInt();
        	int n = sc.nextInt();
        	System.out.println(ncr(n+k-1, k-1));
        }
        
    }
	
	public static long ncr(int n, int r)
	{
		long output[] = new long[502]; 
		BigInteger bg = new BigInteger("1000000000");
		BigInteger currentVal = new BigInteger("1");
		long val = 1;
		output[0] = 1;
		for(int j=1; j<=r; j++) {
        	if(j <=n/2) {
            	if(j==1) {
            		currentVal = new BigInteger(""+n);
            	} else {
            		currentVal = currentVal.multiply(new BigInteger(""+ (n + 1 - j)));
            		currentVal = currentVal.divide(new BigInteger(""+j));
            	}
            	val = currentVal.mod(bg).longValue();
            	output[j] = val;
        	} else {
        		val = output[n-j];
        	}        	            	
        }
		return val;           	
	}
}
