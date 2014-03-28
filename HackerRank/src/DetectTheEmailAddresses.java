import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
	import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DetectTheEmailAddresses {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		String[] domains = {"\\.com", "\\.in", "\\.org", "\\.edu", "\\.gov\\.in", "\\.net", "\\.info"};
		String afterEmail = ";!:";
		String beforeEmail = "-:;";
		
		String regex = "\\s*[BE]*[a-zA-Z0-9_\\.]+@[\\w\\.]+DOMAIN[AE]*\\s*";
		
		Vector<Pattern> patterns = new Vector<Pattern>();
		
		String pat = regex.replace("BE", beforeEmail);
		pat = pat.replace("AE", afterEmail);
		for(int i=0; i<domains.length; i++) {			
			patterns.add(Pattern.compile(pat.replace("DOMAIN", domains[i])));			
		}
		
		//System.out.println(patterns);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<String>();
		while(T-- > 0)
		{
			String input = br.readLine();
			//System.out.println("Input: " +input);
			for(Pattern patt : patterns) {
				Matcher matcher = patt.matcher(input);
				while(matcher.find()) {
					String email = matcher.group().trim();					
					for(char c : afterEmail.toCharArray())
						if(email.indexOf(c) != -1)
							email = email.substring(0, email.indexOf(c));
					email = email.trim();
					
					//System.out.println("Adding "+email);
					set.add(email);
				}
			}				
		}
		Object[] output = set.toArray();
		Arrays.sort(output);
		for(int i=0; i<output.length; i++) {
			System.out.print(output[i]);
			if(i != output.length-1) System.out.print(";");
		}
		System.out.println();
	}

}
