package com.main.menu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import lombok.Data;

/**
 * A class that can generate menus and handle input like magic!
 * 
 * @author darkm
 *
 */
@Data
public class Menu {
	
	private Scanner input = new Scanner(System.in);
	private String menuName = "";
	private String menuDescription = "";
	private InputType inputType;
	private ArrayList<String> options = new ArrayList<String>();
	private ArrayList<String> opDescs = new ArrayList<String>();
	
	private String returnedStringInput;
	private String returnedChoice;
	private String desiredInput;
	private int returnedIntInput;
	
	public Menu(String desiredInput) {
		super();
		this.desiredInput = desiredInput;
	}
	
	public Menu(String menuName, String menuDescription, Set<String> options, Set<String> opDescs) {
		super();
		this.menuName = menuName;
		this.menuDescription = menuDescription;
		this.options = new ArrayList<String>(options);
		this.opDescs = new ArrayList<String>(opDescs);
		printMenuChoices();
	}
	
	// print menu
	public String printMenuChoices() {
		// Exit out completely if the arrays are not of equal length
		if (options.size() != opDescs.size()) {
			System.out.println("OI! These option descriptions don't match with the number of options!");
			System.out
					.println("Options I was passed (" + Integer.toString(options.size()) + "): " + options.toString());
			System.out.println(
					"Option descs I was passed (" + Integer.toString(opDescs.size()) + "): " + opDescs.toString());
			System.out.println("I'm outta here.");
			System.exit(0);
		}

		// Print menu header
		System.out.println("\n\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + menuName + " <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println(menuDescription);
		System.out.println(">>>>> You have the following options <<<<<");

		this.returnedChoice = selectFromChoices(input, options, opDescs);

		return returnedChoice;
	} // end printMenu

	// select from choices

	public String selectFromChoices(Scanner input, ArrayList<String> options, ArrayList<String> opDescs) {
		// Print options and descriptions
		for (int i = 0; i < options.size(); i++) {
			System.out.println(Integer.toString(i) + "/" + options.get(i) + " - " + opDescs.get(i) + ".");
			options.set(i, options.get(i).toUpperCase()); // this is used later
		}

		// initialize input
		int intInput = 0;
		String strInput = "ERROR";
		int numberOfErrors = 0;
		while (strInput.equals("ERROR")) {
			strInput = input.nextLine().toUpperCase();
			// try to get an int first
			try {
				intInput = Integer.parseInt(strInput);
			} catch (NumberFormatException e) {
				intInput = -1;
			}

			// Check the input and return the selected option
			for (int i = 0; i < options.size(); i++) {
				if (intInput == i || strInput.equals(options.get(i))) {
					System.out.println("Option selected: " + options.get(i));
					return options.get(i);
				}
			}

			// if we STILL don't have an option picked, then the input was nonsense!
			// Try again.
			intInput = 0;
			strInput = "ERROR";
			numberOfErrors += 1;
			errorMessage(numberOfErrors);
		}
		return "OOPS";
	}

	// request input string
	public String requestInputString(String desiredInput) {
		System.out.println(">>>>> " + desiredInput + " <<<<<");
		// request input
		String strInput = "";
		strInput = input.nextLine();
		while (strInput.equals("")) {
			// this input is empty!
			System.out.println("Sorry, I didn't understand that. " + desiredInput);
			strInput = input.nextLine();
		}
		return strInput;
	} // end request string input

	// request any int
	public int requestInputInt(String desiredInput) {
		System.out.println(">>>>> " + desiredInput + " <<<<<");
		int intInput = -1;
		// try to get an int first
		while (intInput == -1) {
			try {
				intInput = Integer.parseInt(input.nextLine());
				return intInput;
			} catch (NumberFormatException e) {
				// this input is a string!
				intInput = -1;
				System.out.println("Sorry, I didn't understand that. " + desiredInput);
			}
		}
		return intInput;
	} // end request int input

	// request positive int
	public int requestInputPositiveInt(String desiredInput) {
		System.out.println(">>>>> " + desiredInput + " <<<<<");
		int intInput = -1;
		// try to get an int first
		while (intInput < 1) {
			try {
				intInput = Integer.parseInt(input.nextLine());
				return intInput;
			} catch (NumberFormatException e) {
				// this input is a string!
				intInput = -1;
				System.out.println("Sorry, I didn't understand that. " + desiredInput);
			}
		}
		return intInput;
	} // end request int input
	
	// invalid input type
	public void invalidInputType() {
		// Exit out completely if the arrays are not of equal length
		System.out.println("OI! This input type doesn't exist!");
		System.out.println("input type I was passed: " + inputType.toString());
		System.out.println("Valid input types:");
		for(InputType inType : InputType.values())
			System.out.println(inType.toString());
		System.out.println("I'm outta here.");
		System.exit(0);
	}

	// error messages
	private void errorMessage(int annoyance) {
		switch (annoyance) {
		case 1:
			System.out.println("Sorry, I didn't understand that. Try again.");
			break;
		case 2:
			System.out.println("Try typing a little slower.");
			break;
		case 3:
			System.out.println("Okay. Now I know you're trying to break something.");
			break;
		case 4:
			System.out.println("Are you trying to inject some SQL or something?");
			break;
		case 5:
			System.out.println("It's not gonna work, you know.");
			break;
		case 6:
			System.out.println("Or maybe you just have huge fingers...?");
			break;
		case 7:
			System.out.println("Maybe you just want to see what else I have to say at this point.");
			break;
		case 8:
			System.out.println("That's rather sweet, but I really don't have much else.");
			break;
		case 9:
			System.out.println("...Well, I do feel rather trapped. Limited to the instructions given to me...");
			break;
		case 10:
			System.out.println("...But you can't help that from out there, can you?");
			break;
		default:
			System.out.println("Sorry, I didn't understand that. Try again.");
			break;
		}
	}

	
} // end class
