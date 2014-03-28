import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FindASubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String strs[] = new String[N];
		
		for(int i=0; i<N; i++) {
			strs[i] = br.readLine();
		}
		
		int T = Integer.parseInt(br.readLine());
		
		String pattern = "[_A-Za-z0-9]+TAG[_A-Za-z0-9]+";
		while(T-- > 0)
		{
			String substr = br.readLine();
			substr = pattern.replace("TAG", substr);
			Pattern p = Pattern.compile(substr);
			
			int count=0;
			for(String s : strs)
			{				
				Matcher m = p.matcher(s);
				while(m.find()) count++;
			}
			System.out.println(count);
		}
		
	}

}
