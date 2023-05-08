public class Word {
    private final String englishTrans;
    private final String russianTrans;

    public Word(String englishTrans, String russianTrans){
        this.englishTrans = englishTrans;
        this.russianTrans = russianTrans;
    }

    public String getEnglishTrans() {
        return englishTrans;
    }

    public String getRussianTrans() { return russianTrans; }

    @Override
    public String toString() {
        return englishTrans + " - " + russianTrans;
    }
}
