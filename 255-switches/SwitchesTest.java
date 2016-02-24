/**
 * [2016-02-22] Challenge #255 [Easy] Playing with light switches
 * https://www.reddit.com/r/dailyprogrammer/comments/46zm8m/20160222_challenge_255_easy_playing_with_light/
 */ 
import java.util.Scanner;

public class SwitchesTest
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        boolean[] switches = new boolean[N];

        SwitchesTest switchesTest = new SwitchesTest();

        while (scanner.hasNext()) {
            int end1 = scanner.nextInt();
            int end2 = scanner.nextInt();

            int start = Math.min(end1, end2);
            int end = Math.max(end1, end2);
            
            switchesTest.toggleSwitches(switches, start, end); 
        }

        System.out.println(switchesTest.getSwitchesCount(switches));
    }

    public void toggleSwitches(boolean[] switches, int start, int end)
    {
        for (int i = start; i <= end; i++) {
            switches[i] = !switches[i];
        }
    }

    public int getSwitchesCount(boolean[] switches)
    {
        int count = 0;
        for (int i = 0; i < switches.length; i++) {
            if (switches[i])
                count++;
        }
        return count;
    }

}
