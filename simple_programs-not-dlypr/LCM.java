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

	private static ArrayList<Integer> multiple(int x) {
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

	private static int multiply(List<Integer> list) {
		if (list.isEmpty())
			return 1;
		else
			return (list.get(0) * multiply(list.subList(1, list.size())));
	}

	private static int multiplywithoutrecursion(List<Integer> list) {
		int product = 1;
		for (Integer number : list) {
			product *= number;
		}

		return product;
	}

	private static int lcm(int number1, int number2) {
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
		return multiply(multiplesUnion);
	}


	public static void printlcm(int number1, int number2) {
		System.out.println("LCM of " + number1 + " " + number2 + " is " + lcm(number1, number2));
	}
	
    public static void main(String[] args) {
		printlcm(3, 4);
		printlcm(30, 45);
		printlcm(4, 12);
    }
}
