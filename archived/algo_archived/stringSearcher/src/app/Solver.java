package app;

import java.util.Arrays;

public class Solver {

	private boolean matchHayAndNeedle(final char[] hay, final char[] needle) {
		
		if (hay.length != needle.length) {
			return false;
		}
		
		// return false if even one atom doesn't match
		for (int atomNumber = 0; atomNumber < hay.length; atomNumber++) {
			if (hay[atomNumber] != needle[atomNumber]) {
				return false;
			}
		}
		// control in function even after for loop ended
		// => all atoms matched.
		
		return true;
	}

	// returns -1 if not found
	public int getNeedlePosition(final char[] haystack, final char[] needle) {

		final int needleLength = needle.length;
		
		// Go from haystack beginning to haystackEnd-needleLength
		// check each hay encountered along the way for needle equality
		// if that hay turns out to be needle return that hay's index
		
		for (int hayNumber = 0; hayNumber < (haystack.length - needle.length); hayNumber++) {

			// current hay of same length as needle =  
			// Arrays.asList(haystack).subList(hayNumber, hayNumber + needleLength)
			
			if (matchHayAndNeedle(Arrays.copyOfRange(haystack, hayNumber, hayNumber + needleLength), 
				              needle)){
				
				return hayNumber;
			}
		}
		
		// needle not found
		return -1;
	}
}
