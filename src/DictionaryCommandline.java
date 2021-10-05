import java.util.Scanner;

public class DictionaryCommandline {
    public void showAllWords(Dictionary dictionary) {
        System.out.println("No\t|English\t\t|Vietnamese");
        for (int i = 0; i < dictionary.size(); i++) {
            System.out.print((i + 1) + "\t");
            System.out.println("|" + dictionary.getWord_target(i) + "\t\t\t|" + dictionary.getWord_explain(i));
        }
    }

    public void dictionaryBasic() {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement management = new DictionaryManagement(dictionary);
        while (true) {
            showAllWords(dictionary);
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            if (t == 1) management.insertFromCommandline();
            if (t == 2) break;
        }
    }

    public void dictionaryAdvanced() {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement management = new DictionaryManagement(dictionary);
        management.insertFromFile();
        while (true) {
            showAllWords(dictionary);
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            if (t == 1) management.insertFromCommandline();
            if (t == 2) management.delete();
            if (t == 3) management.dictionaryLookup();
            if (t == 4) dictionarySearcher(dictionary);
            if (t == 5) management.dictionaryExportToFile();
            if (t == 6) break;
        }
    }

    public void dictionarySearcher(Dictionary dictionary) {
        boolean isFound = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ cần tìm");
        String s = sc.nextLine();
        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.getWord_target(i).toLowerCase().startsWith(s.toLowerCase())) {
                System.out.println(dictionary.getWord_target(i) + "\t" + dictionary.getWord_explain(i));
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Từ cần tìm không tồn tại");
        }
    }

    public static void main(String[] args) {
        DictionaryCommandline test = new DictionaryCommandline();
        test.dictionaryBasic();
    }
}
