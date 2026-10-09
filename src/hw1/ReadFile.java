package hw1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Aleksandar Brestovski
 * Written: 12/02/2026
 * 
 * Reads a corpus text file and extracts only lowercase alphabetic characters.
 * 
 * The file is read line by line, all characters are converted to lowercase,
 * and any non-alphabetic characters are ignored. The resulting characters
 * are returned as a one-dimensional array so we can get later on the probabilities of transitions and the counts.
 */

public class ReadFile {
	
	Scanner sc;
	
	/**
     * Reads the contents of a file and returns all valid alphabetic characters.
     *
     * @param filename the name of the file to read.
     * @return a character array containing only lowercase letters a–z.
     * @throws FileNotFoundException if the specified file cannot be found.
     */
	
	public char[] readFile(String filename) throws FileNotFoundException  {
		int cntlines = 0;
		sc = new Scanner(new File(filename));
		
		while (sc.hasNextLine()) {
			cntlines++;
			sc.nextLine();
		}
		
		sc.close();
		
		String[] lines = new String[cntlines];
		
		sc = new Scanner(new File(filename));

		for (int i = 0; i < cntlines; i++)
			lines[i] = sc.nextLine().toLowerCase();
		
		sc.close();

		char[][] c = new char[cntlines][];

		for (int i = 0; i < cntlines; i++) {
			c[i] = new char[lines[i].length()];
			for (int j = 0; j < lines[i].length(); j++) {
				if ((lines[i].charAt(j)) >= 'a' && (lines[i].charAt(j) <= 'z'))
					c[i][j] = lines[i].charAt(j);
			}
		}
		
		int totalChars = 0;
		
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[i].length; j++) {
				if(c[i][j] >= 'a' && c[i][j] <= 'z')
					totalChars++;
			}
		}
		
		char[] ch = new char[totalChars];
		int k = 0;
		
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[i].length; j++) {
				if(c[i][j] >= 'a' && c[i][j] <= 'z') {
				ch[k] = c[i][j];
				k++;
				}
			}
		}
		
		return ch;
		
	}

}
