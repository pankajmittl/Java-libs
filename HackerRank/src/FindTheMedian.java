import java.util.Scanner;

public class FindTheMedian {
	
	static short[] array;

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			
			int N = sc.nextInt();
			array = new short[N];
			
			for(int i=0; i<N; i++) {
				array[i] = sc.nextShort();
			}
						
			int median = 0;
			int low=0, high = array.length-1;
			while(low <= high)
			{
				median = partition(low, high);
				if(median == array.length/2) {					
					break;
				}
				if(median > array.length/2) {
					high = median-1;
				} else {
					low = median+1;
				}
			}
			System.out.println(array[median]);
			
			
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}

	}
	
	public static int partition(int low, int high) throws Exception
	{
		short pivot = array[high];
		
		int boundary = low;
		 
		for(int i=low; i<high; i++)
		{
			if(array[i] <= pivot) {
				if(boundary!=i) {
					short temp = array[i];
					array[i] = array[boundary];
					array[boundary] = temp;
				}
				boundary++;
			}
		}
		array[high] = array[boundary];
		array[boundary] = pivot;
		return boundary;
	}
}
