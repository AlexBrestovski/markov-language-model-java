package hw1;

/**
 * @author Aleksandar Brestovski
 * Written: 12/02/2026
 * 
 * Converts a matrix of character counts into a matrix of probabilities {@link MatrixProbabilities#createMatrixProbabilities(int[][])}.
 * 
 * Each row of the resulting matrix represents a probability distribution
 * for transitions from one character to all other characters.
 */

public class MatrixProbabilities {
	
	/**
     * Creates a transition probability matrix from a count matrix.
     *
     * @param matrixC a 26x26 matrix containing transition counts.
     * @return a 26x26 matrix where each row sums to 1.0.
     */
	
	public double[][] createMatrixProbabilities(int[][] matrixC){
		double[][] matrixP = new double[26][26];
		double sum = 0.0;
		
		for(int i = 0; i < matrixC.length; i++) {
			for(int j = 0; j < matrixC[0].length; j++) {
				matrixC[i][j] ++;
			}
		}
		
		
		for(int i = 0; i < matrixC.length; i++) {
			sum = 0.0;
			for(int j = 0; j < matrixC[0].length; j++) {
				sum += matrixC[i][j];
			}
			
			if(sum == 0.0) 
				for(int j = 0; j < matrixC[0].length; j++) {
						matrixP[i][j] = 1.0 / 26.0;
				}
				else
					for(int j = 0; j < matrixC[0].length; j++)
						matrixP[i][j] = (double)matrixC[i][j] / sum;
		}
		
		return matrixP;
		
	}
}
