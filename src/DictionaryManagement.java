import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryManagement {
    public static Dictionary insertFromCommandline() {
        Dictionary dictionary = new Dictionary();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Nhập số lượng từ vựng");
        int n = sc1.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập từ và nghĩa");
            Scanner sc2 = new Scanner(System.in);
            Word temp = new Word(sc2.nextLine(), sc2.nextLine());
            dictionary.words.add(temp);
        }
        return dictionary;
    }
}
