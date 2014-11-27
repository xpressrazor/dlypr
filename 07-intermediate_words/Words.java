import java.util.*;
import java.util.stream.*;
import java.nio.file.*;
import java.io.IOException;
// By http://www.reddit.com/user/Dutsj
public class Words {
    public static void main(String[] args) throws IOException {
        Set<String> words = Files.lines(Paths.get("enable1.txt"))
            .collect(Collectors.toSet());
    String containsMost = "";
    String[] mostSubWords = new String[0];

    for(String word : words){
        List<String> subStrings = new ArrayList<>();

        for(int i = 0; i < word.length(); ++i){
            for(int j = i + 2; j <= word.length(); ++j){
                subStrings.add(word.substring(i, j));
            }
        }

        String[] subWords = subStrings.stream()
                .filter(words::contains)
                .distinct()
                .toArray(String[]::new);

        if(subWords.length > mostSubWords.length){
            containsMost = word;
            mostSubWords = subWords;
        }
    }
    Arrays.sort(mostSubWords);
    System.out.println("Word with most subwords: " + containsMost);
    System.out.println("Number of subwords: " + mostSubWords.length);
    System.out.println("Subwords: ");
    for(String word : mostSubWords) {
        System.out.println(word);
    }
    }
}
