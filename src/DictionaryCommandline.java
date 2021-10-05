public class DictionaryCommandline {
    public static void showAllWords() {
        System.out.println("No\t|English\t|Vietnamese");
        for (int i = 0; i<Dictionary.words.size(); i++) {
            System.out.print((i + 1) + "\t");
            System.out.println(Dictionary.words.get(i).getWord_target() + "\t\t\t" + Dictionary.words.get(i).getWord_explain());
        }
    }

    public static void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    public static void main(String[] args) {
        DictionaryManagement.insertFromFile();
        showAllWords();
        DictionaryManagement.dictionaryLookup();
    }
}
