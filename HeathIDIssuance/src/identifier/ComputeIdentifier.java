package identifier;

public class ComputeIdentifier {

	
	public char nextLetter(char previousLetter) {
		
		char lowercase = Character.toLowerCase(previousLetter);
		int sciiValue = (lowercase - 'a'+1)%26+'a';
		
		return (char)sciiValue;
		
		
	}
	public String nextNumber(String previousNumber) {
		String nextNumber = "";
		int number = Integer.parseInt(previousNumber) + 1;
		
	    
		if(number>=1 && number < 10) {
		 nextNumber = "000"+ String.valueOf(number);
		}
		if(number>=10 && number<100) {
			nextNumber = "00"+ String.valueOf(number);
		}
		if(number>=100 && number <=999) {
			nextNumber = "0"+ String.valueOf(number);
		}
		else {
			nextNumber = String.valueOf(number);
		}
		return nextNumber;
	}
	
	public String xIndex(String prevId) {
		String x = prevId.substring(0, 3); 
		return x;	
	}
	public String yIndex(String prevId) {
		String y = prevId.substring(3, 7);
		return y;
	}
	public String zIndex(String prev) {
	String z  = prev.substring(7);
	    return z;
	}
	
	public String incrementZIndexOfPrevious(String  prev) {
		
		StringBuilder sb = new StringBuilder(prev);
		String nextIdentifierZ = "";
		String index = zIndex(prev);
		if(!index.equalsIgnoreCase("Z")) {
			char c = index.charAt(0);
			String z = String.valueOf(nextLetter(c)).toUpperCase();
			sb.setCharAt(7, z.charAt(0));
			nextIdentifierZ = sb.toString();
		}
		return nextIdentifierZ;
		
	}
	
	public String incrementYIndexOfPrevious(String  prev) {
		String nextNumberY = "";
		
			StringBuilder sb = new StringBuilder(prev);
			String index = yIndex(prev);
			int a = Integer.parseInt(index);
			if(a < 9999) {
				
			String y = nextNumber(index);
			System.out.println("y " + y);
			sb.setCharAt(3, y.charAt(0));
			sb.setCharAt(4, y.charAt(1));
			sb.setCharAt(5, y.charAt(2));
			sb.setCharAt(6, y.charAt(3));
			nextNumberY = sb.toString();
			}
			
		
		
		
		return nextNumberY;
	}
	
	public String incrementXIndexOfPrevious(String prev) {
		
		String x = "";
		String index = xIndex(prev);
		
		StringBuilder sb = new StringBuilder(prev);
		
		if(index.charAt(2) != 'Z') {
			String result = String.valueOf(nextLetter(index.charAt(2))).toUpperCase(); 
			sb.setCharAt(2, result.charAt(0));
			x = sb.toString();
		}
		else if (index.charAt(2) == 'Z') {
			String next = String.valueOf(nextLetter(index.charAt(1))).toUpperCase();
			sb.setCharAt(1, next.charAt(0));
			x = sb.toString();
		}
		if(index.charAt(2) == 'Z' && index.charAt(1) == 'Z') {
			String next = String.valueOf(nextLetter(index.charAt(0))).toUpperCase();
			sb.setCharAt(0, next.charAt(0));
			x = sb.toString();
			
		}
		return x;
		
	}
	
	
	
	
}
