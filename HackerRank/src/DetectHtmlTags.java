import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class DetectHtmlTags {
	
	public static void main(String[] args) throws Exception
	{
		String[] tags = {"a","b","body","br","button","div","form","h1","h2","h3","head","html","i","img",
						"input","label","li","link","meta","noscript","ol","p","script","span","style","sup","table",
						"td","th","title","tr","ul", "br", "area", "center", "map"};
		String pattern1 = ".*</\\s*TAG\\s*>.*";
		String pattern2 = ".*<\\s*TAG\\s+.*\\s*/>.*";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		String[] patterns = new String[tags.length*2];
		
		for(int i=0; i<tags.length; i++) {
			patterns[2*i] = pattern1;
			patterns[2*i] = patterns[2*i].replaceAll("TAG", tags[i]);
			patterns[2*i+1] = pattern2;
			patterns[2*i+1] = patterns[2*i+1].replaceAll("TAG", tags[i]);
			//System.out.println(patterns[i]);
		}
		//patterns[tags.length-1] = ".*<\\s*/\\s*br.*/*\\s*>.*";
		HashSet<String> set = new HashSet<String>();
		while(T-- > 0)
		{
			String str = br.readLine().toLowerCase();
			for(int i=0; i<patterns.length; i++)
			{
				if(str.matches(patterns[i])) {
					//System.out.println("|"+patterns[i]+"| |"+tags[i/2]+"|");
					set.add(tags[i/2]);
				}
			}
		}
		String[] seta = (String[]) set.toArray(new String[set.size()]);
		Arrays.sort(seta);
		for(int i=0;i<seta.length;i++) {
			System.out.print(seta[i]);
			if(i!=seta.length-1) System.out.print(";");
		}		
	}

}
