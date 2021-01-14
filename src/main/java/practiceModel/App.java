package practiceModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class App {

	final static String FOLDER = "/tmp";
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		showWelcomeScreen();
		showMainMenu();
		collectMainMenuOption();
	}
	
	private static void collectMainMenuOption() {
		System.out.println("Please choose 1, 2, or 3: ");
		String option = scanner.nextLine();
		
		switch(option) {
			case "1":
				showFilesInAscendingOrder();
				break;
			case "2":
				collectFileOperations();
				break;
			case "3":
				System.out.println("Thanks for using LockedMe.com. Closing applications...");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input, please provide 1, 2, or 3");
//				collectMainMenuOption();
		}
		showMainMenu();
	}
	
	private static void addAFile() throws InvalidPathException {
		System.out.println("Please provide a file path:");
		String filePath = scanner.nextLine();
		Path path = Paths.get(filePath);
		
		if (!Files.exists(path)) {
			System.out.println("File does not exist");
			return;
		}
		
		String newFilePath = FOLDER + "/" + path.getFileName();
		int inc = 0;
		while (Files.exists(Paths.get(newFilePath))) {
			inc++;
			newFilePath = FOLDER + "/" + inc + "_" + path.getFileName();
		}
		
		try {
			Files.copy(path, Paths.get(newFilePath));
		} catch (IOException e) {
			System.out.println("Unable to copy file to " + newFilePath);
		}
		
//		System.out.println("newFilePath: " + newFilePath);
//		System.out.println("path: " + path.toString());
	}
	
	private static void collectFileOperations() {
		System.out.println("Please choose 1, 2, 3, or4:");
		String option = scanner.nextLine();
		switch (option) {
			case "1":
				addAFile();
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
		}
		showFileOperation();
	}
	
	private static void showFileOperation() {
		System.out.println("------------");
		System.out.println("1.) Add a file");
		System.out.println("2.) Delete a file");
		System.out.println("3.) Search for a file");
		System.out.println("4.) Back to main menu");
		System.out.println("------------");
		collectFileOperations();
	}
	
	private static void showFilesInAscendingOrder() {
		System.out.println("Showing files in ascending order");
		System.out.println("coming...");
	
		File[] files = new File(FOLDER).listFiles();
		
		Set<String> sorted = new TreeSet<>();
		
		for(File file : files) {
			if (!file.isFile()) {
				continue;	
			}
			sorted.add(file.getName());
		}
		
		sorted.forEach(System.out::println);
	}
	
	private static void showMainMenu() {
		System.out.println("-- MAIN MENU --");
		System.out.println("1.) Shoe files in ascending order");
		System.out.println("2.) Perform file operations");
		System.out.println("3.) Exit Application");
		collectMainMenuOption();
	}
	
	public static void showWelcomeScreen() {
		System.out.println("------------");
		System.out.println("Application: LockedMe.com");
		System.out.println("Developer: Alejandro Linan");
		System.out.println("------------");
	}
}
