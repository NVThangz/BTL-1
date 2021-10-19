import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLiteJDBC {
    public SQLiteJDBC(Dictionary dictionary, String name) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Dictionary.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + name + ";");
            while (rs.next()) {
                String word_target = rs.getString("word");
                String word_explain = rs.getString("description");
                String pronounce = rs.getString("pronounce");
                Word word = new Word(word_target, word_explain, pronounce);
                dictionary.addWord(word);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
