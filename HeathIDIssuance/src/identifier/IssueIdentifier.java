package identifier;

public class IssueIdentifier {
	

	public String finalIdentifier(String prev,String gender) {
		ComputeIdentifier id = new  ComputeIdentifier();
		String nextIdentifier = "";
		
		
		
		if(!prev.isEmpty()){
			String prevIdentifier = "";
			String  genderPrev = "";
			
			String [] separator = prev.split("-");
			prevIdentifier = separator[0];
			if(gender.equalsIgnoreCase("female")) {
				
				genderPrev= "02";
				
			}
			else if(gender.equalsIgnoreCase("male")) {
				genderPrev= "01";
				
			}
			
			if(!prevIdentifier.isEmpty()) {
				
				if (!id.incrementZIndexOfPrevious(prevIdentifier).isEmpty()) {
					nextIdentifier = id.incrementZIndexOfPrevious(prevIdentifier) + "-"+genderPrev;
				}
				if(id.incrementZIndexOfPrevious(prevIdentifier).isEmpty()) {
					nextIdentifier = id.incrementYIndexOfPrevious(prevIdentifier)+ "-"+genderPrev;
				}
				if(id.incrementZIndexOfPrevious(prevIdentifier).isEmpty() 
						&& id.incrementYIndexOfPrevious(prevIdentifier).isEmpty()) {
					
					nextIdentifier =id.incrementXIndexOfPrevious(prevIdentifier)+ "-"+genderPrev;
				}
				
			}
			
			
			
			
		}
		return nextIdentifier;
	}
}
