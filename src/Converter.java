import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    private final List<Word> allWords = new ArrayList<>();
    private final HashMap<String, String> words = new HashMap<>();

    public List<Word> getAllWords() {
        return allWords;
    }

    public void textToArray(String string) throws IOException {

        List<String> words = Files.readAllLines(Path.of(string));
        for(String word : words){
            String[] fragment = word.split("-");
            List<String> englishWords = Arrays.stream(fragment[0].split(",")).map(String::trim).
                    map(String::toLowerCase).collect(Collectors.toList());
            List<String> foreignWords = Arrays.stream(fragment[1].split(",")).map(String::trim)
                    .map(String::toLowerCase).collect(Collectors.toList());
            allWords.add(new Word(englishWords, foreignWords));
        }
    }

    public Word getWord(int index){
        return allWords.get(index);
    }
}
