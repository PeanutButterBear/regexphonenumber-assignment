package edu.cscc;
//TODO - student name, date, purpose of program
//Calvin Gates, 9/19/2022, Lab to read list of phone numbers and determine if they're valid to practice using regular expressions


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Classname {
	
//stole this file reading method from the example
final static String INPUTFILE = "phoneno.dat";
	
	public static void main(String[] args) {
		File file = new File(INPUTFILE);
		try {
			Scanner in = new Scanner(file);
			Integer linenumber = 1;
			while(in.hasNextLine()) {
				String line = in.nextLine();
				if( (Pattern.matches("^(\\([2-9]\\d{2}\\))\\s\\d{3}-\\d{4}$", line) == true) || (Pattern.matches("[2-9]\\d{2}-\\d{3}-\\d{4}", line) == true) || (Pattern.matches("[2-9]\\d{9}", line) == true)) {
				//If any of the above are true the phone number should be valid, so do nothing...
				} else {
					System.out.println("Line " +linenumber+ ": Invalid phone number " +"\"" +line+ "\"");
				}
				linenumber++;
			}
			in.close();
			System.out.println("Done");
		} catch (FileNotFoundException e) {
			System.out.println(INPUTFILE+" not found");
		}
	}
}

// N = [2-9] inclusive so any digit that's not 1
// (NXX) XXX-XXXX format
//Pattern pattern1 = Pattern.compile("^(\\(\\d{3}\\))\\s\\d{3}-\\d{4}$");
// ^ and $ aren't necessary I'm pretty sure but I put them there in case, "\\s" blank space, "-" is literal, d{n} is n digits(0-9) in a row
//I don't understand why but the external parenthesis are literals and the internal ones require escaping (\\(numbers\\)) but it's 11:34 I'm tired of staring at this

// NXX-XXX-XXXX format \/
//Pattern pattern2 = Pattern.compile("[2-9]\\d{2}-\\d{3}-\\d{4}");

// NXXXXXXXXX format \/
//Pattern pattern3 = Pattern.compile("[2-9]\\d{9}");
