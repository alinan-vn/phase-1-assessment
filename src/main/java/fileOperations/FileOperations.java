package fileOperations;

import initialDisplays.Welcome;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileOperations {
	
	static Scanner scanner = new Scanner(System.in);
	final static String FOLDER = "src/storage";

	public static void showFileOperations() {
		System.out.println("------++++++============++++++------");
		System.out.println("1. Add a file");
		System.out.println("2. Delete a file");
		System.out.println("3. Search for a file");
		System.out.println("4. Back to main menu");
		System.out.println("5. Close the Application");
		System.out.println("------++++++============++++++------");
		
		String chooseOperation = scanner.nextLine();
		handleFileOperations(chooseOperation);
	}
	
	public static void handleFileOperations(String action) {
		switch(action) {
			case "1":
				System.out.println("Accessing 'Add' Operation...");
				addAFile();
				break;
			case "2":
				System.out.println("Accessing 'Delete' Operation...");
				deleteAFile();
				break;
			case "3":
				System.out.println("Accessing 'Search' Operation");
				searchAFile();
				break;
			case "4":
				System.out.println("Getting the Main Menu...");
				Welcome.mainMenuOptions();
				break;
			case "5":
				System.out.println("Exiting application...");
				System.exit(0);
				break;				
			default:
				System.out.println("Invalid input, please input a 1, 2, 3, or 4");
		}
		showFileOperations();
	}
	
	public static void addAFile() throws InvalidPathException {
		System.out.println("+");
		System.out.println("+");
		System.out.println("+");
		System.out.println("Please provide a file path, starting from your C:// directory (ex. /example-folder/example-file.txt)");
		
		String inputFilePath = scanner.nextLine();
		Path path = Paths.get(inputFilePath);
		
		if (!Files.exists(path)) {
			System.out.println("File does not exist..");
			return;
		}else {
			System.out.println("File Found! Processing...");
			
		}
		
		String newFilePath = FOLDER + "/" + path.getFileName();
		int i = 0;
		while (Files.exists(Paths.get(newFilePath))) {
			i++;
			newFilePath = FOLDER + "/" + i + "_" + path.getFileName();
		}
		
		try {
			Files.copy(path,  Paths.get(newFilePath));
			System.out.println("Processed and copied to new location at: " + path.getFileName());
		} catch (IOException e) {
			System.out.println("Unable to copy file to " + newFilePath);
			System.out.println("IOException error message: " + e);
		}
		System.out.println("+");
		System.out.println("+");
		System.out.println("+");
	}
	
	public static void deleteAFile() throws InvalidPathException {
		System.out.println("-");
		System.out.println("-");
		System.out.println("-");
		System.out.println("Please provide file name within src/storage/ directory to be deleted (ex. file-name.txt");
		
		String fileNameInput = scanner.nextLine();
		Path path = Paths.get(FOLDER + "/" + fileNameInput);
		
		if (!Files.exists(path)) {
			System.out.println("File does not exist, cannot be deleted");
			return;
		} else {
			System.out.println("File found!");
		}
		
		File fileToDelete = new File(FOLDER + "/" + fileNameInput);
		
		try {
			fileToDelete.delete();
			System.out.println("File successfully deleted!");
		} catch (Exception e) {
			System.out.println("Unable to delete file: " + fileNameInput);
			System.out.println("Exception error message: " + e);
		}
		
		System.out.println("-");
		System.out.println("-");
		System.out.println("-");
	}
	
	public static void searchAFile() throws InvalidPathException{
		System.out.println("''");
		System.out.println("''");
		System.out.println("''");
		System.out.println("Please provide a file name (ex. file-name.txt");
		String fileNameInput = scanner.nextLine();
		
		String filePath = FOLDER + "/" + fileNameInput;
		
		if(!Files.exists(Paths.get(filePath))) {
			System.out.println("File not found!");
			return;
		} else {
			System.out.println("File Found! Path: " + filePath);
		}
		
		System.out.println("''");
		System.out.println("''");
		System.out.println("''");

	}
}
