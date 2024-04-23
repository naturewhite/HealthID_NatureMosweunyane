package identifier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GenerateIdentifier {
	
	public static String  getGender(String numGender) {
		String gender ="";
		if(numGender.equalsIgnoreCase("01")) {
			gender = "Male";
		}else if(numGender.equalsIgnoreCase("02")) {
			gender = "Female";
		}
		return gender;
	}

	public static void main(String args[]) {
		
		IssueIdentifier issue = new IssueIdentifier();
		
		boolean running = true;
		List<String> ids = new ArrayList<String> ();
		List<String> assignCmd = new ArrayList<String> ();
		String exitCmd = "";
		Scanner sc = new Scanner(System.in);
		

		
		System.out.println("Type 'Done' when finished");
		System.out.println("Type 'exit' to exit the application");
		System.out.println("Enter command");
		while(running) {
		
		String command  = sc.nextLine();
		
			String sp [] = command.split(" ", 3);
			
			if(sp[0].equalsIgnoreCase("Issue")) {
				 
				if(sp[1].equalsIgnoreCase("ZZZ9999Z-01") || sp[1].equalsIgnoreCase("ZZZ9999Z-02")) {
					ids.add("errors") ;
				}
				else {
			     String generatedId = issue.finalIdentifier(sp[1],sp[2]);
			     ids.add(generatedId);
				}
			
			}
			else if(sp[0].equalsIgnoreCase("Assign")) {
				
				String [] gender = sp[1].split("-");
				String report = sp[2] + ":" +" "+ sp[1] + ":"+  " "+ getGender(gender[1]);
				assignCmd.add(report);
			}
		
		
		else if(command.equalsIgnoreCase("Done")) {
		
			for(String id : ids) {
				System.out.println(id);
			}
			ids.clear();
		}
		
		else if(command.equalsIgnoreCase("exit")) {
			   exitCmd = "exit";
			   break;
			}
		
		
	}
	sc.close();
	
	if(exitCmd.equalsIgnoreCase("exit")) {
		Collections.sort(assignCmd);
		for(String a : assignCmd) {
			System.out.println(a);
		}
		System.exit(0);
	}
}
	

}
