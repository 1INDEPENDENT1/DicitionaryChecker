import java.util.List;

public class Word {
    private final List<String> englishTrans;
    private final List<String> foreignTrans;

    public Word(List<String> englishTrans, List<String> foreignTrans){
        this.englishTrans = englishTrans;
        this.foreignTrans = foreignTrans;
    }

    public List<String> getEnglishTrans() {
        return englishTrans;
    }

    public List<String> getForeignTrans() { return foreignTrans; }

    public void setEnglishTransTrans(String englishWord){
        foreignTrans.add(englishWord);
    }

    public void setForeignTrans(String foreignWord){
        foreignTrans.add(foreignWord);
    }

    @Override
    public String toString() {
        return englishTrans + " - " + foreignTrans;
    }
}
