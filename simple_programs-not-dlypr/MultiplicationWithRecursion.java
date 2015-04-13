import java.util.*;

public class MultiplicationWithRecursion implements Multiplication {
    public int multiply(List<Integer> list) {
        if (list.isEmpty())
			return 1;
		else
			return (list.get(0) * multiply(list.subList(1, list.size())));
    }
}
