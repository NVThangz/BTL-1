public class DictionaryCommandline {
    public static void showAllWords(Dictionary dictionary) {
        System.out.println("No\t|English\t|Vietnamese");
        for (int i = 0; i<dictionary.words.size(); i++) {
            System.out.print((i + 1) + "\t");
            System.out.println(dictionary.words.get(i).getWord_target() + "\t\t\t" + dictionary.words.get(i).getWord_explain());
        }
    }

    public static void dictionaryBasic() {
        showAllWords(DictionaryManagement.insertFromCommandline());
    }
}
