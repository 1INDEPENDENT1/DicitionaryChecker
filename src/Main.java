import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter the path to the text file: ");
        String dictionary = new Scanner(System.in).nextLine().trim();
        Converter converter = new Converter();
        converter.textToArray(dictionary);
        Set<Integer> checkRepeat = new TreeSet<>();
        List<Word> wrongWords = new ArrayList<>();
        boolean isMistake;

        while (checkRepeat.size() != converter.getAllWords().size()) {
            int random = (int) (Math.random() * (converter.getAllWords().size()));
            if (checkRepeat.contains(random)) {
                continue;
            }
            checkRepeat.add(random);
            int engOrOther = (int) (Math.random() * ((2 - 1) + 1) + 1);
            if (engOrOther == 1) {
                System.out.print("Translate the word: " + converter.getWord(random).getEnglishTrans() + " - ");
                String input = new Scanner(System.in).nextLine().trim().toLowerCase();
                if (input.equals("break system")){
                    break;
                }
                isMistake = true;
                for(String world : converter.getWord(random).getForeignTrans()){
                    Pattern pattern = Pattern.compile(world);
                    Matcher matcher = pattern.matcher(input);
                    if (matcher.find()) {
                        System.out.println("Right");
                        isMistake = false;
                    }
                }
                if(isMistake){
                    System.out.println("Wrong! " + "Correct option: " + converter.getWord(random));
                    System.out.println("Do you want to add this translation?(Y/N)");
                    String inputAgree = new Scanner(System.in).nextLine().trim().toLowerCase();
                    if (inputAgree.equals("y")){
                        converter.getWord(random).setForeignTrans(input);
                        System.out.println("The word was added into dictionary");
                    }else {
                        wrongWords.add(converter.getWord(random));
                        System.out.println("The word was entered into the mistake dictionary");
                    }
                }
            }

            if(engOrOther == 2){
                System.out.print("Translate the word: " + converter.getWord(random).getForeignTrans() + " - ");
                String input = new Scanner(System.in).nextLine().trim().toLowerCase();
                if (input.equals("break system")){
                    break;
                }
                isMistake = true;
                for(String world : converter.getWord(random).getEnglishTrans()){
                    Pattern pattern = Pattern.compile(world);
                    Matcher matcher = pattern.matcher(input);
                    if (matcher.find()) {
                        System.out.println("Right");
                        isMistake = false;
                    }
                }
                if(isMistake){
                    System.out.println("Wrong! " + "Correct option: " + converter.getWord(random));
                    System.out.println("Do you want to add this translation?(Y/N)");
                    String inputAgree = new Scanner(System.in).nextLine().trim().toLowerCase();
                    if (inputAgree.equals("y")){
                        converter.getWord(random).setForeignTrans(input);
                        System.out.println("The word was added into dictionary");
                    }else {
                        wrongWords.add(converter.getWord(random));
                        System.out.println("The word was entered into the mistake dictionary");
                    }
                }
            }
        }
        for (Word word : wrongWords){
            System.out.println(word);
        }
    }
}