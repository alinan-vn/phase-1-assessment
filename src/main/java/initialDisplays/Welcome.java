package initialDisplays;

import filesInAscendingOrder.FilesOrder;
import fileOperations.FileOperations;

import java.util.Scanner;

public class Welcome {
	
	static Scanner scanner = new Scanner(System.in);

	public static void welcomeDisplay() {
		System.out.println("==================");
		System.out.println("==================");
		System.out.println("Application: LockedMe.com");
		System.out.println("Developer: Alejandro Linan");
		System.out.println("Description: A Virtual Key for your Repositories. Here you can add, delete, and search your files and folders!");
		System.out.println("==================");
		System.out.println("==================");
	}

	public static void mainMenuOptions() {
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("MAIN MENU");
		System.out.println("Instruction: Please input the number of the action you wish to take");
		System.out.println("1. Show Files in Ascending Order");
		System.out.println("2. View File Operations");
		System.out.println("3. Close the Application");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		
		String chosenAction = scanner.nextLine();
		handleMenuOptions(chosenAction);
	}
	
	public static void handleMenuOptions(String input) {
		switch(input) {
			case "1":
				FilesOrder.showFilesInAscendingOrder();
				break;
			case "2":
				System.out.println("Fetching operations for your command....");
				FileOperations.showFileOperations();
				break;
			case "3":
				System.out.println("Exiting application....");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input, please choose 1, 2, or 3 (Please exclude whitespace)");
		}
		mainMenuOptions();
	}
	
}
