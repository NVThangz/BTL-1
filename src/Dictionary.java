import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> listWords = new ArrayList<Word>();

    public ArrayList<Word> getWords() {
        return listWords;
    }

    public Word getWord(int i) {
        return listWords.get(i);
    }

    public String getWord_target(int i) {
        return listWords.get(i).getWord_target();
    }

    public String getWord_explain(int i) {
        return listWords.get(i).getWord_explain();
    }

    public void addWord(Word e) {
        listWords.add(e);
    }

    public int size() {
        return listWords.size();
    }

    public void removeWord(int i) {
        listWords.remove(i);
    }

}
