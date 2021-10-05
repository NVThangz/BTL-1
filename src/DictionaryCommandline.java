import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class DictionaryCommandline {
    public static void showAllWords() {
        System.out.println("No\t|English\t|Vietnamese");
        for (int i = 0; i<Dictionary.words.size(); i++) {
            System.out.print((i + 1) + "\t");
            System.out.println("|" + Dictionary.words.get(i).getWord_target() + "\t\t\t|" + Dictionary.words.get(i).getWord_explain());
        }
    }

    public static void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    public static void dictionaryAdvanced() {
        DictionaryManagement.insertFromFile();
        showAllWords();
        DictionaryManagement.dictionaryLookup();
    }

    public static void dictionarySearcher() {
        boolean isFound = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ cần tìm");
        String s = sc.nextLine();
        for (int i = 0; i < Dictionary.words.size(); i ++) {
            if(Dictionary.words.get(i).getWord_target().toLowerCase().startsWith(s.toLowerCase())) {
                System.out.println(Dictionary.words.get(i).getWord_target() + "\t" + Dictionary.words.get(i).getWord_explain());
                isFound = true;
            }
        }
        if(!isFound ) {
            System.out.println("Từ cần tìm không tồn tại");
        }
    }

    public static void main(String[] args) {
    }
}
