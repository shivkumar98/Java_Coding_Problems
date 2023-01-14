package chapter_1_strings.attempt2;

import java.util.LinkedHashMap;
import java.util.Map;

public class Q02_solution {
	
	// we can use linkedHashMap which maintains order in which keys are inserted.
	// once the linkedhashmap is full, we just get the first key with value 1
	
	private static Character firstNonRepeatedCharacter(String str) {
		Map<Character, Integer> chars = new LinkedHashMap<>();
		for (int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			chars.compute(c, (k,v)-> (v==null)?1:++v);
		}
		
		for (char c:chars.keySet()) {
			if (chars.get(c) == 1) {
				return c;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(firstNonRepeatedCharacter("abbcc")); // expect a
		System.out.println(firstNonRepeatedCharacter("aabccc")); // expect b
		System.out.println(firstNonRepeatedCharacter("aabcccd")); // expect b
		System.out.println(firstNonRepeatedCharacter("a")); // expect a
	}
	
}
