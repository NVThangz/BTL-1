import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

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

    public void TextToSpeech(String text) {
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
        if (voice != null) {
            voice.allocate();
        }
        try {
            voice.setRate(120);
            voice.setPitch(120);
            voice.setVolume(10);
            voice.speak(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SpeechWord_target(int i) {
        TextToSpeech(listWords.get(i).getWord_target());
    }

    public void SpeechWord_explain(int i) {
        TextToSpeech(listWords.get(i).getWord_explain());
    }


}
