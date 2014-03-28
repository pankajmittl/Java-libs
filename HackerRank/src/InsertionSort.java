import java.util.Scanner;


public class InsertionSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] array = new int[n];
		for(int i=0; i<n; i++) {
			array[i] = in.nextInt();
		}
		
		insertionSort2(array);
	}
	
	public static void printArray(int[] a)
	{
		for(int i : a) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public static void insertionSort(int[] a)
	{
		int n = a.length;
		int pivot = a[n-1];
		int i = n-2;
		for(; i>=0; i--)
		{
			if(a[i] > pivot) {
				a[i+1] = a[i];
				printArray(a);
			} else break;
		}
		a[i+1] = pivot;
		printArray(a);
	}
	
	//first part
	public static void insertionSort2(int[] a)
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
						//printArray(a);
					} else break;
				}
				a[j+1] = pivot;				
			}
			printArray(a);
		}
	}

}