import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class DictionaryManagement {
    private Dictionary dictionary = new Dictionary();

    public DictionaryManagement(Dictionary dictionary) {
        this.dictionary = dictionary;
    }


    public void insertFromCommandline() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Nhập số lượng từ vựng");
        int n = sc1.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập từ và nghĩa");
            Scanner sc2 = new Scanner(System.in);
            Word temp = new Word(sc2.nextLine(), sc2.nextLine());
            dictionary.addWord(temp);
        }
    }

    public void insertFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Dictionary.txt"));
            ArrayList<String> w = new ArrayList<String>();

            String line;
            while ((line = br.readLine()) != null) {
                w.addAll(Arrays.asList(line.split("\t")));
            }
            br.close();
            for (int i = 0; i < w.size(); i += 2) {
                Word temp = new Word(w.get(i), w.get(i + 1));
                dictionary.addWord(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dictionaryLookup() {
        boolean isFound = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ cần tìm");
        String s = sc.nextLine();
        for (int i = 0; i < dictionary.size(); i++) {
            if (Objects.equals(dictionary.getWord_target(i), s)) {
                System.out.println(dictionary.getWord_target(i) + "\t" + dictionary.getWord_explain(i));
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Từ cần tìm không tồn tại");
        }
    }

    public void delete() {
        boolean isFound = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ cần xóa");
        String s = sc.nextLine();
        for (int i = 0; i < dictionary.size(); i++) {
            if (Objects.equals(dictionary.getWord_target(i), s)) {
                dictionary.removeWord(i);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Từ cần xóa không tồn tại");
        }
    }

    public void dictionaryExportToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Dictionary.txt"));
            for (int i = 0; i < dictionary.size(); i++) {
                bw.write(dictionary.getWord_target(i) + "\t" + dictionary.getWord_explain(i) + "\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void speak(String text) {
        TextToSpeech speech = new TextToSpeech(text);
        speech.speakText();
    }

    public void speakWord_target(int i) {
        TextToSpeech speech = new TextToSpeech(dictionary.getWord_target(i));
        speech.speakText();
    }

    public void speakWord_explain(int i) {
        TextToSpeech speech = new TextToSpeech(dictionary.getWord_explain(i));
        speech.speakText();
    }


    public void insertFromDatabase(String name) {
        SQLiteJDBC sqlite = new SQLiteJDBC();
        sqlite.readDatabase(dictionary,name);
    }

    public void dictionaryExportToDatabase(String name) {
        SQLiteJDBC sqlite = new SQLiteJDBC();
        sqlite.overwriteDatabase(dictionary,name);
    }

}
