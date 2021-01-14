package fileOperations;

import initialDisplays.Welcome;

import java.util.Scanner;

public class FileOperations {
	
	static Scanner scanner = new Scanner(System.in);

	public static void showFileOperations() {
		System.out.println("------++++++============++++++------");
		System.out.println("1. Add a file");
		System.out.println("2. Delete a file");
		System.out.println("3. Search for a file");
		System.out.println("4. Back to main menu");
		System.out.println("------++++++============++++++------");
		
		String chooseOperation = scanner.nextLine();
		handleFileOperations(chooseOperation);
	}
	
	public static void handleFileOperations(String action) {
		switch(action) {
			case "1":
				System.out.println("Adding a file");
				break;
			case "2":
				System.out.println("Deleting a file");
				break;
			case "3":
				System.out.println("Searching a file");
				break;
			case "4":
				System.out.println("Getting the Main Menu...");
				Welcome.mainMenuOptions();
				break;
			default:
				System.out.println("Invalid input, please input a 1, 2, 3, or 4");
		}
		showFileOperations();
	}
	
}
