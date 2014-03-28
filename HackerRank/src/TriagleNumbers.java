import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;


public class TriagleNumbers {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		while(T-- > 0)
		{
			int input = sc.nextInt();
			if(input < 3) System.out.println("-1");
			else if((input+1) % 2==0) System.out.println(1);
			else if((input-2)%4 == 0) System.out.println(4);
			else System.out.println(3);
		}
	}
	
	public static void main2(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int max = 0;
		int T = sc.nextInt();
		int[] rows = new int[T];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<T; i++)
		{
			int row = sc.nextInt();
			if(row > max) max = row;
			map.put(row, -1);
			rows[i] = row;
		}
		
		//boolean[] matrix = new boolean[max][];
		boolean[] prevRow = new boolean[max+1];
		boolean[] row = new boolean[max+1];
				
		for(int i=0; i<max; i++)
		{
			int index = -2;
			row = new boolean[i+1];
			row[0] = true;
			if(i>0) row[1] = (i%2==1);
			if(i>1 && i%2==0) index = 1;
			if(i>1) row[i] = true;
			for(int j=2; j<i; j++)
			{		
				row[j] = prevRow[j] ^ prevRow[j-1] ^ prevRow[j-2];
				if(index==-2 && !row[j]) index = j;
			}
			//System.out.println(Arrays.toString(row));
			boolean[] temp = prevRow;
			prevRow = row;
			row = temp;
			if(map.containsKey(i+1)) {
				map.remove(i+1);
				map.put(i+1, index+1);
			}
			System.out.println(i+" "+index);
		}
		
		for(int i=0; i<T; i++)
		{						
			System.out.println(map.get(rows[i]));
		}
	}
	
	//Even = 1 , Odd = 0, NA = -1
	public static int isEven(long row, long col)
	{
		long cols = 2*row + 1;
		if(row <0 || col < 0 || col >= cols) return -1;
		if(row==0 || col==0 || col==cols-1) return 0;
		
		int temp1 = isEven(row-1, col);
		int temp2 = isEven(row-1, col-1);
		int temp3 = isEven(row-1, col-2);
		
		int count = 0;
		if(temp1==0) count++;
		if(temp2==0) count++;
		if(temp3==0) count++;
		
		return (count+1)%2;
	}

}
