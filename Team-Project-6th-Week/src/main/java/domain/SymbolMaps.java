package domain;

import java.util.HashMap;
import java.util.Map;

public class SymbolMaps {

	public static final Map<Character, Character> codeLibrary=new HashMap<Character, Character>();
	 
	static{
	   
	    codeLibrary.put('a','α');      codeLibrary.put('b','β');
	    codeLibrary.put('c','κ');    codeLibrary.put('d','δ');
	    codeLibrary.put('e','ε');       codeLibrary.put('f','φ');
	    codeLibrary.put('g','γ');     codeLibrary.put('h','η');
	    codeLibrary.put('i','ι');      codeLibrary.put('j','χ');
	    codeLibrary.put('k','κ');     codeLibrary.put('l','λ');
	    codeLibrary.put('m','μ');      codeLibrary.put('n','ν');  
	    codeLibrary.put('o','ο');     codeLibrary.put('p','π');
	    codeLibrary.put('q','ς');    codeLibrary.put('r','ρ');
	    codeLibrary.put('s','σ');     codeLibrary.put('t','τ');
	    codeLibrary.put('u','υ');     codeLibrary.put('v','β');
	    codeLibrary.put('w','ω');     codeLibrary.put('x','χ');
	    codeLibrary.put('y','υ');    codeLibrary.put('z','ζ');
	    codeLibrary.put('.',' ');   codeLibrary.put('/',' ');
	    codeLibrary.put(']',' ');
	    codeLibrary.put('A','α');      codeLibrary.put('B','β');
	    codeLibrary.put('C','κ');    codeLibrary.put('D','δ');
	    codeLibrary.put('E','ε');       codeLibrary.put('F','φ');
	    codeLibrary.put('G','γ');     codeLibrary.put('H','η');
	    codeLibrary.put('I','ι');      codeLibrary.put('J','χ');
	    codeLibrary.put('K','κ');     codeLibrary.put('L','λ');
	    codeLibrary.put('M','μ');      codeLibrary.put('N','ν');  
	    codeLibrary.put('O','ο');     codeLibrary.put('P','π');
	    codeLibrary.put('Q','ς');    codeLibrary.put('R','ρ');
	    codeLibrary.put('S','σ');     codeLibrary.put('T','τ');
	    codeLibrary.put('U','υ');     codeLibrary.put('V','β');
	    codeLibrary.put('W','ω');     codeLibrary.put('X','χ');
	    codeLibrary.put('Y','υ');    codeLibrary.put('Z','ζ');	
}
	public static final Map<String , String> codeStringLibrary=new HashMap<String, String>();

	static{	
		codeStringLibrary.put("th", "θ");		
		codeStringLibrary.put("ps", "ψ");
		codeStringLibrary.put("xs", "ξ");
		codeStringLibrary.put("s$", "ς");
		codeStringLibrary.put("ks", "ξ");
		
		codeStringLibrary.put("bam", "μπαμ");
		codeStringLibrary.put("domat", "ντομάτ");
		codeStringLibrary.put("dolm", "ντολμ");
		codeStringLibrary.put("kremi", "κρεμμύ");
	}
	public static String changeLetters(String s) {
		StringBuilder out = new StringBuilder(Math.max(1, s.length()));
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (codeLibrary.containsKey(c)) {
				
				out.append(codeLibrary.get(c));
			} else {
				out.append(c);
			}
		}
		return out.toString();
	}
	
	public static String changeExpr(String s) {
		String out=s;
		for (Map.Entry<String, String> entry : codeStringLibrary.entrySet()) {
		
	        out= out.replaceAll("(?i)"+entry.getKey(), entry.getValue());
	    }
//		 out= out.replaceAll("(?i)s$", "ς");
		return out;
		
	}
	
}
