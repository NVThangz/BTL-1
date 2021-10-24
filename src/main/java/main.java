import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.EventListenerList;

public class main {
    public static void main(String[] args) {
        DictionaryCommandline a = new DictionaryCommandline();
        a.dictionaryAdvanced();
        //DictionaryManagement.updateDictionary();
        new DictionaryApplication();
    }
}
