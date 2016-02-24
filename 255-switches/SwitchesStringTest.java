/**
 * [2016-02-22] Challenge #255 [Easy] Playing with light switches
 * https://www.reddit.com/r/dailyprogrammer/comments/46zm8m/20160222_challenge_255_easy_playing_with_light/
 * Usage: $time java SwitchesTest < lots_of_switches.txt
 * Link: https://raw.githubusercontent.com/fsufitch/dailyprogrammer/master/ideas/switches/lots_of_switches.txt
 */ 
import java.util.Scanner;

public class SwitchesStringTest
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        StringBuilder switches = new StringBuilder();
        SwitchesStringTest switchesTest = new SwitchesStringTest();
        
        switchesTest.buildSwitches(switches, N, '0');

        while (scanner.hasNext()) {
            int end1 = scanner.nextInt();
            int end2 = scanner.nextInt();

            int start = Math.min(end1, end2);
            int end = Math.max(end1, end2);
            
            switchesTest.toggleSwitches(switches, start, end); 
        }

        System.out.println(switchesTest.getSwitchesCount(switches));
    }

    public void toggleSwitches(StringBuilder switches, int start, int end)
    {
        for (int i = start; i <= end; i++) {
            if (switches.charAt(i) == '0')
                switches.setCharAt(i, '1');
            else
                switches.setCharAt(i, '0');
        }
    }

    public int getSwitchesCount(StringBuilder switches)
    {
        int count = 0;
        for (int i = 0; i < switches.length(); i++) {
            if (switches.charAt(i) == '1')
                count++;
        }
        return count;
    }

    public void buildSwitches(StringBuilder switches, int N, char state)
    {
        for (int i = 0; i < N; i++)
            switches.append(state);
    }

}
