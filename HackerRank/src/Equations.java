import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Equations {
	
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		if(n==0 || n==1 ) {
			System.out.println("1");
			return;
		}
		
		HashMap<Integer, HashMap<Integer, Integer>> hm= new HashMap<Integer, HashMap<Integer, Integer>>();
				
		HashMap<Integer, Integer> total = new HashMap<Integer, Integer>();
		
		for(int i=2; i<=n; i++)
		{
			//System.out.println("number: "+i);
			int factor = isPrime(i);
			if(factor==0) {
				HashMap<Integer, Integer> hmfactor = new HashMap<Integer, Integer>();
				hmfactor.put(i, 1);
				hm.put(i, hmfactor);
				//merging with total
				for(Entry<Integer, Integer> entry : hmfactor.entrySet()){
					int val = 0;
					if(total.containsKey(entry.getKey())) {
						val = total.get(entry.getKey());					
						total.remove(entry.getKey());
					}
					total.put(entry.getKey(), val+entry.getValue());
				}
			} else {
				HashMap<Integer, Integer> hmfactor = hm.get(factor);
				HashMap<Integer, Integer> hmfactor2 = hm.get(i/factor);
				
				//System.out.println("Fac: "+hmfactor);
				//System.out.println("Fac2: "+hmfactor2);
				
				//merging
				HashMap<Integer, Integer> hm2 = new HashMap<Integer, Integer>();
				hm2.putAll(hmfactor2);
				for(Entry<Integer, Integer> entry : hmfactor.entrySet()){
					int val = 0;
					if(hm2.containsKey(entry.getKey()))
					{
						val = hm2.get(entry.getKey());
						hm2.remove(entry.getKey());
					}
					hm2.put(entry.getKey(), val+entry.getValue());
				}
				hm.put(i, hm2);
				
				//System.out.println("merged: "+hm2);
				
				//merging with total
				for(Entry<Integer, Integer> entry : hm2.entrySet()){
					int val = 0;
					if(total.containsKey(entry.getKey())) {
						val = total.get(entry.getKey());					
						total.remove(entry.getKey());
					}
					total.put(entry.getKey(), val+entry.getValue());
				}
			}
		}
		
		//System.out.println(total);
		long count = 1;
		for(Integer i : total.values()){
			count *= (2*i + 1);
			
			if(count > 1000007) {
				count -= ((count/1000007)*1000007);
			}
		}
		System.out.println(count);
	}
	
	public static int isPrime (int n)
	{
	   if (n<2) return 1;
	   if (n==2 || n==3) return 0;
	   if (n%2==0) return 2;
	   if (n%3==0) return 3;
	   int m=(int) Math.sqrt(n);

	   int i = 5;
	   for (; i<=m; i+=2)
	      if (n%i==0)
	         return i;

	   return 0;
	}

}
