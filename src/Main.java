import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("Введите путь до текстового файла: ");
        String dictionary = new Scanner(System.in).nextLine();
        Converter converter = new Converter();
        converter.textToArray(dictionary);
        Set<Integer> checkRepeat = new TreeSet<>();
        List<Word> wrongWords = new ArrayList<>();
        while (checkRepeat.size() != converter.getAllWords().size()) {
            int random = (int) (Math.random() * (converter.getAllWords().size()));
            if (checkRepeat.contains(random)) {
                continue;
            }
            checkRepeat.add(random);
            int engOrRus = (int) (Math.random() * ((2 - 1) + 1) + 1);
            if (engOrRus == 1) {
                System.out.print("Переведите слово: " + converter.getWord(random).getEnglishTrans() + " - ");
                String input = new Scanner(System.in).nextLine();
                Pattern pattern = Pattern.compile(converter.getWord(random).getRussianTrans());
                Matcher matcher = pattern.matcher(input);
                if (input.equals("break system")){
                    break;
                }
                if (matcher.find()) {
                    System.out.println("Правильно");
                } else {
                    wrongWords.add(converter.getWord(random));
                    System.out.println("Не правильно! " + "Правильный вариант: " + converter.getWord(random));
                }
            }

            if(engOrRus == 2){
                System.out.print("Переведите слово: " + converter.getWord(random).getRussianTrans() + " - ");
                String input = new Scanner(System.in).nextLine();
                Pattern pattern = Pattern.compile(converter.getWord(random).getEnglishTrans());
                Matcher matcher = pattern.matcher(input);
                if (input.equals("break system")){
                    break;
                }
                if (matcher.find()) {
                    System.out.println("Правильно");
                } else {
                    wrongWords.add(converter.getWord(random));
                    System.out.println("Не правильно! " + "Правильный вариант: " + converter.getWord(random));
                }
            }
        }
        for (Word word : wrongWords){
            System.out.println(word);
        }
    }
}