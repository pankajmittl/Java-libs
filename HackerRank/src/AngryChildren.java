import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class AngryChildren {
	static BufferedReader in = new BufferedReader(new InputStreamReader(
	         System.in));
	   static StringBuilder out = new StringBuilder();

	   public static void main(String[] args) throws NumberFormatException, IOException {
	      int numPackets = Integer.parseInt(in.readLine());
	      int numKids = Integer.parseInt(in.readLine());
	      int[] packets = new int[numPackets];
	      
	      for(int i = 0; i < numPackets; i ++)
	      {
	         packets[i] = Integer.parseInt(in.readLine());
	      }
	      
	      Arrays.sort(packets);
	      System.out.println(Arrays.toString(packets));
	      
	      int min = packets[0], max = packets[numKids-1];
	      int unfairness = max-min;
	      //System.out.println(unfairness);
	    
	      for(int i=numKids,j=1; i<numPackets; i++,j++)
	      {
	    	  //System.out.println(i+" "+j);
	    	  int newUnfairness = packets[i] - packets[j];
	    	  if(newUnfairness < unfairness) unfairness = newUnfairness;
	      }
	      
	      System.out.println(unfairness);
	   }
}
