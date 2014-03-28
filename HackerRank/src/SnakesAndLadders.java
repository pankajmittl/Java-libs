import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;


public class SnakesAndLadders {
	
	static int minMoves=0;
	static int nladder, nsnakes;
	static int[][] l, s;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0)
		{
			minMoves = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine(), ", ");
			nladder = Integer.parseInt(st.nextToken());
			nsnakes = Integer.parseInt(st.nextToken());
			//System.out.println("\ncount: "+nladder+" "+nsnakes);
			l = new int[nladder][2];
			st = new StringTokenizer(br.readLine(), ", ");
			for(int i=0; i<nladder; i++) {
				l[i][0] = Integer.parseInt(st.nextToken());
				l[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(l, new Comparator<int[]>() {
			    @Override
			    public int compare(int[] o1, int[] o2) {
			        return Integer.compare(o1[0], o2[0]);
			    }
			});
			
			//for(int[] a : ladders)
				//System.out.println(Arrays.toString(a));
			//if(true) break;
			s = new int[nsnakes][2];
			st = new StringTokenizer(br.readLine(), ", ");
			for(int i=0; i<nsnakes; i++) {
				s[i][0] = Integer.parseInt(st.nextToken());
				s[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(s, new Comparator<int[]>() {
			    @Override
			    public int compare(int[] o1, int[] o2) {
			        return Integer.compare(o1[0], o2[0]);
			    }
			});
			
			//for(int[] a : snakes)
				//System.out.println(Arrays.toString(a));
			
			findMoves(1, 0, new int[100]);
			System.out.println(minMoves);
		}
	}
	
	public static void findMoves(int pos, int moves, int[] stack)
	{
		if(moves == 100) return;
		if(moves+1 >= minMoves) return;
		if(pos >= 94) {
			if(minMoves > moves+1) {
				minMoves = moves+1;
				//System.out.println("Min Found: "+minMoves);
			}
			
			return;
		}
		
		for(int i=0; i<moves;i++)
		{
			if(stack[i] == pos) return;
		}
		
		//ladder
		for(int i=0; i<l.length; i++) {
			if(l[i][0] >= pos) {
				if(l[i][0] < pos+6) {
					findMoves(l[i][1], moves+1, stack);
					//not breaking here since there might be multiple opportunities
				}else break;
			}
		}
		
		//nothing
		boolean flag = true;
		int i = 6;
		for(;i>=1;i--) {
			flag = true;
			for(int j=0;j<s.length;j++) {
				if(s[j][0] == pos+i) {
					flag = false;
					break;
				}	
			}
			if(flag) break;
		}
		if(i>0)
			findMoves(pos+i, moves+1, stack);
		
		//snake
		for(i=0; i<s.length; i++) {
			if(s[i][0] >= pos) {
				if(s[i][0] < pos+6) {
					findMoves(s[i][1], moves+1, stack);
					//not breaking here since there might be multiple opportunities
				}else break;
			}
		}
	}
}
