/**
 * File: LCM.java
 * Purpose: Find lowest common multipe (LCM)
 * Definition: Smallest number that is multiple of both
 *     LCM of 3 and 4 is 12
 *     LCM of 4 and 12 is 12
 * Solution:
 * Find the multiples of each number
 * From one of the list remove common elements.
 * Once common elements are removed from that list, copy elements from both list into a temporary buffer list
 * Multiply all the values.
 */

import java.util.*;

public class LCM {
    
    public Multiplication multiplication;
    
    public LCM(Multiplication multiplication) { this.multiplication = multiplication; }
    
	private ArrayList<Integer> multiple(int x) {
		ArrayList<Integer> multipleNumbers = new ArrayList<Integer>();

		// Not checking anything below 2, could be error
		int intermediate = x;
		for(int i = 2; i < x; i++) {
			if (intermediate % i == 0) {
				while (intermediate %i == 0) {
					multipleNumbers.add(i);
					intermediate /= i;

					if (intermediate == 0)
						break;
				}
			}

			if (intermediate == 0)
				break;
		}

		if (intermediate != 0)
			multipleNumbers.add(intermediate);

		return multipleNumbers;
	}


	public int lcm(int number1, int number2) {
		ArrayList<Integer> multiples1 = multiple(number1);
		ArrayList<Integer> multiples2 = multiple(number2);

		for(Integer mul1: multiples1) {
			int indexOfMul1 = -1;
			if ((indexOfMul1 = multiples2.indexOf(mul1)) != -1) {
				multiples2.remove(indexOfMul1);
			}
		}

		ArrayList<Integer> multiplesUnion = (ArrayList<Integer>) multiples1.clone();
		
		multiplesUnion.addAll(multiples2);
		return multiplication.multiply(multiplesUnion);
	}	
}
