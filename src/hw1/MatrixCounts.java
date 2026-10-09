package hw1;

/**
 * @author Aleksandar Brestovski
 * Written: 12/02/2026
 * 
 * Creates a matrix of character transition counts.
 * 
 * Each entry (i, j) in the matrix represents how many times the character
 * corresponding to i is followed by the character corresponding to j
 * in the input character sequence.
 */

public class MatrixCounts {
	
	/**
     * Builds a 26x26 matrix of bigram counts from a character array.
     *
     * @param c an array of lowercase alphabetic characters.
     * @return a 26x26 integer matrix containing transition counts.
     */
	
	public int[][] createMatrixCounts(char[] c){
		int[][] matrixC = new int[26][26];
		
		for(int i = 0; i < c.length  - 1; i++) {
			if(c[i] >= 'a' && c[i] <= 'z' && c[i + 1] >= 'a' && c[i + 1] <= 'z')
			matrixC[c[i] - 'a'][c[i + 1] - 'a'] ++;
		}
			
		return matrixC;
				
	}
}
