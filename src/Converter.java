import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    private final List<Word> allWords = new ArrayList<>();

    public List<Word> getAllWords() {
        return allWords;
    }

    public void textToArray(String string) throws IOException {

        List<String> words = Files.readAllLines(Path.of(string));
        for(String word : words){
            String[] fragment = word.split("-");
            allWords.add(new Word(fragment[0].trim().toLowerCase(), fragment[1].trim().toLowerCase()));
        }
    }

    public Word getWord(int index){
        return allWords.get(index);
    }
}
