package my.question.encode;

/**
 * Encode a string aaabb into a2b3
 *
 */
public class EncodeStringCompressingDuplicatedChars {
	public String encode(final String s){
		if(s == null || s.length() == 0) return s;
		char c = s.charAt(0);
		int cnt = 1;
		final StringBuilder sb = new StringBuilder();
		for(int i = 1; i < s.length(); i++){
			if(s.charAt(i) == c){
				cnt++;
				continue;
			}
			sb.append(c).append(cnt);
			c = s.charAt(i);
			cnt = 1;
		}
		sb.append(c).append(cnt);
		return sb.toString();
	}
}

class Main{
	public static void main(String[] argv){
		System.out.println(new EncodeStringCompressingDuplicatedChars().encode("aaabb"));
	}
}
