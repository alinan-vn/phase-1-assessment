package filesInAscendingOrder;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

public class FilesOrder {
	final static String FOLDER = "src/storage";
	
	public static void showFilesInAscendingOrder() {
		System.out.println("++++++++++++++++++++");
		System.out.println("++++++++++++++++++++");
		System.out.println("Showing files in ascending order....");
		System.out.println("");
		System.out.println("");
		
		File[] files = new File(FOLDER).listFiles();
		Set<String> sorted = new TreeSet<>();
		for(File file : files) {
			if (!file.isFile()) {
				continue;
			}
			sorted.add(file.getName());
		}
		
		sorted.forEach(System.out::println);
		
		System.out.println("");
		System.out.println("");
		System.out.println("++++++++++++++++++++");
		System.out.println("++++++++++++++++++++");
	}
	
}
