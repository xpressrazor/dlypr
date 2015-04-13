import java.util.*;

public class MultiplicationWithoutRecursion implements Multiplication {
    public int multiply(List<Integer> list) {
        int product = 1;
		for (Integer number : list) {
			product *= number;
		}

		return product;
    }
}
