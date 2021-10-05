import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class DictionaryManagement {
    public static void insertFromCommandline() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Nhập số lượng từ vựng");
        int n = sc1.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập từ và nghĩa");
            Scanner sc2 = new Scanner(System.in);
            Word temp = new Word(sc2.nextLine(), sc2.nextLine());
            Dictionary.words.add(temp);
        }
    }

    public static void insertFromFile() {
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
                Dictionary.words.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dictionaryLookup() {
        boolean isFound = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ cần tìm");
        String s = sc.nextLine();
        for (int i = 0; i < Dictionary.words.size(); i ++) {
            if(Objects.equals(Dictionary.words.get(i).getWord_target(), s)) {
                System.out.println(Dictionary.words.get(i).getWord_target() + "\t" + Dictionary.words.get(i).getWord_explain());
                isFound = true;
            }
        }
        if(!isFound ) {
            System.out.println("Từ cần tìm không tồn tại");
        }
    }

    public static void delete() {
        boolean isFound = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ cần xóa");
        String s = sc.nextLine();
        for (int i = 0; i < Dictionary.words.size(); i ++) {
            if(Objects.equals(Dictionary.words.get(i).getWord_target(), s)) {
                Dictionary.words.remove(i);
                isFound = true;
            }
        }
        if(!isFound) {
            System.out.println("Từ cần xóa không tồn tại");
        }
    }

    public static void dictionaryExportToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Dictionary.txt"));
            for (int i = 0; i < Dictionary.words.size(); i ++) {
                bw.write(Dictionary.words.get(i).getWord_target() + "\t" + Dictionary.words.get(i).getWord_explain() + "\n");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
