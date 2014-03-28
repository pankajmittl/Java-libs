import java.util.Arrays;
import java.util.Scanner;


public class QSnISComparison {
	
	static int qsSwaps;
	static int isSwaps;
	static int array[];
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		array = new int[n];
		for(int i=0;i<n;i++) array[i] = in.nextInt();
		//System.out.println(Arrays.toString(array));
		insertionSort(array.clone());
		
		//System.out.println(Arrays.toString(array));
		quickSort(0, n-1);
		//System.out.println(Arrays.toString(array));
		
		
		System.out.println(isSwaps-qsSwaps);
	}
	
	public static void quickSort(int low, int high)
	{
		if(low >= high) return;
		
		int median = partition(low, high);
		//System.out.println("qsSwaps: "+qsSwaps+" median "+median);
		//System.out.println(Arrays.toString(array));
		
		quickSort(low, median-1);
		quickSort(median+1, high);
	}
	
	public static int partition(int low, int high)
	{
		int pivot = array[high];
		
		int boundary = low;
		 
		for(int i=low; i<high; i++)
		{
			if(array[i] <= pivot) {
				if(boundary!=i) {
					int temp = array[i];
					array[i] = array[boundary];
					array[boundary] = temp;
				}
				boundary++;
				qsSwaps++;
			}
		}
		array[high] = array[boundary];
		array[boundary] = pivot;
		qsSwaps++;
		return boundary;
	}
	
	public static void insertionSort(int[] a)
	{
		int n = a.length;
		for(int i=0; i<n-1; i++)
		{
			if(a[i] > a[i+1]) {
				int pivot = a[i+1];
				int j = i;
				for(; j>=0; j--)
				{
					if(a[j] > pivot) {
						a[j+1] = a[j];
						isSwaps++;
					} else break;
				}
				a[j+1] = pivot;
				//isSwaps++;
				//System.out.println(Arrays.toString(a)+" -"+isSwaps);
			}
		}
	}
}
