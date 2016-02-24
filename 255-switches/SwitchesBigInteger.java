import java.math.BigInteger;
import java.util.Scanner;

public class SwitchesBigInteger
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        BigInteger switches = new BigInteger("2");
        switches = switches.pow(N);

        SwitchesBigInteger switchesTest = new SwitchesBigInteger();

        while (scanner.hasNext()) {
            int end1 = scanner.nextInt();
            int end2 = scanner.nextInt();

            int start = Math.min(end1, end2);
            int end = Math.max(end1, end2);

            switches = switchesTest.toggleSwitches(switches, start, end);
        }

        // Clear the highest order bit for this number
        switches = switches.flipBit(N);

        System.out.println(switches.bitCount());
    }

    public BigInteger toggleSwitches(BigInteger switches, int start, int end) {
        for (int i = start; i <= end; i++) {
            switches = switches.flipBit(i);
        }

        return switches;
    }
}
